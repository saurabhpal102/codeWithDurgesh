package com.evon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {

    private int id;

    private String name;

    private String email;

    private String password;

    private String about;
}
