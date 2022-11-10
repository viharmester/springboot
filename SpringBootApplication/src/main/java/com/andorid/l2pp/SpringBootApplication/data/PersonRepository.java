package com.andorid.l2pp.SpringBootApplication.data;

import com.andorid.l2pp.SpringBootApplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
