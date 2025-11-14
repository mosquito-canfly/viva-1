import java.util.Scanner;
import java.util.Random;
public class Q6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        // welcome message
        System.out.println("Welcome to the Dragon Egg Quest!");
        System.out.println("There are 10 chests, 3 dragon eggs, and 2 cursed chests.");
        System.out.println("You have 10 attempts to find all dragon eggs.");
        System.out.println();

        // declare array
        int[] eggs = new int[3];
        int[] curse = new int[2];

        int randomNumber;

        // generate random egg chests
        for (int i = 0; i < eggs.length; i++) {
            boolean isUnique;
            do {
                isUnique = true;
                randomNumber = r.nextInt(10) + 1;
                /* check whether the egg chest is isUnique or not */
                // compare the second egg and third egg with the previous egg
                for (int j = 0; j < i; j++) {
                    if (eggs[j] == randomNumber) {
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique); // duplicated number detected
            eggs[i] = randomNumber;
        }

        // generate random cursed chest
        for (int i = 0; i < curse.length; i++) {
            boolean isUnique;
            do {
                isUnique = true;
                randomNumber = r.nextInt(10) + 1;
                /* check whether the curse chest is isUnique or not */
                // compare the second curse with the previous curse
                for (int j = 0; j < i; j++) {
                    if (curse[j] == randomNumber) {
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique);
            curse[i] = randomNumber;
        }

        // read guess from user
        int attempt = 10;
        int found = 0;
        while (attempt > 0 && found < 3) {
            System.out.print("Guess a chest (1-10): ");
            int guess = s.nextInt();

            // print error message if guess is out of range
            if (guess < 1 || guess > 10) {
                System.out.println("Out of range! Try again!");
                System.out.println();
                continue;
            }

            // declare found egg and cursed chest
            boolean foundEgg = false;
            boolean cursed = false;

            // if the chest is cursed
            for (int i = 0; i < curse.length; i++) {
                int c = curse[i];
                if (guess == c) {
                    cursed = true;
                }
            }
            if (cursed) {
                System.out.println("This chest is cursed! Beware!");
                attempt--;
            }

            // if the egg is found
            for (int i = 0; i < eggs.length; i++) {
                int e = eggs[i];
                if (guess == e) {
                    foundEgg = true;
                    eggs[i] = -1; // mark the egg as found
                    found++;
                }
            }

            // action if the egg is found (print message and break)
            if (foundEgg) {
                System.out.println("You found a dragon egg!");
                if (found == 3) {
                    System.out.println();
                    System.out.println("Congratulations! All dragon eggs are safe!");
                    break;
                }

            } else {
                /* if the egg is not found */
                // find the min distance and the nearest egg
                int minDistance = 11;
                int nearestEgg = -1;
                for (int i = 0; i < eggs.length; i++) {
                    int e = eggs[i];
                    if (e == -1) {
                        continue;
                    }
                    // calculate distance between all eggs and the guess
                    int distance = Math.abs(guess - e);
                    // found the min distance and the nearest egg
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestEgg = e;
                    }
                }

                // action if the egg is near
                if (minDistance <= 3) {
                    System.out.println("Warm! You're very close to a dragon egg!");
                }else{
                    // action if the egg is far
                    System.out.println("Cold! You're far from any dragon egg!");
                }
                // give directional hint to help the player
                if (guess > nearestEgg) {
                    System.out.println("Hint: Try a lower chest number.");
                }else{
                    System.out.println("Hint: Try a higher chest number.");
                }
                System.out.println("No egg here, keep searching!");
            }

            // print attempts left
            attempt--;
            System.out.println("Attempts left: " + attempt);
            System.out.println();
        }

        // if lose the game
        if (found < 3) {
            System.out.println("Game Over! Some dragon eggs remain hidden!");
        }
    }
}