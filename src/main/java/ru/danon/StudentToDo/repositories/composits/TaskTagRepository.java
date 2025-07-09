package ru.danon.StudentToDo.repositories.composits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danon.StudentToDo.models.TaskTag;
import ru.danon.StudentToDo.models.id.TaskTagId;

@Repository
public interface TaskTagRepository extends JpaRepository<TaskTag, TaskTagId> {
}
