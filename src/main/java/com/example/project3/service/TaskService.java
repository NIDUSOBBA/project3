package com.example.project3.service;

import com.example.project3.dto.TaskDto;
import com.example.project3.model.Task;
import com.example.project3.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }

    public void updateSave(Task task, TaskDto taskDto){
        if(taskDto.getTitle() != null){
            task.setTitle(taskDto.getTitle());
        }
        if(taskDto.getDescription() != null){
            task.setDescription(taskDto.getDescription());
        }
        if(taskDto.getCompleted() != null){
            task.setCompleted(taskDto.getCompleted());
        }
        taskRepository.save(task);
    }
}
