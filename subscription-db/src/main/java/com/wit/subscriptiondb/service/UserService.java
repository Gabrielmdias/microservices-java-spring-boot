package com.wit.subscriptiondb.service;

import com.wit.subscriptiondb.domain.User;
import com.wit.subscriptiondb.repository.UserRepository;
import com.wit.subscriptiondomain.BasicDTO;
import com.wit.subscriptiondomain.UserDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service(UserDTO.USER)
@Transactional
public class UserService extends BasicService<User, UserRepository> {
	public UserService(UserRepository repository) {
		super(repository);
	}

	@Override
	public User getEntity(BasicDTO dto) {
		return this.mapper.map(dto, User.class);
	}

	@Override
	public UserDTO getDTO(User entity) {
		return this.mapper.map(entity, UserDTO.class);
	}

	@Override
	public UserDTO getListDTO(List<User> entityList) {
		return null;
	}
}
