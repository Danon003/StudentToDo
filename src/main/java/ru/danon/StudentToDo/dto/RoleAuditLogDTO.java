package ru.danon.StudentToDo.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class RoleAuditLogDTO {
    private Integer id;

    private Integer userId;

    @NotNull(message = "Старая роль не должна быть пустой")
    private String oldRole;

    @NotNull(message = "Новая роль не должна быть пустой")
    private String newRole;

    private Integer changedById;

    private LocalDateTime changedAt;

    public RoleAuditLogDTO() {}

    public RoleAuditLogDTO(Integer id, Integer userId, String oldRole, String newRole,
                           Integer changedById, LocalDateTime changedAt) {
        this.id = id;
        this.userId = userId;
        this.oldRole = oldRole;
        this.newRole = newRole;
        this.changedById = changedById;
        this.changedAt = changedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOldRole() {
        return oldRole;
    }

    public void setOldRole(String oldRole) {
        this.oldRole = oldRole;
    }

    public String getNewRole() {
        return newRole;
    }

    public void setNewRole(String newRole) {
        this.newRole = newRole;
    }

    public Integer getChangedById() {
        return changedById;
    }

    public void setChangedById(Integer changedById) {
        this.changedById = changedById;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
}
