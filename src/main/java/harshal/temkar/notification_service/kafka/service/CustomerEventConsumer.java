package harshal.temkar.notification_service.kafka.service;

import java.util.Date;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import harshal.temkar.notification_service.kafka.model.Customer;
import harshal.temkar.notification_service.model.Notification;
import harshal.temkar.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerEventConsumer {

	private final NotificationService notificationService;

	@KafkaListener(topics = "${kafka.topic.customerRegistered}")
	public void consumeCustomerRegisteredEvent(Customer customer) {
		log.info("CustomerEventConsumer ==> consumeCustomerRegisteredEvent ==> Start");
		Notification notification = Notification.builder().customerid(customer.getId()).date(new Date())
				.message("Welcome").build();
		notificationService.saveNotification(notification);
	}
}
