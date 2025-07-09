package ru.danon.StudentToDo.repositories.composits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danon.StudentToDo.models.TaskAssignment;
import ru.danon.StudentToDo.models.id.TaskAssignmentId;

@Repository
public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, TaskAssignmentId> {
}
