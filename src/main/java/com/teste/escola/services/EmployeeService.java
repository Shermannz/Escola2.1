package com.teste.escola.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teste.escola.dto.EmployeeDTO;
import com.teste.escola.dto.RoleDTO;
import com.teste.escola.entities.Employee;
import com.teste.escola.entities.Role;
import com.teste.escola.repositories.EmployeeRepository;
import com.teste.escola.repositories.RoleRepository;
import com.teste.escola.services.exceptions.ResourceNotFoundException;

@Service
public class EmployeeService extends UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	public Page<EmployeeDTO> findAll(Pageable pageable) {
		Page<Employee> list = repository.findAll(pageable);
		return list.map(x -> new EmployeeDTO(x));
	}

	public EmployeeDTO findById(Long id) {
		Optional<Employee> employee = repository.findById(id);
		Employee emp = employee.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EmployeeDTO(emp);
	}

	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee entity = new Employee();
		copyToEntity(dto, entity);
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}

	public EmployeeDTO update(Long id, EmployeeDTO dto) {
		try {
			Employee entity = repository.getById(id);
			copyToEntity(dto, entity);
			entity = repository.save(entity);
			return new EmployeeDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found " + id);
		}
	}

	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	private void copyToEntity(EmployeeDTO dto, Employee entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		for (RoleDTO roleDTO : dto.getRole()) {
			Role role = roleRepository.getById(roleDTO.getId());
			entity.getRoles().add(role);
		}
	}
}
