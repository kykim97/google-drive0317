package google.drive.listener;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import google.drive.dto.event.FileDeleted;
import google.drive.dto.event.FileUploaded;
import google.drive.service.VideoService;
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
    groupId = "videoProcessing",
    containerFactory = "kafkaListenerContainerFactory",
    contentTypeConverter = "smartMessageConverter"
)
public class PolicyHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        PolicyHandler.class
    );

    @Autowired
    VideoService videoService;

    @KafkaHandler
    public void wheneverFileUploaded_ProcessVideo(
        @Payload FileUploaded fileUploaded,
        Acknowledgment acknowledgment,
        @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
        @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey
    ) {
        // Sample Logic //
        // Video video = new Video();
        // videoService.save(video);

        acknowledgment.acknowledge();
    }

    @KafkaHandler
    public void wheneverFileDeleted_DeleteVideo(
        @Payload FileDeleted fileDeleted,
        Acknowledgment acknowledgment,
        @Nullable @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
        @Nullable @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey
    ) {
        // Sample Logic //
        // Video video = new Video();
        // videoService.save(video);

        acknowledgment.acknowledge();
    }

    @KafkaHandler(isDefault = true)
    public void listenDefault(Object object, Acknowledgment acknowledgment) {
        System.out.println(
            "[Info] Unhandled Event from Kafka broker: " + object.toString()
        );
        acknowledgment.acknowledge();
    }
}
