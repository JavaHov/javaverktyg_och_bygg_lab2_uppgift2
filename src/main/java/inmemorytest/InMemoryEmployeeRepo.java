package inmemorytest;


import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEmployeeRepo implements EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();


    @Override
    public List<Employee> findAll() {

        employees.add(new Employee("1", 21000));
        employees.add(new Employee("2", 22000));
        employees.add(new Employee("3", 23000));
        employees.add(new Employee("4", 24000));
        employees.add(new Employee("5", 25000));
        employees.add(new Employee("6", 26000));

        return employees;
    }

    @Override
    public Employee save(Employee e) {

        for(Employee employee : employees) {

            if(e.getId() == employee.getId()) {

                employees.remove(employee);
                employees.add(e);
                e.setAdded(true);
            }
        }
        return e;
    }
}
