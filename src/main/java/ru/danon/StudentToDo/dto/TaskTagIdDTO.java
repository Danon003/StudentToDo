package ru.danon.StudentToDo.dto;

public class TaskTagIdDTO {
    private Integer taskId;

    private Integer tagId;

    public TaskTagIdDTO() {}

    public TaskTagIdDTO(Integer taskId, Integer tagId) {
        this.taskId = taskId;
        this.tagId = tagId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}
