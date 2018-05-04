package top.liubowen.common.scanner;

import com.google.common.collect.Maps;
import top.liubowen.annotation.ClientProtocolType;
import top.liubowen.annotation.Element;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author liubowen
 * @date 2017/11/8 17:41
 * @description
 */
public class MessageClassContext {

    private Map<Integer, Class<?>> messageClassMap = Maps.newHashMap();

    public void addMessageClass(int cmd, Class<?> clazz) {
        this.messageClassMap.put(cmd, clazz);
    }

    public Class<?> get(int cmd) {
        return this.messageClassMap.get(cmd);
    }

    public void init() {
        this.scanProtocolClass();
    }

    /** 扫描协议 */
    private void scanProtocolClass() {
        List<Class<?>> clazzs = ClassScanner.scan("top.liubowen.*", "*.jar");
        clazzs.forEach(clazz -> {
            if (clazz.getAnnotation(ClientProtocolType.class) != null) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    try {
                        Element element = field.getAnnotation(Element.class);
                        int cmd = (Integer) field.get(null);
                        Class<?> messageClazz = element.value();
                        this.addMessageClass(cmd, messageClazz);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
