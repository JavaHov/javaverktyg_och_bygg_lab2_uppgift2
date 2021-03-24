package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoDouble implements EmployeeRepository {


    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("1",  34000));

        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
