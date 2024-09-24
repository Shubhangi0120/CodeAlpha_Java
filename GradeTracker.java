import java.util.Scanner;
public class GradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        if(numStudents == 0){
            System.out.println("Invalid Input. Program Exited !");
            System.exit(0);
        }
        
        int[] marks = new int[numStudents];
        char[] grades = new char[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter marks for student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            grades[i] = convertToGrade(marks[i]);
        }
        
        double average = calculateAverage(marks);
        int highest = findHighest(marks);
        int lowest = findLowest(marks);
        
        System.out.println("\nGrade Summary:");
        System.out.println("Average marks: " + average);
        System.out.println("Highest marks: " + highest + " (" + convertToGrade(highest) + ")");
        System.out.println("Lowest marks: " + lowest + " (" + convertToGrade(lowest) + ")");
        
        System.out.println("\nIndividual Grades:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ": Marks = " + marks[i] + ", Grade = " + grades[i]);
        }
    }
    
    public static double calculateAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public static int findHighest(int[] marks) {
        int highest = marks[0];
        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        return highest;
    }
    
    public static int findLowest(int[] marks) {
        int lowest = marks[0];
        for (int mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }
        return lowest;
    }

    public static char convertToGrade(int marks) {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
