package ru.danon.StudentToDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danon.StudentToDo.enums.Status;
import ru.danon.StudentToDo.models.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByStatus(Status status);
    List<Task> findByTitleContainingOrDescriptionContaining(String keyword, String keyword2);
}
