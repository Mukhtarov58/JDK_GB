package hw4;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }

    public String findPhoneNumberByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee.getPhoneNumber();
            }
        }
        return null;
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}