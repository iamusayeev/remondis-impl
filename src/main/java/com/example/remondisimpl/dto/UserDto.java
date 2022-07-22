package com.example.remondisimpl.dto;

 import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String name;
    private String email;
//    private String password;
    private LocalDate birthday;
    private String gender;
    private String role;
    private String skip;
    private String change;
    private AccountDto account;

}
