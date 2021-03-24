package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class EmployeeManagerTest {



    @Test
    void testPayEmployeesWithOneEmployee() {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("1",  34000));

        EmployeeRepoDouble repoDouble = new EmployeeRepoDouble(employeeList);
        BankServiceDouble bankServiceDouble = new BankServiceDouble();
        EmployeeManager employeeManager = new EmployeeManager(repoDouble, bankServiceDouble);

        int expected = 1; // Fortsätter här...
        int actual = employeeManager.payEmployees();
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void testPayEmployeesWithFiveEmployees() {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1",  34000));
        employeeList.add(new Employee("2",  33000));
        employeeList.add(new Employee("3",  37000));
        employeeList.add(new Employee("4",  35000));
        employeeList.add(new Employee("5",  32000));

        EmployeeRepoDouble repoDouble = new EmployeeRepoDouble(employeeList);
        BankServiceDouble bankServiceDouble = new BankServiceDouble();
        EmployeeManager employeeManager = new EmployeeManager(repoDouble, bankServiceDouble);

        int expected = 5; // Fortsätter här...
        int actual = employeeManager.payEmployees();
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void testPayEmployeesThrowsException() {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(null);


        EmployeeRepoDouble repoDouble = new EmployeeRepoDouble(employeeList);
        BankServiceDouble bankServiceDouble = new BankServiceDouble();
        EmployeeManager employeeManager = new EmployeeManager(repoDouble, bankServiceDouble);

        assertThrows(RuntimeException.class, () -> employeeManager.payEmployees());

    }

    @Test
    void testWithMockito() {


    List<Employee> list = new ArrayList<>();
    list.add(new Employee("1", 45000));

    EmployeeRepository mockEmployeeRepo = mock(EmployeeRepository.class);
    BankService mockBankService = mock(BankService.class);
    EmployeeManager employeeManager = new EmployeeManager(mockEmployeeRepo, mockBankService);

    assertNotNull(mockEmployeeRepo);
    assertNotNull(mockBankService);
    //when(mockEmployeeRepo.findAll()).thenReturn(list);
    //when(employeeManager.payEmployees()).thenReturn(1);
    //assertThat(employeeManager.payEmployees()).isEqualTo(1);


    }
}