package harshal.temkar.notification_service.kafka.service;

import java.util.Date;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import harshal.temkar.notification_service.kafka.model.Reservation;
import harshal.temkar.notification_service.model.Notification;
import harshal.temkar.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReservationEventConsumer {

	private final NotificationService notificationService;

	@KafkaListener(topics = "${kafka.topic.reservationCreated}")
	public void consumeReservationRegisteredEvent(Reservation reservation) {
		log.info("ReservationEventConsumer ==> consumeReservationRegisteredEvent ==> Start");
		Notification notification = Notification.builder().customerid(reservation.getCustomerid()).date(new Date())
				.message("Welcome").build();
		notificationService.saveNotification(notification);
	}
}
