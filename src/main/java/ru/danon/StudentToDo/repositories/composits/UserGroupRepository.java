package ru.danon.StudentToDo.repositories.composits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danon.StudentToDo.models.UserGroup;
import ru.danon.StudentToDo.models.id.UserGroupId;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, UserGroupId> {
}
