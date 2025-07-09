package ru.danon.StudentToDo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;
import ru.danon.StudentToDo.enums.Role;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "Пароль не должен быть пустым")
    @Size(min = 2, max = 255, message = "Пароль должен быть от 2 до 255 символов")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 255, message = "Имя должно быть от 2 до 255 символов")
    @Column(name = "name")
    private String name;

    @NotNull(message = "email не должен быть пустым")
    @UniqueElements
    @Email
    @Column(name = "email")
    private String email;

    @NotNull(message = "Роль не должна быть пустым")
    @Size(min = 2, max = 10, message = "Роль может быть от 2 до 10 символов")
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role = Role.STUDENT;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login")
    private LocalDateTime last_login;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserGroup> userGroups;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CalendarEvent> calendarEvents;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<RoleAuditLog> roleAuditLogs;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CalendarEvent> getCalendarEvents() {
        return calendarEvents;
    }

    public void setCalendarEvents(List<CalendarEvent> calendarEvents) {
        this.calendarEvents = calendarEvents;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<RoleAuditLog> getRoleAuditLogs() {
        return roleAuditLogs;
    }

    public void setRoleAuditLogs(List<RoleAuditLog> roleAuditLogs) {
        this.roleAuditLogs = roleAuditLogs;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }
}
