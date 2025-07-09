package ru.danon.StudentToDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danon.StudentToDo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
