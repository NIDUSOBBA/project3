package com.example.project3.controller;

import com.example.project3.dto.PersonDto;
import com.example.project3.service.RegistrationService;
import com.example.project3.util.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final EntityMapper personMapper;
    private final RegistrationService registrationService;

    @Autowired
    public PersonController(EntityMapper personMapper, RegistrationService registrationService) {
        this.personMapper = personMapper;
        this.registrationService = registrationService;
    }

    @PostMapping("/registration")
    public String registration(@RequestBody PersonDto personDto) {

        registrationService.register(personMapper.mapPerson(personDto));
        return HttpStatus.OK.toString();
    }

}
