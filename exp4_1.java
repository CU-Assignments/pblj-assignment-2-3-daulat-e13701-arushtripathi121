import java.util.*;
import java.util.stream.Collectors;

public class exp4_1 {

    static class Employee {
        String name;
        int age;
        int salary;

        public Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("A", 30, 50000),
                new Employee("B", 40, 60000),
                new Employee("C", 35, 55000)
        );

        // Sort employees by salary and print
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);
    }
}
