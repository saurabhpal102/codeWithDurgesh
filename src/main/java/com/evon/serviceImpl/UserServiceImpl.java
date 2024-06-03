package com.evon.serviceImpl;

import com.evon.dto.UserRequestDto;
import com.evon.dto.UserResponseDto;
import com.evon.exception.ResourceNotFoundException;
import com.evon.mapper.UserMapper;
import com.evon.model.User;
import com.evon.repository.UserRepository;
import com.evon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired(required = true)
    private UserMapper userMapper;

    private static final Boolean isDeletedTrue = false;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        User newUser = userRepository.save(user);
        return userMapper.userToUserResponseDto(newUser);
    }

    @Override
    public UserResponseDto getUserById(int id) {
        User user = userRepository.findByIdAndDeleted(id, isDeletedTrue)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id" + id));
        return userMapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(int id, UserRequestDto userRequestDto) {
        return userRepository.findByIdAndDeleted(id, isDeletedTrue)
                .map(existingUser -> {
                    userMapper.userRequestDtoToUserOverwrite(userRequestDto, existingUser);
                    User updatedUser = userRepository.save(existingUser);
                    return userMapper.userToUserResponseDto(updatedUser);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> allUser = userRepository.findByDeleted(isDeletedTrue)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.userToUserResponseDto(allUser);
    }

    @Override
    public UserResponseDto deleteUser(int id) {
        User user = userRepository.findByIdAndDeleted(id, isDeletedTrue)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id" + id));
        user.setDeleted(true);
        User updatedUser = userRepository.save(user);
        return userMapper.userToUserResponseDto(updatedUser);
    }
}
