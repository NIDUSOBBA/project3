package com.example.project3.util;

import com.example.project3.dto.PersonDto;
import com.example.project3.dto.TaskDto;
import com.example.project3.model.Person;
import com.example.project3.model.Task;
import com.example.project3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityMapper {

    private final PersonService personService;

    @Autowired
    public EntityMapper(PersonService personService) {
        this.personService = personService;
    }

    public Person mapPerson(PersonDto personDto){
        Person person = new Person();
        person.setUsername(personDto.getUsername());
        person.setAge(personDto.getAge());
        person.setEmail(personDto.getEmail());
        person.setPassword(personDto.getPassword());
        return person;
    }

    public Task mapTask(TaskDto taskDto){
        Task task = new Task();
        task.setCustomers(personService.findById(taskDto.getCustomers()));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.getCompleted());
        return task;
    }

    public TaskDto mapTaskDto(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setCustomers(task.getCustomers().getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setCompleted(task.isCompleted());
        return taskDto;
    }


}
