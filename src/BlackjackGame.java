import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        // Deal initial cards
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        // Player's turn
        System.out.println("Your hand: " + playerHand);
        System.out.println("Your score: " + playerHand.calculateScore());
        while (playerHand.calculateScore() < 21) {
            System.out.println("Do you want to Hit (H) or Stand (S)?");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("H")) {
                playerHand.addCard(deck.drawCard());
                System.out.println("Your hand: " + playerHand);
                System.out.println("Your score: " + playerHand.calculateScore());
            } else if (choice.equalsIgnoreCase("S")) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter H or S.");
            }
        }

        // Dealer's turn
        System.out.println("Dealer's hand: " + dealerHand);
        System.out.println("Dealer's score: " + dealerHand.calculateScore());
        while (dealerHand.calculateScore() < 17) {
            dealerHand.addCard(deck.drawCard());
            System.out.println("Dealer hits. Dealer's hand: " + dealerHand);
            System.out.println("Dealer's score: " + dealerHand.calculateScore());
        }

        // Determine winner
        int playerScore = playerHand.calculateScore();
        int dealerScore = dealerHand.calculateScore();
        if (playerScore > 21) {
            System.out.println("Bust! You lose.");
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (playerScore == dealerScore) {
            System.out.println("It's a tie.");
        } else {
            System.out.println("Dealer wins.");
        }
    }
}