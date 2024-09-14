package com.teste.escola.resources;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping("/profile")
	public String findMe() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
