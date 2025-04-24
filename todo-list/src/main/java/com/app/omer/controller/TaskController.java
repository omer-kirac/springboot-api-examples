package com.app.omer.controller;

import com.app.omer.entity.Task;
import com.app.omer.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/find/{id}")
    public ResponseEntity<Task> findTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.findTask(id));
    }

    @GetMapping("/find-all-tasks")
    public ResponseEntity<List<Task>> findAllTasks(@RequestParam(required = false) Long userId) {
        return ResponseEntity.ok(taskService.findAllTasksByUserId(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return ResponseEntity.created(URI.create("/task/" + task.getId())).body(task);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
