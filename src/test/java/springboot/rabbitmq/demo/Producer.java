package springboot.rabbitmq.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class Producer {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void testSendEmail() {
        String msg = "send email to user";
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPICS,"inform.email",msg);
    }

}
