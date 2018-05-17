package top.liubowen.common.annotation.tools;

import javassist.CtClass;

public interface Patcher {

    boolean required(CtClass clazz) throws Throwable;

    void patch(CtClass clazz) throws Throwable;

}
