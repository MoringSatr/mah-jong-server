package top.liubowen.common.invoker;

import com.google.protobuf.ByteString;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liubowen
 * @date 2017/11/7 17:22
 * @description
 */
@AllArgsConstructor
@Getter
public class DecodeInvoker {

    private int cmd;

    private Class<?> clazz;

    private Method method;

    public <T> T invoke(Class clazz, ByteString bytes) {
        try {
            return (T) method.invoke(clazz, new Object[] { bytes });
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
