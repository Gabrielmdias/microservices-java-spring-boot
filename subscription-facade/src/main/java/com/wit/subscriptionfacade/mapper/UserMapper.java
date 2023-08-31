package com.wit.subscriptionfacade.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.subscriptiondomain.UserDTO;
import com.wit.subscriptionfacade.dto.UserPostRequestBody;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDTO toUserDTO(UserPostRequestBody userPostRequestBody);

	UserPostRequestBody toUserPostRequestBody(UserDTO userDTO);
}
