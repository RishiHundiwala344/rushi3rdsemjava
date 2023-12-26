/* Rushi Hundiwala= 1BM22CS224*/

import java.util.Scanner;

class Subject {
    int subjectMarks;
    int credits;
    int grade;

    // Constructor
    Subject() {
        // Default constructor
    }
}

class Student {
    String name;
    String usn;
    double SGPA;
    Scanner s;
    Subject[] subject;

    // Constructor
    Student() {
        int i;
        subject = new Subject[8]; // Corrected the array size to match the number of subjects
        for (i = 0; i < 8; i++)
            subject[i] = new Subject();
        s = new Scanner(System.in);
    }

    // Method to get student details
    void getStudentDetails() {
        System.out.println("Enter Name: ");
        name = s.next();
        System.out.println("Enter USN: ");
        usn = s.next();
    }

    // Method to get marks and calculate grade
    void getMarks() {
        int i;
        for (i = 0; i < 8; i++) {
            System.out.println("Enter marks for Subject " + (i + 1) + ": ");
            subject[i].subjectMarks = s.nextInt();

            // Assuming credits are fixed at 4 for each subject
            subject[i].credits = 4;

            // Calculate grade based on marks
            if (subject[i].subjectMarks >= 90) subject[i].grade = 10;
            else if (subject[i].subjectMarks >= 80) subject[i].grade = 9;
            else if (subject[i].subjectMarks >= 70) subject[i].grade = 8;
            else if (subject[i].subjectMarks >= 60) subject[i].grade = 7;
            else if (subject[i].subjectMarks >= 50) subject[i].grade = 6;
            else subject[i].grade = 0; // Assuming 0 grade points for marks below 50
        }
    }

    // Method to compute SGPA
    void computeSGPA() {
        double totalCredits = 0;
        double weightedTotal = 0;

        for (int i = 0; i < 8; i++) {
            totalCredits += subject[i].credits;
            weightedTotal += (subject[i].grade * subject[i].credits);
        }

        SGPA = weightedTotal / totalCredits;

        System.out.println("SGPA: " + SGPA);
    }
}

public class Main {
    public static void main(String[] args) {
        // Declare and initialize Student object
        Student s1 = new Student();

        // Call methods to get details, marks, and compute SGPA
        s1.getStudentDetails();
        s1.getMarks();
        s1.computeSGPA();
    }
}