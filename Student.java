package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentID;
    private String courses = ""; // Initialize to an empty string
    private int tuitionBalance;
    private int costOfCourse = 600;
    private static int id = 1000; // Static ID counter

    // Constructor: prompt user to enter student's name and year 
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextLine();

        setStudentID();
    }

    // Generate an ID 
    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id; // Convert id to String
    }

    // Enroll in courses
    public void enroll() {
        // Get inside a loop, user hits 0
        Scanner in = new Scanner(System.in);
        String course;
        do {
            System.out.print("Enter course to enroll (0 to quit): ");
            course = in.nextLine();
            if (!course.equals("0")) { // Changed "Q" to "0" to match the prompt
                courses += "\n" + course; // Append course to the list
                tuitionBalance += costOfCourse; // Update tuition balance
            } else {
                System.out.println("BREAK!");
                break;
            }
        } while (true); // Use 'true' for infinite loop
    }

    // View balance 
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance); // Changed 'printIn' to 'println'
    }

    // Pay Tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance -= payment; // Update balance
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Show status 
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
               "\nGrade Level: " + gradeYear +
               "\nStudent ID: " + studentID + 
               "\nCourses Enrolled:" + courses +
               "\nBalance: $" + tuitionBalance;
    }
}
