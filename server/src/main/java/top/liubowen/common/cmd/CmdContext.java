package top.liubowen.common.cmd;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liubowen
 * @date 2017/11/1 20:26
 * @description cmd消息处理器管理类
 */
@Component
@Slf4j
public class CmdContext {

    private Map<Integer, ICmd> cmdMap = Maps.newHashMap();

    public void addCmd(Integer cmd, ICmd bean) {
        this.cmdMap.put(cmd, bean);
    }

    public ICmd getCmd(Integer cmd) {
        if (!this.cmdMap.containsKey(cmd)) {
            return null;
        }
        return this.cmdMap.get(cmd);
    }

}
