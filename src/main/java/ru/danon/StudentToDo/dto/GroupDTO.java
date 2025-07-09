package ru.danon.StudentToDo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GroupDTO {
    private Integer id;

    @NotBlank(message = "Имя группы не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя группы должно быть от 2 до 100 символов")
    private String name;

    private String description;

    public GroupDTO() {}

    public GroupDTO(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
