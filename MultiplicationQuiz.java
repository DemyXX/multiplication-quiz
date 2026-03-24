import java.util.Scanner;
import java.util.Random;

public class MultiplicationQuiz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to the Fun 5-Question Multiplication Quiz!");
        askQuestion(sc, rand, 1, 0, 0); // question 1, score 0, fails 0

        sc.close();
    }

    // Recursive quiz method
    // currentQuestion = which question we are on
    // score = correct answers so far
    // fails = total wrong answers
    public static void askQuestion(Scanner sc, Random rand, int currentQuestion, int score, int fails) {
        if (currentQuestion > 5) {
            // End of quiz
            System.out.println("\nQuiz over! You scored " + score + " out of 5.");
            if (score == 5) {
                System.out.println("Certified Tagalog!");
            } else if (fails > 3) {
                System.out.println("Bisaya ka talaga!");
            }
            return;
        }

        int a = rand.nextInt(10) + 1;
        int b = rand.nextInt(10) + 1;

        System.out.println("\nQuestion " + currentQuestion + ": What is " + a + " x " + b + "?");
        int answer = sc.nextInt();

        if (answer == a * b) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! The correct answer is " + (a * b));
            fails++;
        }

        // Move to next question
        askQuestion(sc, rand, currentQuestion + 1, score, fails);
    }
}