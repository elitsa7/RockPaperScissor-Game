import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let's play Rock-Paper-Scissors!");

        while (true) {
            System.out.println("Choose your weapon (1 = Rock, 2 = Paper, 3 = Scissors): ");
            int playerChoice = scanner.nextInt();

            if (playerChoice < 1 || playerChoice > 3) {
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;

            System.out.println("You chose " + weaponToString(playerChoice));
            System.out.println("Computer chose " + weaponToString(computerChoice));

            String result = determineWinner(playerChoice, computerChoice);
            System.out.println(result);

            System.out.println("Do you want to play again? (y/n)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
    }

    private static String weaponToString(int weapon) {
        if (weapon == 1) {
            return "Rock";
        } else if (weapon == 2) {
            return "Paper";
        } else if (weapon == 3) {
            return "Scissors";
        } else {
            return "";
        }
    }

    private static String determineWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return "This game is draw";
        } else if ((playerChoice == 1 && computerChoice == 3)
                || (playerChoice == 2 && computerChoice == 1)
                || (playerChoice == 3 && computerChoice == 2)) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}

