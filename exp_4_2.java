import java.util.*;
import java.util.stream.Collectors;

public class exp_4_2 {

    static class Student {
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
        List<Student> students = Arrays.asList(
                new Student("X", 80),
                new Student("Y", 65),
                new Student("Z", 90),
                new Student("Jill", 72)
        );

        // Filter students with marks > 75, sort by marks descending and print names
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparing(Student::getMarks).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}

