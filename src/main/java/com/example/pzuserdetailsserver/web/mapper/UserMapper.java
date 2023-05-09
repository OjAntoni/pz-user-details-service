package com.example.pzuserdetailsserver.web.mapper;

import com.example.pzuserdetailsserver.model.User;
import com.example.pzuserdetailsserver.web.dto.PatchUserDto;
import com.example.pzuserdetailsserver.web.dto.UserRegistrationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRegistrationDTO dto);
    User toEntity(PatchUserDto dto);
}
