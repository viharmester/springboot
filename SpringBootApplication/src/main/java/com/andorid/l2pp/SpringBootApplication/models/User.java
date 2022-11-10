package com.andorid.l2pp.SpringBootApplication.models;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@RequiredArgsConstructor
public class User {

    private final String userName;
    private final String password;
    private Collection<GrantedAuthority> listOfGrantedAuthoorities = new ArrayList<>();
}
