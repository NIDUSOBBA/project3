package com.example.project3;

import com.example.project3.service.PersonService;
import com.example.project3.util.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Project3Application {
    private final PersonService personService;

    @Autowired
    public Project3Application(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Project3Application.class, args);
    }

    @Bean
    public EntityMapper personMapper() {
        return new EntityMapper(personService);
    }

}
