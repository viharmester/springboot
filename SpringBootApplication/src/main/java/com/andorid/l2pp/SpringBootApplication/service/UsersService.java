package com.andorid.l2pp.SpringBootApplication.service;

import com.andorid.l2pp.SpringBootApplication.data.UsersDBQuery;
import com.andorid.l2pp.SpringBootApplication.helpers.UsersHelper;
import com.andorid.l2pp.SpringBootApplication.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService {

    private UsersDBQuery usersDBQuery;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = usersDBQuery.getUserDetails(username);
            return new UsersHelper(user);
        } catch (Exception e){
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the databas!");
        }
    }
}
