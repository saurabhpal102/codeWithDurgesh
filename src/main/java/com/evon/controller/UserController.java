package com.evon.controller;

import com.evon.dto.UserRequestDto;
import com.evon.dto.UserResponseDto;
import com.evon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto createUserDto = userService.createUser(userRequestDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

//    @GetMapping("{/id}")
//    public UserResponseDto getUserById(@PathVariable("id") int id);
//
//    @PutMapping("{/id}")
//    public UserResponseDto updateUser(@PathVariable("id") int id, @RequestBody UserRequestDto userRequestDto);
//
//    @GetMapping
//    public List<UserResponseDto> getAllUser();
//
//    @DeleteMapping("/{id}")
//    public UserResponseDto deleteUser(@PathVariable("id") int id);
}
