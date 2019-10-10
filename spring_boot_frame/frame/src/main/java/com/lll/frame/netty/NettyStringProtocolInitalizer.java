package com.lll.frame.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * NettyStringProtocolInitalizer
 * netty服务器初始化配置
 * @Author zl
 * @Create 2019-04-15 11:09
 **/
@Component
public class NettyStringProtocolInitalizer extends ChannelInitializer<SocketChannel> {

    @Autowired
    StringDecoder stringDecoder;

    @Autowired
    StringEncoder stringEncoder;

    @Autowired
    NettyServerHandler serverHandler;

    @Override
    protected void initChannel(SocketChannel channel) {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast("decoder", stringDecoder);
        pipeline.addLast("handler", serverHandler);
        pipeline.addLast("encoder", stringEncoder);

        /**
         * 编解码器
         */
        pipeline.addLast(new HttpServerCodec());
        /**
         * 对大数据流处理
         */
        pipeline.addLast(new ChunkedWriteHandler());
        /**
         * 对httpmessage进行聚合，聚合成fullhttprequest或fullhttpresponse
         * 几乎在netty中的编程都会使用到此hanler
         */
        pipeline.addLast(new HttpObjectAggregator(1024*64));

        //===================以上是用于支持http协议===================

        /**
         * websocket服务器处理的协议，用于指定给客户端连接访问的路由
         */
        pipeline.addLast(
                new WebSocketServerProtocolHandler("/ws"));

        //自定义拦截器
        //pipeline.addLast(new ChatHandler());
    }

}
