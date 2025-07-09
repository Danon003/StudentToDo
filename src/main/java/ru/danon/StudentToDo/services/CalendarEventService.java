package ru.danon.StudentToDo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.danon.StudentToDo.models.CalendarEvent;
import ru.danon.StudentToDo.models.Task;
import ru.danon.StudentToDo.models.User;
import ru.danon.StudentToDo.repositories.CalendarEventRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalendarEventService {

    private final CalendarEventRepository calendarEventRepository;

    @Autowired
    public CalendarEventService(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    /**
     * Создаёт событие в календаре на основе задачи
     */
    public CalendarEvent createCalendarEvent(Task task, User user, LocalDateTime startTime, LocalDateTime endTime) {
        CalendarEvent event = new CalendarEvent();
        event.setUser(user);
        event.setTask(task);
        event.setTitle(task.getTitle());
        event.setStartTime(startTime);
        event.setEndTime(endTime);

        return calendarEventRepository.save(event);
    }

    /**
     * Возвращает все события пользователя
     */
    public List<CalendarEvent> getEventsByUserId(Integer userId) {
        return calendarEventRepository.findByUserId(userId);
    }

    /**
     * Возвращает событие по ID
     */
    public CalendarEvent getEventById(Integer eventId) {
        return calendarEventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Событие не найдено"));
    }

    /**
     * Обновляет существующее событие
     */
    public CalendarEvent updateCalendarEvent(Integer eventId, LocalDateTime newStart, LocalDateTime newEnd) {
        CalendarEvent event = getEventById(eventId);
        event.setStartTime(newStart);
        event.setEndTime(newEnd);
        return calendarEventRepository.save(event);
    }

    /**
     * Удаляет событие из календаря
     */
    public void deleteCalendarEvent(Integer eventId) {
        if (!calendarEventRepository.existsById(eventId))
            throw new IllegalArgumentException("Событие с ID " + eventId + " не существует");

        calendarEventRepository.deleteById(eventId);
    }

    /**
     * Проверяет, пересекаются ли временные интервалы событий
     */
    public boolean isTimeOverlap(Integer userId, LocalDateTime start, LocalDateTime end) {
        List<CalendarEvent> events = getEventsByUserId(userId);

        for (CalendarEvent event : events)
            if (event.getStartTime().isBefore(end) && event.getEndTime().isAfter(start))
                return true; // Есть пересечение

        return false;
    }
}
