package springboot.rabbitmq.demo;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bobbyfeng
 */
@Configuration
public class RabbitConfig {
    public static final String QUEUE_EMAIL="QUEUE_EMAIL";
    public static final String QUEUE_SMS="QUEUE_SMS";
    public static final String EXCHANGE_TOPICS="EXCHANGE_TOPICS";
    public static final String ROUTING_KEY_EMAIL="inform.#.email.#";
    public static final String ROUTING_KEY_SMS="inform.#.sms.#";

    @Bean(EXCHANGE_TOPICS)
    public Exchange exchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS).durable(true).build();
    }

    @Bean(QUEUE_EMAIL)
    public Queue queueEmail() {
        return new Queue(QUEUE_EMAIL);
    }

    @Bean(QUEUE_SMS)
    public Queue queueSms() {
        return new Queue(QUEUE_SMS);
    }

    @Bean
    public Binding bindingEmail(@Qualifier(QUEUE_EMAIL) Queue queue,
                           @Qualifier(EXCHANGE_TOPICS) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_EMAIL).noargs();
    }

    @Bean
    public Binding bindingSms(@Qualifier(QUEUE_SMS) Queue queue,
                                @Qualifier(EXCHANGE_TOPICS) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_SMS).noargs();
    }
}
