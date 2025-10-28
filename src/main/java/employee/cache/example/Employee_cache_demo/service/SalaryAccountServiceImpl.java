package employee.cache.example.Employee_cache_demo.service;

import employee.cache.example.Employee_cache_demo.entity.Employee;
import employee.cache.example.Employee_cache_demo.entity.SalaryAccount;
import employee.cache.example.Employee_cache_demo.repository.SalaryAccountRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class SalaryAccountServiceImpl implements SalaryAccountService{

    private final SalaryAccountRepository salaryAccountRepository;

    public void createAccount(Employee employee){
        SalaryAccount salaryAccount = SalaryAccount.builder()
                .employee(employee)
                .balance(BigDecimal.ZERO)
                .build();
        salaryAccountRepository.save(salaryAccount);
    }

    public SalaryAccount incrementBalance(Long accountId){
        SalaryAccount salaryAccount = salaryAccountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        BigDecimal prevBalance = salaryAccount.getBalance();
        BigDecimal newBalance = prevBalance.add( BigDecimal.valueOf(1L));

        salaryAccount.setBalance(newBalance);
        return salaryAccountRepository.save(salaryAccount);
    }

}
