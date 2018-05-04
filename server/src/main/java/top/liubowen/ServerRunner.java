package top.liubowen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.SocketIOServer;

import top.liubowen.common.scanner.MessageClassContext;

/**
 * Created by 刘博文 on 2017/10/24.
 */
@Component
public class ServerRunner implements CommandLineRunner {

    @Autowired
    private SocketIOServer server;

    @Bean
    public MessageClassContext getMessageClassContext() {
        MessageClassContext messageClassContext = new MessageClassContext();
        messageClassContext.init();
        return messageClassContext;
    }

    @Override
    public void run(String... args) throws Exception {
        server.start();
    }
}
