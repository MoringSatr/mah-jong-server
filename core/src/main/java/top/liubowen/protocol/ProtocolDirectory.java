package top.liubowen.protocol;

import top.liubowen.annotation.ProtocolType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zhu zeng
 *
 */
public class ProtocolDirectory {

    private Map<Short, ProtocolElement> directory;

    public ProtocolDirectory(List<Class<?>> classes) {
        directory = new HashMap<>();
        load(classes);
    }

    public void load(List<Class<?>> classes) {
        for (Class<?> clazz : classes) {
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof ProtocolType) {
                    parseClass(clazz);
                }
            }
        }
    }

    private void parseClass(Class<?> clazz) {
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            try {
                ProtocolElement pe = new ProtocolElement(clazz, field);
                this.directory.put(pe.code, pe);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // ignore
            }

        }
    }

    public ProtocolElement findProtocolElement(short code) {
        return directory.get(code);
    }

}
