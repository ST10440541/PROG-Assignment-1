/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanage;

/**
 *
 * @author Admin
 */
public class StudentManage {




    static Map<String, Student> studentDatabase = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Enter (1) to launch menu or any other key to exit");
            option = scanner.nextInt();
            scanner.nextLine(); 
            if (option == 1) {
                showMenu();
            } else {
                System.out.println("Exiting...");
                break;
            }
        } while (option == 1);
    }

    private static void showMenu() {
        System.out.println("1. Capture a new student");
        System.out.println("2. Search for a student by ID");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                captureNewStudent();
                break;
            case 2:
                searchStudentById();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void captureNewStudent() {
        System.out.print("Enter the student id: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter the student name: ");
        String studentName = scanner.nextLine();

        int studentAge = inputStudentAge();

        System.out.print("Enter the student email: ");
        String studentEmail = scanner.nextLine();

        System.out.print("Enter the student course: ");
        String studentCourse = scanner.nextLine();

        Student student = new Student(studentId, studentName, studentAge, studentEmail, studentCourse);
        studentDatabase.put(studentId, student);

        System.out.println("Student details have been successfully saved.");
    }

    private static int inputStudentAge() {
        int age;
        while (true) {
            System.out.print("Enter the student age: ");
            String input = scanner.nextLine();

            try {
                age = Integer.parseInt(input);
                if (age >= 16) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect student age!!!");
                    System.out.println("Please re-enter the student age >> ");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect student age character!!!");
                System.out.println("Please re-enter the student age >> ");
            }
        }
        return age;
    }

    private static void searchStudentById() {
        System.out.print("Enter the student ID to search: ");
        String studentId = scanner.nextLine();

        Student student = studentDatabase.get(studentId);

        if (student != null) {
            System.out.println("Student Details: ");
            System.out.println(student);
        } else {
            System.out.println("Student cannot be located.");
        }
    }
}

class Student {
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email + ", Course: " + course;
    }
}
/* Code Attribution
This code waa extracted from W3schools, Stackoverflow and Javatpoint
https://www.w3schools.com/js/js_loop_for.asp
https://www.javatpoint.com/java-while-loop
https://www.w3schools.com/js/js_arrays.asp

*/
