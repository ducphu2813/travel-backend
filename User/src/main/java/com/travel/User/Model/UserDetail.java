package com.travel.User.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "user_detail")
public class UserDetail {

    @Id
    private String id;
    private String userId;
    private String fullName;
    private String phoneNumber;
}
