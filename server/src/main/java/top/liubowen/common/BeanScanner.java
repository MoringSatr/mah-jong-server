package top.liubowen.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import top.liubowen.annotation.Cmd;
import top.liubowen.common.cmd.CmdContext;
import top.liubowen.common.cmd.Command;

/**
 * @author liubowen
 * @date 2017/11/1 20:25
 * @description cmd消息处理器扫描类
 */
@Component
@Slf4j
public class BeanScanner implements BeanPostProcessor {

    @Autowired
    private CmdContext cmdContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        handleCmdAnnotation(bean);
        return bean;
    }

    /**
     * 处理CMD注解bean
     */
    private void handleCmdAnnotation(Object bean) {
        Class<?> clazz = bean.getClass();
        Cmd cmd = clazz.getAnnotation(Cmd.class);
        if (cmd == null) {
            return;
        }
        if (!ArrayUtils.contains(clazz.getInterfaces(), Command.class)) {
            log.error("CmdAnnotation not ICmd , className : {}", clazz.getName());
            return;
        }
        try {
            cmdContext.add((Command) bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
