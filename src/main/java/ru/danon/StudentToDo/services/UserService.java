package ru.danon.StudentToDo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.danon.StudentToDo.enums.Role;
import ru.danon.StudentToDo.models.RoleAuditLog;
import ru.danon.StudentToDo.models.User;
import ru.danon.StudentToDo.repositories.RoleAuditLogRepository;
import ru.danon.StudentToDo.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleAuditLogRepository roleAuditLogRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleAuditLogRepository roleAuditLogRepository) {
        this.userRepository = userRepository;
        this.roleAuditLogRepository = roleAuditLogRepository;
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public User register(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void changeUserRole(Integer userId, Integer changedById, Role role) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<User> changerOptional = userRepository.findById(changedById);

        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Пользователь с ID " + userId + " не найден");
        }
        if (changerOptional.isEmpty()) {
            throw new IllegalArgumentException("Изменяющий пользователь с ID " + changedById + " не найден");
        }

        User user = userOptional.get();
        User changer = changerOptional.get();

        Role oldRole = user.getRole();

        user.setRole(role);
        userRepository.save(user);

        //Логируем изменения
        RoleAuditLog log = new RoleAuditLog();
        log.setUser(user);
        log.setOldrole(oldRole);
        log.setNewRole(role);
        log.setChangedByUser(changer);
        log.setChangedAt(LocalDateTime.now());

        roleAuditLogRepository.save(log);

    }

    public boolean authenticate(String email, String password){
        return false;
    }

    public List<RoleAuditLog> getRoleChangeHistory(Integer userId){
        return roleAuditLogRepository.findByUserId(userId);
    }
}
