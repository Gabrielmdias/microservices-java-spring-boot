package com.wit.subscriptionfacade.user.resources;

import com.wit.subscriptiondomain.BasicDTO;
import com.wit.subscriptiondomain.UserDTO;
import com.wit.subscriptionfacade.dto.UserPostRequestBody;
import com.wit.subscriptionfacade.mapper.UserMapper;
import com.wit.subscriptionfacade.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/usuario")
public class UserResource {

	private final UserService userService;

	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@PostMapping()
	public ResponseEntity<BasicDTO> createUser(@RequestBody UserPostRequestBody userPostRequestBody) {
		UserDTO userDTO = userService.createUser(UserMapper.INSTANCE.toUserDTO(userPostRequestBody));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(userDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<BasicDTO> deleteUser(@PathVariable UUID id) {
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}

}
