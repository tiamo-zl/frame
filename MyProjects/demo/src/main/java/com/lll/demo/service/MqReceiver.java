package com.lll.demo.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * ClassName MqReceiver
 * <p>
 * Description
 *
 * @Author zl
 * @Create 2019-05-16 17:33
 **/
@Component
public class MqReceiver {

  /**
   * 接收消息
   * @param message
   * @param headers
   * @param channel
   */
   @RabbitHandler
   public void  getMessage(
      @Payload Object message,
      @Headers Map<String, Object> headers,
      Channel channel) throws IOException {

       System.err.println("get message ...  ");
       System.err.println(message);
       System.err.println("end... ");
       //ack
//       Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//       channel.basicAck(deliveryTag, false);
    }

}
