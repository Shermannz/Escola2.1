package com.teste.escola.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.teste.escola.dto.UserInsertDTO;
import com.teste.escola.entities.User;
import com.teste.escola.repositories.UserRepository;
import com.teste.escola.resources.exceptions.FieldMessage;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO>{

	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UserInsertValid constraintAnnotation) {
	}

	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
        User user = repository.findByEmail(dto.getEmail());
		if(user != null) {
			list.add(new FieldMessage("email","Email ja existe"));
		}
		
		for(FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
			.addConstraintViolation();
		}
		
		return list.isEmpty();
	}

}
