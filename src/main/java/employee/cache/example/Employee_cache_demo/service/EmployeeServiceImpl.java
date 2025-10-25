package employee.cache.example.Employee_cache_demo.service;

import employee.cache.example.Employee_cache_demo.dto.EmployeeDto;
import employee.cache.example.Employee_cache_demo.entity.Employee;
import employee.cache.example.Employee_cache_demo.exception.ResourceNotFoundException;
import employee.cache.example.Employee_cache_demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    private final String CACHE_NAME = "employees";


    @Override
    @Cacheable(cacheNames = CACHE_NAME,key="#id")
    public EmployeeDto getEmployeeById(Long id) {
        log.info("Fetching employee with id : {} ",id);
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id + "+id));
        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    @CachePut(cacheNames = CACHE_NAME,key = "#result.id")
    public EmployeeDto createnewEmployee(EmployeeDto employeeDto) {
        log.info("Creating new employee with email  : {}",employeeDto.getEmail());
        List<Employee> existingEmployees = employeeRepository.findByEmail(employeeDto.getEmail());
        if (!existingEmployees.isEmpty()) {
            throw new RuntimeException("Employee already exists with email: " + employeeDto.getEmail());
        }
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        Employee saved = employeeRepository.save(employee);
        return modelMapper.map(saved,EmployeeDto.class);
    }

    @Override
    @CacheEvict(cacheNames = CACHE_NAME,key="#id")
    public void delete(Long id) {
        log.info("Deleting employee with id: {}", id);
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
        log.info("Employee deleted and cache evicted for id: {}", id);
    }
}
