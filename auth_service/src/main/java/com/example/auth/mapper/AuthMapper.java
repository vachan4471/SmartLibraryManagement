package com.example.auth.mapper;

import com.example.auth.entity.Role;
import com.example.auth.entity.User;
import com.example.common.dto.request.UserRequestDto;
import com.example.common.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "jsr330")
public interface AuthMapper {
    //use @Mapping when we write the names of variable different in both the entity and DTO
    UserResponseDto toResponse(User user);

    @Mapping(target = "role", expression = "java(mapRole(requestDto.getRole()))")
    User toEntity(UserRequestDto requestDto);
    default Role mapRole(String role){
        if(role==null)return null;
        return Role.valueOf("ROLE_"+role.toUpperCase());
    }

    //while updating we do is: take a new requestDto and existing book, using @MappingTarget
    @Mapping(target = "userId",ignore = true)
    void updateEntityFromDto(UserRequestDto newRequestDto, @MappingTarget User user);
}
