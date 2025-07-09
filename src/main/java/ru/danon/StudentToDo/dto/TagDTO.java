package ru.danon.StudentToDo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TagDTO {
    private Integer id;

    @NotBlank(message = "Имя тега не должно быть пустым")
    @Size(min = 2, max = 50, message = "Название тега должно быть от 2 до 50 символов")
    private String name;

    public TagDTO() {}

    public TagDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
