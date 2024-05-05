package harshal.temkar.notification_service.kafka.service;

import java.util.Date;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Service;

import harshal.temkar.notification_service.kafka.model.ReservationKafka;
import harshal.temkar.notification_service.model.Notification;
import harshal.temkar.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReservationEventConsumer implements ConsumerSeekAware {

	private final NotificationService notificationService;

	@KafkaListener(topics = "${kafka.topic.reservationCreated}")
	public void consumeReservationCreatedEvent(ReservationKafka reservation) {
		log.info("ReservationEventConsumer ==> consumeReservationCreatedEvent ==> Start");
		Notification notification = Notification.builder().customerid(reservation.getCustomerid()).date(new Date())
				.message("Reserved").build();
		notificationService.saveNotification(notification);
	}
	
}
