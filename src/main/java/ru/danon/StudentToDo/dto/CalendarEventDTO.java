package ru.danon.StudentToDo.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CalendarEventDTO {

    private Integer id;

    private Integer userId;

    private Integer taskId;

    @NotNull(message = "Название события не должно быть пустым")
    private String title;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public CalendarEventDTO() {}

    public CalendarEventDTO(Integer id, Integer userId, Integer taskId, String title,
                            LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.userId = userId;
        this.taskId = taskId;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
