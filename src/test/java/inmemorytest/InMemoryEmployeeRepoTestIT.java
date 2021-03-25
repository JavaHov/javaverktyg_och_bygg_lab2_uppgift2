package inmemorytest;

import com.example.BankServiceDouble;
import com.example.Employee;
import com.example.EmployeeManager;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class InMemoryEmployeeRepoTestIT {

    @Test
    void testFindAll() {

        InMemoryEmployeeRepo inMemoryEmployeeRepo = new InMemoryEmployeeRepo();
        List<Employee> testList = inMemoryEmployeeRepo.findAll();
        assertNotNull(testList);
        assertThat(testList).isNotEmpty();
        assertThat((testList.size())).isEqualTo(6);

    }

    @Test
    void testSave() {

        InMemoryEmployeeRepo inMemoryEmployeeRepo = new InMemoryEmployeeRepo();
        Employee employee = new Employee("1", 45000);

        Employee e = inMemoryEmployeeRepo.save(employee);
        assertNotNull(e);

        assertThat(e.wasAdded()).isTrue();

    }

    @Test
    void testPayEmployeeWithInMemory() {

        BankServiceDouble bankServiceDouble = new BankServiceDouble();
        InMemoryEmployeeRepo inMemoryEmployeeRepo = new InMemoryEmployeeRepo();
        EmployeeManager employeeManager = new EmployeeManager(inMemoryEmployeeRepo, bankServiceDouble);

        Employee employee = new Employee("4", 70000);
        Employee emp = inMemoryEmployeeRepo.save(employee);
        assertThat(emp.wasAdded()).isTrue();

    }

    @Test
    void testPayEmployeeWithInMemoryReturnsNull() {

        BankServiceDouble bankServiceDouble = new BankServiceDouble();
        InMemoryEmployeeRepo inMemoryEmployeeRepo = new InMemoryEmployeeRepo();
        EmployeeManager employeeManager = new EmployeeManager(inMemoryEmployeeRepo, bankServiceDouble);

        Employee employee = new Employee("8", 70000);
        Employee emp = inMemoryEmployeeRepo.save(employee);
        assertNull(emp);


    }
}