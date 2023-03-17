package google.drive.listener;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import google.drive.service.FileService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(
    topics = "google.drive",
    groupId = "drive",
    containerFactory = "kafkaListenerContainerFactory",
    contentTypeConverter = "smartMessageConverter"
)
public class PolicyHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        PolicyHandler.class
    );

    @Autowired
    FileService fileService;

    @KafkaHandler(isDefault = true)
    public void listenDefault(Object object, Acknowledgment acknowledgment) {
        System.out.println(
            "[Info] Unhandled Event from Kafka broker: " + object.toString()
        );
        acknowledgment.acknowledge();
    }
}
