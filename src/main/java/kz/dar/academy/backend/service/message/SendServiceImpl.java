package kz.dar.academy.backend.service.message;

import kz.dar.academy.backend.model.TaskResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendServiceImpl implements SendService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String message) {
        log.info("Task: " + message);
        kafkaTemplate.send("employee-topic", message);
    }
}
