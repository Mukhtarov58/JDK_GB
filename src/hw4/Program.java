package hw4;

import java.util.List;
//Создать справочник сотрудников
//        Необходимо:
//        Создать класс справочник сотрудников, который содержит внутри
//        коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
//        Табельный номер
//        Номер телефона
//        Имя
//        Стаж
//        Добавить метод, который ищет сотрудника по стажу (может быть список)
//        Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
//        Добавить метод, который ищет сотрудника по табельному номеру
//        Добавить метод добавления нового сотрудника в справочник
public class Program {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        directory.addEmployee(new Employee(1, "1234334567890", "Иванов", 5));
        directory.addEmployee(new Employee(2, "0987343654321", "Петров", 3));
        directory.addEmployee(new Employee(3, "1115432223333", "Сидоров", 7));
        directory.addEmployee(new Employee(4, "114434223333", "Сидоров", 1));
        directory.addEmployee(new Employee(5, "113423333", "Сидоров", 2));

        List<Employee> employeesWithExperience5 = directory.findEmployeesByExperience(5);
        System.out.println("Сотрудники со стажем 5 лет:");
        for (Employee employee : employeesWithExperience5) {
            System.out.println(employee.getName());
        }

        String phoneNumber = directory.findPhoneNumberByName("Петров");
        if (phoneNumber != null) {
            System.out.println("Номер телефона Петрова: " + phoneNumber);
        } else {
            System.out.println("Сотрудник с именем Петров не найден.");
        }

        Employee employeeById = directory.findEmployeeById(2);
        if (employeeById != null) {
            System.out.println("Сотрудник с табельным номером 2 найден: " + employeeById.getName());
        } else {
            System.out.println("Сотрудник с табельным номером 2 не найден.");
        }
    }
}