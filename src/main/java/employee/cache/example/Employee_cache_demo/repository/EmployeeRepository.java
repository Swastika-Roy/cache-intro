package employee.cache.example.Employee_cache_demo.repository;

import employee.cache.example.Employee_cache_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByEmail(String email);
}
