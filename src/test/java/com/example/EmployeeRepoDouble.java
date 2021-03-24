package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoDouble implements EmployeeRepository {

    private List<Employee> employees;

    public EmployeeRepoDouble(List<Employee> employees) {

      this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {

        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
