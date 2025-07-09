package ru.danon.StudentToDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danon.StudentToDo.models.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
