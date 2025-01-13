package com.example.project3.service;

import com.example.project3.model.Person;
import com.example.project3.repository.PersonRepository;
import com.example.project3.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> byUsername = Optional.ofNullable(personRepository.findByUsername(username));

        if(byUsername.isEmpty()) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new PersonDetails(byUsername.get());
    }
}
