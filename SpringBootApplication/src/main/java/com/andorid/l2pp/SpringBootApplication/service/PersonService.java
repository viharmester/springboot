package com.andorid.l2pp.SpringBootApplication.service;

import java.util.List;

import com.andorid.l2pp.SpringBootApplication.data.PersonRepository;
import com.andorid.l2pp.SpringBootApplication.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public Person getPersonById(int id) {
        return personRepository.findById(id).orElseThrow();
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }

    public void saveOrUpdate(Person person) {
        personRepository.save(person);
    }

}
