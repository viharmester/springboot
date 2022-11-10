package com.andorid.l2pp.SpringBootApplication.helpers;

import org.springframework.security.core.userdetails.User;

// https://www.youtube.com/watch?v=af_2f1rrZdw&ab_channel=PixelTrice
public class UsersHelper extends User {

    public UsersHelper(com.andorid.l2pp.SpringBootApplication.models.User user) {
        super(user.getUserName(), user.getPassword(), user.getListOfGrantedAuthoorities());
    }
}
