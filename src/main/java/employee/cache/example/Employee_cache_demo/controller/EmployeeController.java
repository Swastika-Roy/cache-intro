package employee.cache.example.Employee_cache_demo.controller;

import employee.cache.example.Employee_cache_demo.dto.EmployeeDto;
import employee.cache.example.Employee_cache_demo.entity.Employee;
import employee.cache.example.Employee_cache_demo.entity.SalaryAccount;
import employee.cache.example.Employee_cache_demo.service.EmployeeService;
import employee.cache.example.Employee_cache_demo.service.SalaryAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final SalaryAccountService salaryAccountService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto createdemployeeDto = employeeService.createnewEmployee(employeeDto);
        return new ResponseEntity<>(createdemployeeDto, HttpStatus.CREATED);
    }

    @PutMapping("/incrementBalance/{accountId}")
    public ResponseEntity<SalaryAccount> incrementBalance(@PathVariable Long id){
        SalaryAccount salaryAccount = salaryAccountService.incrementBalance(id);
        return ResponseEntity.ok(salaryAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("employee deleted having id "+id);
    }
}
