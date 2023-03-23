package md.vladdubceac.learning.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import md.vladdubceac.learning.springboot.exception.ResourceNotFoundException;
import md.vladdubceac.learning.springboot.model.Employee;
import md.vladdubceac.learning.springboot.repository.EmployeeRepository;
import md.vladdubceac.learning.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// check whether employee with given id exists in DB or no
		Employee existingEmployee = getEmployee(id);

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		return employeeRepository.save(existingEmployee);
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether employee with given id exists in DB or no
		Employee existingEmployee = getEmployee(id);
		if (existingEmployee != null) {
			employeeRepository.deleteById(id);
		}
	}

}
