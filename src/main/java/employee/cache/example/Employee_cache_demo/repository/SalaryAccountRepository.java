package employee.cache.example.Employee_cache_demo.repository;

import employee.cache.example.Employee_cache_demo.entity.SalaryAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryAccountRepository extends CrudRepository<SalaryAccount,Long> {

}
