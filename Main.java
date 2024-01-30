/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.ArrayList;
import java.util.List;

class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private List<Course> enrolledCourses;
    private List<Grade> grades;

    // Constructor
    public Student(String studentId, String firstName, String lastName, String address, String phoneNumber) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    // Enroll in a course
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }

    // Submit grades for a course
    public void submitGrades(Course course, Grade grade) {
        if (enrolledCourses.contains(course)) {
            grades.add(grade);
        } else {
            System.out.println("Student is not enrolled in the course.");
        }
    }

    // Get GPA
    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double totalPoints = 0.0;
        int totalCredits = 0;

        for (Grade grade : grades) {
            totalPoints += grade.getGradePoints() * grade.getCredits();
            totalCredits += grade.getCredits();
        }

        return totalPoints / totalCredits;
    }

    // Getter methods

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public List<Grade> getGrades() {
        return grades;
    }
}

class Course {
    private String courseId;
    private String courseName;
    private int credits;

    // Constructor
    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    // Getter methods

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }
}

class Grade {
    private String courseId;
    private String letterGrade;
    private int credits;

    // Constructor
    public Grade(String courseId, String letterGrade, int credits) {
        this.courseId = courseId;
        this.letterGrade = letterGrade;
        this.credits = credits;
    }

    // Getter methods

    public String getCourseId() {
        return courseId;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public int getCredits() {
        return credits;
    }

    // Convert letter grade to grade points (this is a simplistic conversion)
    public double getGradePoints() {
        switch (letterGrade) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            default:
                return 0.0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage
        Course mathCourse = new Course("MATH101", "Introduction to Math", 3);
        Course physicsCourse = new Course("PHYS101", "Physics Fundamentals", 4);

        Student student = new Student("123456", "John", "Doe", "123 Main St", "555-1234");

        student.enrollInCourse(mathCourse);
        student.enrollInCourse(physicsCourse);

        Grade mathGrade = new Grade("MATH101", "A", 3);
        Grade physicsGrade = new Grade("PHYS101", "B", 4);

        student.submitGrades(mathCourse, mathGrade);
        student.submitGrades(physicsCourse, physicsGrade);

        double gpa = student.calculateGPA();

        System.out.println("Student GPA: " + gpa);
    }
}

