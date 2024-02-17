import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int totalScore = 0;
        System.out.print("""
                NUMBER GUESSING GAME
                 Total number of rounds : 3
                 Attempts to guess number in each round : 10 \n""");
        for (int i = 1; i <= MAX_ROUNDS; i++) {
            int number = r.nextInt(MAX_RANGE) + MIN_RANGE;
            int attempts = 0;
            System.out.println("Round " + i + "guess the number between " + MIN_RANGE + "and " + MAX_RANGE + " in " + MAX_ATTEMPTS + " attempts.\n ");
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guessNumber = sc.nextInt();
                attempts += 1;
                if (guessNumber == number) {
                    int score = MAX_ATTEMPTS - (attempts - 1);
                    totalScore += score;
                    System.out.println("Hurrah!,number geuessed successfully. \n Attempts : " + attempts + " Round score : " + score);
                    break;
                } else if (guessNumber < number) {
                    System.out.println("This number is greater than " + guessNumber + ". \nAttempts left : " + (MAX_ATTEMPTS - attempts));
                } else {
                    System.out.println("This number is less than " + guessNumber + ". \nAttempts left : " + (MAX_ATTEMPTS - attempts));
                }
            }
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Round : " + i + "\n Score = 0 \n The Random number is : " + number);
            }
        }
        System.out.println("Game Over!.\n Total Score : " + totalScore);
        sc.close();
    }
}
