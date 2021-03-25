package inmemorytest;


import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InMemoryEmployeeRepo implements EmployeeRepository {

    private List<Employee> employees;


    public InMemoryEmployeeRepo() {

        employees = new ArrayList<>();
        employees.add(new Employee("1", 21000));
        employees.add(new Employee("2", 22000));
        employees.add(new Employee("3", 23000));
        employees.add(new Employee("4", 24000));
        employees.add(new Employee("5", 25000));
        employees.add(new Employee("6", 26000));

    }

    @Override
    public List<Employee> findAll() {

        return employees;
    }

    @Override
    public Employee save(Employee e) {

        boolean found = false;

        Iterator<Employee> iterator = employees.listIterator();
        while(iterator.hasNext()) {

            if(iterator.next().getId() == e.getId()) {

                iterator.remove();
                found = true;
            }
        }
        if(found) {
            employees.add(e);
            e.setAdded(true);
            return e;
        }
        else
            return null;
    }
}
