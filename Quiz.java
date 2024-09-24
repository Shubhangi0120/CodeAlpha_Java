import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
            "1. Which data structure is required to convert the infix to prefix notation?",
            "2. What are the minimum number of stacks required to implement a stack is?",
            "3. What is the largest planet in our solar system?",
            "4. What year did the Titanic sink?",
            "5. What is the square root of 144?"
        };

        String[][] options = {
            {"A) Stack", "B) Queue", "C) Linked List", "D) Binary Tree"},
            {"A) 1", "B) 2", "C) 3", "D) 5"},
            {"A) Earth", "B) Mars", "C) Jupiter", "D) Venus"},
            {"A) 1910", "B) 1912", "C) 1915", "D) 1920"},
            {"A) 10", "B) 11", "C) 12", "D) 14"}
        };
        // More Questions and answers can be added accordingly 

        char[] correctAnswers = {'B', 'C', 'C', 'B', 'C'};
        char[] userAnswers = new char[questions.length];

        System.out.println("Welcome to the Quiz Platform!\n");
        
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            userAnswers[i] = Character.toUpperCase(scanner.next().charAt(0));

            System.out.println();
        }

        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            if (userAnswers[i] == correctAnswers[i]) {
                score++;
            }
        }

        System.out.println("Quiz Completed!");
        System.out.println("You got " + score + " out of " + questions.length + " correct.");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            System.out.println("Your answer: " + userAnswers[i]);
            System.out.println("Correct answer: " + correctAnswers[i]);
        }
    }
}
