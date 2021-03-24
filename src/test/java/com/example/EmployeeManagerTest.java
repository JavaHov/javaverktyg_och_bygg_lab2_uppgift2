package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    @Test
    void testPayEmployeesWithOneEmployee() {

        EmployeeRepoDouble emprepoDouble = new EmployeeRepoDouble();
        BankServiceDouble bankServiceDouble = new BankServiceDouble();
        EmployeeManager employeeManager = new EmployeeManager(emprepoDouble, bankServiceDouble);

        int expected = 1; // Fortsätter här...
        int actual = employeeManager.payEmployees();
        assertThat(actual).isEqualTo(expected);

    }
}