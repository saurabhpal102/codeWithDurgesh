package com.evon.mapper;

import com.evon.dto.UserRequestDto;
import com.evon.dto.UserResponseDto;
import com.evon.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRequestDtoToUser(UserRequestDto userRequestDto);

    UserResponseDto userToUserResponseDto(User user);

    List<UserResponseDto> userToUserResponseDto(List<User> user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void userRequestDtoToUserOverwrite(UserRequestDto userRequestDto, @MappingTarget User user);

}
