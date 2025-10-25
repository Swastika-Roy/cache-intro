package employee.cache.example.Employee_cache_demo.service;

import employee.cache.example.Employee_cache_demo.dto.EmployeeDto;
import org.springframework.stereotype.Service;


public interface EmployeeService {

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto createnewEmployee(EmployeeDto employeeDto);

    void delete(Long id);
}
