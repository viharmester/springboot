package com.andorid.l2pp.SpringBootApplication.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @Column(name = "PERSON_ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
}
