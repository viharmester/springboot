package com.andorid.l2pp.SpringBootApplication.controllers;

import com.andorid.l2pp.SpringBootApplication.models.Person;
import com.andorid.l2pp.SpringBootApplication.service.PersonService;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    private final SimpleMeterRegistry meterRegistry;

    @GetMapping("/person")
    public String getAllPerson(Model model)
    {
        meterRegistry.counter("person.getAllPerson").increment();
        model.addAttribute("person", personService.getAllPerson());
        return "person";
    }

    @GetMapping("person/add")
    public String addPerson() {
        return "person-form";
    }

    @PostMapping("/person/add")
    public String addPerson(@ModelAttribute("addPerson") Person person, Model model) {
        personService.saveOrUpdate(person);
        model.addAttribute("person", personService.getAllPerson());
        return "person";
    }

    @GetMapping("/person/edit/{id}")
    public String getPersonToEdit(Model model, @PathVariable("id") int personId) {

        model.addAttribute("editPerson", personService.getPersonById(personId));

        return "person-edit";
    }

    @PostMapping("/person/edit/{id}")
    public String updatePerson(@ModelAttribute("editPerson") Person person, @PathVariable("id") String personId,
                                 Model model) {
        personService.saveOrUpdate(person);

        model.addAttribute("person", personService.getAllPerson());
        return "person";
    }

    @GetMapping("/person/delete/{id}")
    public String deletePerson(Model model, @PathVariable("id") int personId) {
        personService.delete(personId);
        model.addAttribute("person", personService.getAllPerson());
        return "person";
    }
}
