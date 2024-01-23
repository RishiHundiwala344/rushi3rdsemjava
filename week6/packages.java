package CIE;

import java.util.Scanner;

public class Student {

protected String usn = new String(); 
protected String name = new String(); 
protected int sem;

public void inputStudentDetails(){ 
	Scanner s=new Scanner(System.in);
	System.out.println("give usn");
	usn=s.nextLine();
	System.out.println("give name");
	name=s.nextLine();
	System.out.println("give sem");
	sem=s.nextInt();
}

public void displayStudentDetails(){

System.out.println("the usn is : ", usn);
System.out.println("the name is : ", name);
System.out.println("the sem is : ", sem);

}

package CIE; 
import java.util.Scanner;

public class Internals extends Student {

protected int marks[] = new int[5];

public void inputCIEmarks(){
Scanner s=new Scanner(System.in);

for(int i=0;i<5;i++){
	System.out.println("enter marks for course " + (i+1) +":");
	marks[i]=s.nextInt();
}

package SEE;

import CIE.Internals;
import java.util.Scanner;

public class Externals extends Internals {
	protected int marks[];
	protected int finalMarks[];
}

public Externals() {

marks = new int[5]; finalMarks = new int[5]; }

public void inputSEEmarks() {

Scanner s = new Scanner(System.in);

for(int i=0;i<5;i++) {

System.out.print("Subject "+(i+1)+" marks: ");

marks[i] = s.nextInt(); } }

public void calculateFinalMarks() {

for(int i=0;i<5;i++)

finalMarks[i] = marks[i]/2 + super.marks[i];

}

public void displayFinalMarks() { displayStudentDetails();

for(int i=0;i<5;i++)

System.out.println("Subject " + (i+1) + ": " + finalMarks[i]);

}
}

// SEE/Externals.java
package SEE;

import CIE.Internals;
import java.util.Scanner;

public class Externals extends Internals {
    protected int marks[];
    protected int finalMarks[];

    public Externals() {
        marks = new int[5];
        finalMarks = new int[5];
    }

    public void inputSEEMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter SEE marks for 5 courses:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Course " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }

    public void calculateFinalMarks() {
        for (int i = 0; i < 5; i++) {
            finalMarks[i] = marks[i] / 2 + super.marks[i];
        }
    }

    public void displayFinalMarks() {
        displayStudentDetails();
        for (int i = 0; i < 5; i++) {
            System.out.println("Course " + (i + 1) + ": " + finalMarks[i]);
        }
    }
}

// Main.java
import SEE.Externals;

public class Main {
    public static void main(String args[]) {
        int numOfStudents = 2;
        Externals finalMarks[] = new Externals[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            finalMarks[i] = new Externals();
            finalMarks[i].inputStudentDetails();
            System.out.println("Enter CIE marks");
            finalMarks[i].inputCIEMarks();
            System.out.println("Enter SEE marks");
            finalMarks[i].inputSEEMarks();
        }

        System.out.println("Displaying data:\n");

        for (int i = 0; i < numOfStudents; i++) {
            finalMarks[i].calculateFinalMarks();
            finalMarks[i].displayFinalMarks();
        }
    }
}
