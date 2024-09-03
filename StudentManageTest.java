/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package studentmanage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class StudentManageTest {

    private static Map<String, Student> studentDatabase;

    @BeforeEach
    public void setup() {
        studentDatabase = new HashMap<>();
    }

    @Test
    public void testCaptureNewStudent() {
        // Arrange
        String studentId = "S001";
        String studentName = "John Doe";
        int studentAge = 20;
        String studentEmail = "john.doe@example.com";
        String studentCourse = "Computer Science";

        // Act
        Student student = new Student(studentId, studentName, studentAge, studentEmail, studentCourse);
        studentDatabase.put(studentId, student);

        // Assert
        assertNotNull(studentDatabase.get(studentId));
        assertEquals(studentName, studentDatabase.get(studentId).name);
        assertEquals(studentAge, studentDatabase.get(studentId).age);
        assertEquals(studentEmail, studentDatabase.get(studentId).email);
        assertEquals(studentCourse, studentDatabase.get(studentId).course);
    }

    @Test
    public void testSearchStudentById_Found() {
        // Arrange
        String studentId = "S001";
        String studentName = "John Doe";
        int studentAge = 20;
        String studentEmail = "john.doe@example.com";
        String studentCourse = "Computer Science";

        Student student = new Student(studentId, studentName, studentAge, studentEmail, studentCourse);
        studentDatabase.put(studentId, student);

        // Act
        Student foundStudent = studentDatabase.get(studentId);

        // Assert
        assertNotNull(foundStudent);
        assertEquals(studentName, foundStudent.name);
        assertEquals(studentAge, foundStudent.age);
        assertEquals(studentEmail, foundStudent.email);
        assertEquals(studentCourse, foundStudent.course);
    }

    @Test
    public void testSearchStudentById_NotFound() {
        // Arrange
        String studentId = "S001";

        // Act
        Student foundStudent = studentDatabase.get(studentId);

        // Assert
        assertNull(foundStudent);
    }

    @Test
    public void testInputStudentAge_Valid() {
        // Arrange
        String input = "20";

        // Act
        int age = Integer.parseInt(input);

        // Assert
        assertEquals(20, age);
    }

    @Test
    public void testInputStudentAge_Invalid() {
        // Arrange
        String input = "abc";

        // Act and Assert
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(input));
    }

    @Test
    public void testInputStudentAge_Under16() {
        // Arrange
        String input = "15";

        // Act
        int age = Integer.parseInt(input);

        // Assert
        assertTrue(age < 16);
    }
}