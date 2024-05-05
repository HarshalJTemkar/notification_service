package harshal.temkar.notification_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import harshal.temkar.notification_service.model.Notification;

public interface NotificationDao extends JpaRepository<Notification, String> {

}
