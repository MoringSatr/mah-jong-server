package top.liubowen.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liubowen
 * @date 2018/5/11 16:25
 * @description 注入模块
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ModuleInject {

    String value() default "";

    boolean lazy() default false;

}
