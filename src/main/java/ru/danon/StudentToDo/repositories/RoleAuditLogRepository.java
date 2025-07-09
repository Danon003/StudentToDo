package ru.danon.StudentToDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danon.StudentToDo.models.RoleAuditLog;

@Repository
public interface RoleAuditLogRepository extends JpaRepository<RoleAuditLog, Integer> {
}
