package ru.danon.StudentToDo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.danon.StudentToDo.models.Group;
import ru.danon.StudentToDo.models.User;
import ru.danon.StudentToDo.models.UserGroup;
import ru.danon.StudentToDo.models.id.UserGroupId;
import ru.danon.StudentToDo.repositories.GroupRepository;
import ru.danon.StudentToDo.repositories.composits.UserGroupRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final UserGroupRepository userGroupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserGroupRepository userGroupRepository) {
        this.groupRepository = groupRepository;
        this.userGroupRepository = userGroupRepository;
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public void addUserToGroup(Integer groupId, Integer userId) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (groupOptional.isEmpty())
            throw new IllegalArgumentException("Group not found");

        Group group = groupOptional.get();
        UserGroupId userGroupId = new UserGroupId();
        userGroupId.setUserId(userId);
        userGroupId.setGroupId(groupId);

        if(userGroupRepository.existsById(userGroupId))
            throw new IllegalArgumentException("User group already exists");

        UserGroup userGroup = new UserGroup();
        userGroup.setId(userGroupId);
        userGroup.setUser(new User());
        userGroup.getUser().setId(userId);
        userGroup.setGroup(group);
        userGroup.setCreatedAt(LocalDateTime.now());

        userGroupRepository.save(userGroup);
    }

    public List<Group> findGroupsByUserId(Integer userId) {
        return groupRepository.findGroupsByUserId(userId);
    }

    public void deleteGroup(Integer groupId) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (groupOptional.isEmpty()) {
            throw new IllegalArgumentException("Группа с ID " + groupId + " не найдена");
        }

        Group group = groupOptional.get();

        try {
            groupRepository.delete(group);
        } catch (Exception e) {
            // Ошибка может быть вызвана ограничением RESTRICT (есть записи в user_groups)
            throw new RuntimeException("Невозможно удалить группу. Возможно, в ней ещё есть пользователи.", e);
        }

    }

    public void deleteUserGroup(Integer groupId, Integer userId) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (groupOptional.isEmpty()) {
            throw new IllegalArgumentException("Группа с ID " + groupId + " не найдена");
        }

        UserGroupId userGroupId = new UserGroupId();
        userGroupId.setUserId(userId);
        userGroupId.setGroupId(groupId);

        if (!userGroupRepository.existsById(userGroupId)) {
            throw new IllegalArgumentException("Пользователь с ID " + userId + " не состоит в группе с ID " + groupId);
        }

        userGroupRepository.deleteById(userGroupId);

    }

}
