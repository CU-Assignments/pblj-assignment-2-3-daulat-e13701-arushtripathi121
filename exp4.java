package PBLJ;

import java.util.*;
import java.util.stream.Collectors;

public class exp4 {

    class Employee{
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

    class Student {
        String name;
        int marks;

        public Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public double getMarks() {
            return marks;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', marks=" + marks + "}";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the operation number (1 - Employee, 2 - Student, 3 - Product): ");
        int choice = scanner.nextInt();


        switch (choice) {
            case 1:
                List<PBLJ.Employee> employees = Arrays.asList(
                        new PBLJ.Employee("A", 30, 50000),
                        new PBLJ.Employee("B", 40, 60000),
                        new PBLJ.Employee("C", 35, 55000)
                );
                employees.stream()
                        .sorted(Comparator.comparing(PBLJ.Employee::getSalary))
                        .forEach(System.out::println);
                break;

            case 2:
                List<PBLJ.Student> students = Arrays.asList(
                        new PBLJ.Student("X", 80),
                        new PBLJ.Student("Y", 65),
                        new PBLJ.Student("Z", 90),
                        new PBLJ.Student("Jill", 72)
                );
                students.stream()
                        .filter(s -> s.getMarks() > 75)
                        .sorted(Comparator.comparing(PBLJ.Student::getMarks).reversed())
                        .map(PBLJ.Student::getName)
                        .forEach(System.out::println);
                break;

            case 3:
                List<Product> products = Arrays.asList(
                        new Product("Laptop", "Electronics", 800),
                        new Product("Shirt", "Clothing", 30),
                        new Product("Smartphone", "Electronics", 500),
                        new Product("Shoes", "Clothing", 70)
                );
                Map<String, Double> avgPriceByCategory = products.stream()
                        .collect(Collectors.groupingBy(Product::getCategory,
                                Collectors.averagingDouble(Product::getPrice)));
                avgPriceByCategory.forEach((category, avgPrice) -> System.out.println(category + ": " + avgPrice));

                Map<String, Product> mostExpensiveByCategory = products.stream()
                        .collect(Collectors.groupingBy(Product::getCategory,
                                Collectors.maxBy(Comparator.comparing(Product::getPrice))))
                        .entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey,
                                entry -> entry.getValue().get()));
                mostExpensiveByCategory.forEach((category, product) -> System.out.println(category + ": " + product));

                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}
