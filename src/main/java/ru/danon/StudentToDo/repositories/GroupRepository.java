package ru.danon.StudentToDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danon.StudentToDo.models.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
