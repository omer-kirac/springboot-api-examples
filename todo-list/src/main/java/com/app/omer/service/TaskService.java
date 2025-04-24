package com.app.omer.service;

import com.app.omer.entity.Task;
import com.app.omer.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task findTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> findAllTasksByUserId(Long userId) {
        return taskRepository.findAllByUserUserId(userId);
    }


    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id) {

        Task task = taskRepository.findById(id).orElse(null);
        task.setTitle(task.getTitle());
        task.setDescription(task.getDescription());
        return taskRepository.save(task);
    }

    public void delete(Long id) {
         taskRepository.deleteById(id);
    }
}
