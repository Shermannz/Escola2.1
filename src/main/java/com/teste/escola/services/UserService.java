package com.teste.escola.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.escola.dto.RoleDTO;
import com.teste.escola.dto.UserDTO;
import com.teste.escola.dto.UserInsertDTO;
import com.teste.escola.dto.UserUpdateDTO;
import com.teste.escola.entities.Role;
import com.teste.escola.entities.User;
import com.teste.escola.repositories.RoleRepository;
import com.teste.escola.repositories.UserRepository;
import com.teste.escola.services.exceptions.ResourceNotFoundException;

@Transactional
@Service
public class UserService implements UserDetailsService{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository Crepository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable) {
		Page<User> list = repository.findAll(pageable);
		return list.map(x -> new UserDTO(x));
	}
	
	public UserDTO findById(Long id) {
		Optional<User> aluno = repository.findById(id);
		User alunos = aluno.orElseThrow(() ->  new ResourceNotFoundException("Entity not found"));
		return new UserDTO(alunos);
	}
	
	
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		copyToEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
		User entity = repository.getById(id);
        copyToEntity(dto, entity);
        entity = repository.save(entity);
        return new UserDTO(entity);
	   }catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException("id not found " + id);
	}
	}
	
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	
	private void copyToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		
		for(RoleDTO roleDTO : dto.getRole()) {
			Role role = Crepository.getById(roleDTO.getId());
            entity.getRoles().add(role);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByEmail(username);
	}
	
}
