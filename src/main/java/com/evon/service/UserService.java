package com.evon.service;

import com.evon.dto.UserRequestDto;
import com.evon.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto getUserById(int id);

    UserResponseDto updateUser(int id, UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUser();

    UserResponseDto deleteUser(int id);
}
