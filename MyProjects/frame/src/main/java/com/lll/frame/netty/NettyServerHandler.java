package com.lll.frame.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * NettyServerHandler
 * NettyServerHandler配置这里是实现业务逻辑的地方
 * @Author zl
 * @Create 2019-04-15 11:10
 **/
@Component
@ChannelHandler.Sharable
@Slf4j
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {


    @Value("${netty.close.byte}")
    private String nettyCloseByte;

    /**
     * 接收消息， 并对消息进行业务处理
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) {
        log.info("client msg:" + msg);
        String clientIdToLong = ctx.channel().id().asLongText();
        log.info("client long id:" + clientIdToLong);
        String clientIdToShort = ctx.channel().id().asShortText();
        log.info("client short id:" + clientIdToShort);
        if (msg.contains(nettyCloseByte)) {
            //close
            System.err.println("close ----> : " + nettyCloseByte);
            ctx.channel().close();
        } else {
            //send to client
            ctx.channel().writeAndFlush("Yoru msg is:" + msg);

        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        log.info("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");
        /**
         * 第一次回复消息
         */
        ctx.channel().writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");

        super.channelActive(ctx);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("\nChannel is disconnected");
        System.err.println("disconnected ... ");
        super.channelInactive(ctx);
    }

}
