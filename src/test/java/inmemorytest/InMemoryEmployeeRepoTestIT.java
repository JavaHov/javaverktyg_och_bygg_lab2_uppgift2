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
    void testPayEmpWithInMemWithArg() {


        List<Employee> list = new ArrayList<>();
        list.add(new Employee("1", 12000));
        list.add(new Employee("2", 14000));

        BankServiceDouble bankServiceDouble = new BankServiceDouble();
        InMemoryEmployeeRepo inMemoryEmployeeRepo = new InMemoryEmployeeRepo(list);
        EmployeeManager employeeManager = new EmployeeManager(inMemoryEmployeeRepo, bankServiceDouble);

        assertThat(employeeManager.payEmployees()).isEqualTo(2);

        assertThat(list.get(0).isPaid() && list.get(1).isPaid()).isTrue();

    }
}