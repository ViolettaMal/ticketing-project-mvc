package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private boolean enabled;
    private Gender gender;
    private UserRole userRole;


    public User(Long id, LocalDateTime insertDateTime, Long userId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String firstName, String lastName, String email, String phoneNumber, String password, boolean enabled, Gender gender, UserRole userRole) {
        super(id, insertDateTime, userId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.enabled = enabled;
        this.gender = gender;
        this.userRole = userRole;
    }
}
