package top.liubowen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liubowen
 * @date 2017/11/7 18:25
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ServerProtocolType {

    short[] value() default { 0, Short.MAX_VALUE };
}
