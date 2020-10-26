package springboot.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class ReceiveHandler {
    @RabbitListener(queues = {RabbitConfig.QUEUE_EMAIL})
    public void receiveEmail(String msg, Message message, Channel channel) {
        System.out.println(msg);
    }

    @RabbitListener(queues = {RabbitConfig.QUEUE_SMS})
    public void receiveSms(String msg, Message message, Channel channel) {
        System.out.println(msg);
    }
}
