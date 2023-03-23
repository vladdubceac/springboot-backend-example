package md.vladdubceac.learning.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import md.vladdubceac.learning.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
