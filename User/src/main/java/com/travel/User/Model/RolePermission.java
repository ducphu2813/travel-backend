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
@Document(collection = "role_permission")
public class RolePermission {

    @Id
    public String id;
    public String roleName;
    public String table;
    public List<String> action;
}
