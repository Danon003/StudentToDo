package ru.danon.StudentToDo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import jakarta.validation.constraints.Email;


public class UserDTO {

    private Integer id;

    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 255, message = "Имя должно быть от 2 до 255 символов")
    private String name;

    @Email(message = "Некорректный формат email")
    @NotBlank(message = "Email не должен быть пустым")
    private String email;

    @NotBlank(message = "Пароль не должен быть пустым")
    @Size(min = 2, max = 255, message = "Пароль должен быть от 2 до 255 символов")
    private String password;

    @NotBlank(message = "Роль не должна быть пустой")
    @Size(min = 2, max = 10, message = "Роль может быть от 2 до 10 символов")
    private String role;

    public UserDTO() {
    }

    public UserDTO(Integer id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
