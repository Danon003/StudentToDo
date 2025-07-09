package ru.danon.StudentToDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danon.StudentToDo.models.CalendarEvent;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Integer> {
}
