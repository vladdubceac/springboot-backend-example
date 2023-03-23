package md.vladdubceac.learning.springboot.service;

import java.util.List;

import md.vladdubceac.learning.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployee(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
}
