package com.lll.frame.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * NettyTcpServer
 * tcp服务的配置
 * @Author zl
 * @Create 2019-04-15 11:12
 **/
@Component
public class NettyTcpServer {

    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap serverBootstrap;

    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpPort;

    private ChannelFuture serverChannelFuture;

    @PostConstruct
    public void start() throws Exception {
        System.err.println("Starting server at " + tcpPort);
        serverChannelFuture = serverBootstrap.bind(tcpPort).sync();
    }

    @PreDestroy
    public void stop() throws Exception {
        System.err.println("stop ... ");
        serverChannelFuture.channel().closeFuture().sync();
    }

}
