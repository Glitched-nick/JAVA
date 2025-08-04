import java.util.*;
import java.io.*;

class Student {
    String name;
    String rollNumber;
    String grade;

    Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String toString() {
        return rollNumber + "," + name + "," + grade;
    } 

    public static Student fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return new Student(parts[1], parts[0], parts[2]);
        }
        return null;
    }
}

class StudentManagementSystem {
    List<Student> students = new ArrayList<>();
    String fileName = "students.txt";

    StudentManagementSystem() {
        loadFromFile();
    }

    void addStudent(String name, String roll, String grade) {
        if (name.isEmpty() || roll.isEmpty() || grade.isEmpty()) return;
        students.add(new Student(name, roll, grade));
        saveToFile();
    }

    void removeStudent(String roll) {
        students.removeIf(s -> s.rollNumber.equals(roll));
        saveToFile();
    }

    Student searchStudent(String roll) {
        for (Student s : students) {
            if (s.rollNumber.equals(roll)) return s;
        }
        return null;
    }

    void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : students) {
                System.out.println("Roll No: " + s.rollNumber + " | Name: " + s.name + " | Grade: " + s.grade);
            }
        }
    }

    void editStudent(String roll, String newName, String newGrade) {
        for (Student s : students) {
            if (s.rollNumber.equals(roll)) {
                if (!newName.isEmpty()) s.name = newName;
                if (!newGrade.isEmpty()) s.grade = newGrade;
                break;
            }
        }
        saveToFile();
    }

    void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for (Student s : students) {
                writer.println(s);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    void loadFromFile() {
        students.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                Student s = Student.fromString(line);
                if (s != null) students.add(s);
            }
            reader.close();
        } catch (IOException e) {
        }
    }
}

public class StudentManagementSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\nSTUDENT MANAGEMENT SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine().trim();
                System.out.print("Enter Roll Number: ");
                String roll = scanner.nextLine().trim();
                System.out.print("Enter Grade: ");
                String grade = scanner.nextLine().trim();
                sms.addStudent(name, roll, grade);
                System.out.println("Student added.");
            } else if (choice == 2) {
                System.out.print("Enter Roll Number to remove: ");
                String roll = scanner.nextLine().trim();
                sms.removeStudent(roll);
                System.out.println("Student removed.");
            } else if (choice == 3) {
                System.out.print("Enter Roll Number to search: ");
                String roll = scanner.nextLine().trim();
                Student s = sms.searchStudent(roll);
                if (s != null) {
                    System.out.println("Found: " + s.name + ", Grade: " + s.grade);
                } else {
                    System.out.println("Student not found.");
                }
            } else if (choice == 4) {
                System.out.print("Enter Roll Number to edit: ");
                String roll = scanner.nextLine().trim();
                System.out.print("Enter New Name (or leave empty): ");
                String newName = scanner.nextLine().trim();
                System.out.print("Enter New Grade (or leave empty): ");
                String newGrade = scanner.nextLine().trim();
                sms.editStudent(roll, newName, newGrade);
                System.out.println("Student updated.");
            } else if (choice == 5) {
                sms.displayAll();
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
