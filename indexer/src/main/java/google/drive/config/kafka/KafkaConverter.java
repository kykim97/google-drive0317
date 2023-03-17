package google.drive.config.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skmove.muv.evrental.dto.event.AbstractEvent;
import google.drive.dto.event.Indexed;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.header.internals.RecordHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.DefaultKafkaHeaderMapper;
import org.springframework.kafka.support.KafkaHeaderMapper;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.SmartMessageConverter;

@Configuration
public class KafkaConverter {

    @Autowired
    ObjectMapper objectMapper;

    @Bean
    public SmartMessageConverter smartMessageConverter() {
        return new SmartMessageConverter() {
            KafkaHeaderMapper headerMapper = new DefaultKafkaHeaderMapper();

            @Override
            public Object fromMessage(
                Message<?> message,
                Class<?> targetClass
            ) {
                return fromMessage(message, targetClass, null);
            }

            @Override
            public Message<?> toMessage(
                Object payload,
                MessageHeaders headers
            ) {
                return null;
            }

            @Override
            public Object fromMessage(
                Message<?> message,
                Class<?> targetClass,
                Object conversionHint
            ) {
                MessageHeaders headers = message.getHeaders();
                Object payload = convertPayload(message.getPayload());
                Headers recordHeaders = new RecordHeaders();
                if (this.headerMapper != null) {
                    this.headerMapper.fromHeaders(headers, recordHeaders);
                }
                return payload;
            }

            @Override
            public Message<?> toMessage(
                Object payload,
                MessageHeaders headers,
                Object conversionHint
            ) {
                return null;
            }
        };
    }

    public Object convertPayload(Object payload) {
        try {
            if (!(payload instanceof String)) {
                return payload;
            }
            AbstractEvent abstractEvent = objectMapper.readValue(
                (String) payload,
                AbstractEvent.class
            );

            if (abstractEvent.getEventType().equals("Indexed")) {
                Indexed indexed = objectMapper.readValue(
                    (String) payload,
                    Indexed.class
                );
                return indexed;
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
