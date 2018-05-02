package top.liubowen.protocol;

import top.liubowen.annotation.Comment;
import top.liubowen.annotation.Element;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProtocolElement {

    public final short code;
    public final String name;// xxx.xxx
    public final String comment;
    public final Class<?> message;

    public ProtocolElement(Class<?> clazz, Field field) throws IllegalArgumentException, IllegalAccessException {
        this.code = field.getShort(null);
        this.name = parseName(clazz, field);
        this.comment = field.getAnnotation(Comment.class) == null ? "" : field.getAnnotation(Comment.class).value();
        this.message = field.getAnnotation(Element.class) == null ? Class.class : field.getAnnotation(Element.class).value();
    }

    private String parseName(Class<?> clazz, Field field) {
        return clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1) + "." + field.getName();
    }

    public String parseDetail(byte[] message) {
        return name + "[code=" + code + "; msg={" + parseMessage(message) + "}; comment=" + comment;
    }

    private String parseMessage(byte[] message) {
        if (!Class.class.equals(this.message)) {
            try {
                Method method = this.message.getMethod("parseFrom", byte[].class);
                return method.invoke(null, message).toString();
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            }
        }
        return "none";
    }

}
