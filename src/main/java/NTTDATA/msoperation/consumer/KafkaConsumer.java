package NTTDATA.msoperation.consumer;

import NTTDATA.msoperation.config.Util;
import NTTDATA.msoperation.entity.Operation;
import NTTDATA.msoperation.model.Transaction;
import NTTDATA.msoperation.service.OperationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
    @Autowired
    private OperationService operationService;
    @KafkaListener(topics = "${kafka.subscribed-topic.name}")
    public void consumeEvent(String message) throws JsonProcessingException,InterruptedException {
        Transaction transaction = Util.OBJECT_MAPPER.readValue(message, Transaction.class);
        operationService.processTransaction(transaction);
        log.info("Message received "+ message);
    }
}
