package com.andorid.l2pp.SpringBootApplication.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.andorid.l2pp.SpringBootApplication.models.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UsersDBQuery {

    private JdbcTemplate jdbcTemplate;

    public User getUserDetails(String username) {
        Collection<GrantedAuthority> listOfgrantedAuthorities = new ArrayList<>();
        String userSQLQuery = "SELECT * FROM USERS WHERE USERNAME=?";
        List<User> list = jdbcTemplate.query(userSQLQuery, new String[]{username},
            (ResultSet rs, int rowNum) -> new User(username, rs.getString("PASSWORD")));
        if (list.size() > 0) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
            listOfgrantedAuthorities.add(grantedAuthority);
            list.get(0).setListOfGrantedAuthoorities(listOfgrantedAuthorities);
            return list.get(0);
        }
        return null;
    }
}
