package com.example.project3.controller;

import com.example.project3.dto.TaskDto;
import com.example.project3.model.Task;
import com.example.project3.service.TaskService;
import com.example.project3.util.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final EntityMapper entityMapper;

    @Autowired
    public TaskController(TaskService taskService, EntityMapper entityMapper) {
        this.taskService = taskService;
        this.entityMapper = entityMapper;
    }

    @PostMapping("/registration")
    public String registration(@RequestBody TaskDto taskDto) {
        taskService.save(entityMapper.mapTask(taskDto));

        return HttpStatus.OK.toString();
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.findAll().stream().map(entityMapper::mapTaskDto).sorted(Comparator.comparing(TaskDto::getId)).collect(Collectors.toList());
    }

    @PutMapping("/update")
    public String updateTask(@RequestBody TaskDto taskDto) {
        taskService.updateSave(taskService.findById(taskDto.getId()),taskDto);

        return HttpStatus.OK.toString();
    }

    @DeleteMapping("/delete")
    public String deleteTask(@RequestBody TaskDto taskDto) {
        taskService.delete(taskDto.getId());
        return HttpStatus.OK.toString();
    }

}
