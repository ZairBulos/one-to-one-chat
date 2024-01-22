package com.zair.entities;

import com.zair.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter @Setter
public class User {

    @Id
    private String nickName;

    private String fullName;

    private UserStatus status;
}
