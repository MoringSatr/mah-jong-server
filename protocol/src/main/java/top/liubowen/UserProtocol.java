package top.liubowen;

import top.liubowen.annotation.ClientProtocolType;
import top.liubowen.annotation.Comment;
import top.liubowen.annotation.Element;
import top.liubowen.annotation.ServerProtocolType;
import top.liubowen.proto.CoreProto.LongMsg;
import top.liubowen.proto.UserProto.UserMsg;

/**
 * @author liubowen
 * @date 2018/5/2 12:54
 * @description
 */

public interface UserProtocol {

    @ClientProtocolType({ 10001, 10500 })
    interface Client {
        @Comment("用户登陆请求")
        @Element(LongMsg.class)
        int USER_LOGIN_REQ = 10001;
    }

    @ServerProtocolType({ 20001, 20500 })
    interface Server {
        @Comment("用户登陆返回")
        @Element(UserMsg.class)
        int USER_LOGIN_RET = 20001;
    }

}
