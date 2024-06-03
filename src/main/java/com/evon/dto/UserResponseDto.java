package com.evon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {

    private int id;

    private String name;

    private String email;

    private String password;

    private String about;

    private boolean deleted;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
