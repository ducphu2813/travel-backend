package com.travel.User.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "user")
public class User {

    @Id
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
