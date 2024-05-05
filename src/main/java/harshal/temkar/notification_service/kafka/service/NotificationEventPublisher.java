package harshal.temkar.notification_service.kafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import harshal.temkar.notification_service.kafka.model.NotificationKafka;
import harshal.temkar.notification_service.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class NotificationEventPublisher {

	private final KafkaTemplate<String, NotificationKafka> kafkaTemplate;

	@Value("${kafka.topic.notificationCreated}")
	private String notificationCreatedTopic;

	public void publishNotificationCreatedEvent(Notification notification) {
		log.info("NotificationEventPublisher ==> publishNotificationCreatedEvent ==> Start");
		NotificationKafka event = NotificationKafka.builder().customerid(notification.getCustomerid())
				.id(notification.getId()).date(notification.getDate()).message(notification.getMessage()).build();
		kafkaTemplate.send(notificationCreatedTopic, event);
	}
}
