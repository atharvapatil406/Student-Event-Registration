import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private String rollNumber;
    private String branch;

    public Student(String name, String rollNumber, String branch) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + " | Name: " + name + " (" + branch + ")";
    }
}

class Event {
    private String eventName;
    private int capacity;
    private List<Student> registeredStudents;

    public Event(String eventName, int capacity) {
        this.eventName = eventName;
        this.capacity = capacity;
        this.registeredStudents = new ArrayList<>();
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.size() >= capacity) {
            System.out.println("❌ Registration Failed: Event is full!");
            return false;
        }
        registeredStudents.add(student);
        System.out.println("✅ Successfully registered for " + eventName);
        return true;
    }

    public void displayAttendeeList() {
        System.out.println("\n--- Attendee List for " + eventName + " ---");
        if (registeredStudents.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            for (Student s : registeredStudents) {
                System.out.println(s);
            }
        }
    }
}

public class EventSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Event techWorkshop = new Event("AI Club Induction Workshop", 3); // Max 3 seats for testing

        while (true) {
            System.out.println("\n1. Register Student | 2. View Attendee List | 3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter Student Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Roll Number: ");
                String roll = scanner.nextLine();
                System.out.print("Enter Branch (CSE/ECE/ME etc.): ");
                String branch = scanner.nextLine();

                Student newStudent = new Student(name, roll, branch);
                techWorkshop.registerStudent(newStudent);
            } else if (choice == 2) {
                techWorkshop.displayAttendeeList();
            } else if (choice == 3) {
                System.out.println("Exiting system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
