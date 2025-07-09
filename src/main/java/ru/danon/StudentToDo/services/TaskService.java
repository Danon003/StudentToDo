package ru.danon.StudentToDo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.danon.StudentToDo.enums.Status;
import ru.danon.StudentToDo.models.Tag;
import ru.danon.StudentToDo.models.Task;
import ru.danon.StudentToDo.models.TaskAssignment;
import ru.danon.StudentToDo.models.User;
import ru.danon.StudentToDo.models.id.TaskAssignmentId;
import ru.danon.StudentToDo.repositories.TagRepository;
import ru.danon.StudentToDo.repositories.TaskRepository;
import ru.danon.StudentToDo.repositories.composits.TaskAssignmentRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TagRepository tagRepository;
    private final TaskAssignmentRepository taskAssignmentRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, TagRepository tagRepository, TaskAssignmentRepository taskAssignmentRepository) {
        this.taskRepository = taskRepository;
        this.tagRepository = tagRepository;
        this.taskAssignmentRepository = taskAssignmentRepository;
    }

    public Task createTask(Task task, Set<String> tagNames) {
        Set<Task> tags = new HashSet<>();
        for (String tagName : tagNames) {
            Optional<Tag> existingTag = tagRepository.findByName(tagName);

            Tag tag = existingTag.orElseGet(() -> {
                Tag t = new Tag();
                t.setName(tagName);
                return tagRepository.save(t);
            });

            tags.add((Task) tags);
        }

        return taskRepository.save(task);
    }

    public List<Task> findAllTasksByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> findTasksByUserId(Integer userId) {
        return taskAssignmentRepository.findByUserId(userId)
                .stream()
                .map(TaskAssignment::getTask)
                .toList();
    }

    public List<Task> searchTasks(String keyword) {
        return taskRepository.findByTitleContainingOrDescriptionContaining(keyword, keyword);
    }

    public Optional<Task> findTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void assignTaskToStudents(Task task, List<User> students, User assignedBy) {
        for (User student : students) {
            TaskAssignment assignment = new TaskAssignment();

            assignment.setTask(task);
            assignment.setUser(student);
            assignment.setAssignedBy(assignedBy);
            assignment.setAssignedAt(LocalDateTime.now());

            taskAssignmentRepository.save(assignment);
        }
    }
}
