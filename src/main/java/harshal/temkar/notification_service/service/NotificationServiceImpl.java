package harshal.temkar.notification_service.service;

import org.springframework.stereotype.Service;

import harshal.temkar.notification_service.dao.NotificationDao;
import harshal.temkar.notification_service.kafka.service.NotificationEventPublisher;
import harshal.temkar.notification_service.model.Notification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
	
	private final NotificationDao notificationDao;
	
	private final NotificationEventPublisher notificationEventPublisher;

	@Override
	public Notification saveNotification(Notification notification) {
		log.info("NotificationServiceImpl ==> saveNotification ==> Start");
		notification = notificationDao.save(notification);
		log.info("NotificationServiceImpl ==> saveNotification ==> publishReservationCreatedEvent ==> Start");
		notificationEventPublisher.publishNotificationCreatedEvent(notification);
		return notification;
	}

}
