package com.app.omer.controller;

import com.app.omer.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;


}
