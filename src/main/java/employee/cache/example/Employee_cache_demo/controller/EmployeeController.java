package employee.cache.example.Employee_cache_demo.controller;

import employee.cache.example.Employee_cache_demo.dto.EmployeeDto;
import employee.cache.example.Employee_cache_demo.entity.Employee;
import employee.cache.example.Employee_cache_demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.createnewEmployee(employeeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("employee deleted having id "+id);
    }
}
