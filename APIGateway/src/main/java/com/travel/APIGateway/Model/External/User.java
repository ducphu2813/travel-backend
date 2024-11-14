package com.travel.APIGateway.Model.External;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String username;
    private String password;
    private String email;
    private List<String> role;
    private List<String> department;

    public User(String username, String password, String email, List<String> role, List<String> department) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.department = department;
    }
}
