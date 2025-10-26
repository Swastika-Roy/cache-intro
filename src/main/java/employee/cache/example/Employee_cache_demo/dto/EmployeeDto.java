package employee.cache.example.Employee_cache_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDto implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String department;
}
