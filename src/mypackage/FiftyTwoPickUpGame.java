package mypackage;

import java.util.ArrayList;
import java.util.Scanner;

public class FiftyTwoPickUpGame {
    private Hand playerHand;
    private Deck deck;
    private static int numOfCardsLeft = 52;

    StopWatch sw = new StopWatch();
    Scanner sc = new Scanner(System.in);

    public FiftyTwoPickUpGame() {

        String playAgain = "y";
        System.out.println("\n\n\n\t The FT-2 Pick Up Game\n");

        while (playAgain.equalsIgnoreCase("y")) {

            if (setMode() == 1) {

                this.deck = new Deck();
                this.playerHand = new Hand("PLAYER", 52);
                deal();
                sw.start();
                for (int i = 0; i < playerHand.getHand().length; i++) {
                    System.out.println("\n!!! SPORT MODE !!! HURRY UP !!!\n");
                    display();
                    pickCard();
                    cardsLeft();
                }
                sw.stop();
                playerWin();
                getChrono();


            } else {

                this.deck = new Deck();
                this.playerHand = new Hand("PLAYER", 52);
                deal();
                for (int i = 0; i < playerHand.getHand().length; i++) {
                    System.out.println("\n... ~<YAH MAN> ... <CHILL MODE> ... <JUST CHILL>~ ...\n");
                    display();
                    pickCard();
                    cardsLeft();

                }
                playerWin();
            }

            System.out.print("\nPlay again? (y,n) ");
            playAgain = sc.nextLine();
        }
    }

    public void pickCard() {
        int num = 0;
        while (num <= 0 || num > 52) {
            try {
                do {
                    System.out.print("\nEnter the number of the card you want to pick up: ");
                    num = Integer.parseInt(sc.nextLine()); // num = sc.nextInt();
                    if (num <= 0 || num > 52 || playerHand.getHand()[num - 1] == null)
                        System.out.println("Enter a valid number.");
                } while (num <= 0 || num > 52 || playerHand.getHand()[num - 1] == null);
                this.playerHand.getHand()[num - 1] = null;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid numeric value.");
            }
        }
    }

    public void deal() {
        for (int i = 0; i < playerHand.getHand().length; i++) {
            playerHand.addCard(deck.drawCard());
        }
    }

    private void cardsLeft() {
        if (numOfCardsLeft == 0) {
            numOfCardsLeft = 52;
        }
        System.out.println("\n\t" + --numOfCardsLeft + " more cards to pick up!");
    }


    public void display() {

        for (int j = 0; j < playerHand.getHand().length; j += 13) {
            boolean onOff = true;

            while (onOff) {

                for (int i = 0; i < playerHand.getHand().length; i++) {
                    if (playerHand.getHand()[i] == null)
                        System.out.print("      \t");
                    else
                        System.out.print(" -----\t");
                    // Passe à l'autre ligne d'impression.
//                    if (i == playerHand.getHand().length - 1)
//                        System.out.println();
                    if ((i + 1) % 13 == 0) {

                        System.out.println();
                    }
                    onOff = false;
                }
            }
            onOff = true;
            while (onOff) {
                for (int i = 0; i < playerHand.getHand().length; i++) {
                    if (playerHand.getHand()[i] == null)
                        System.out.print("      \t");
                    else
                        System.out.print("   " + playerHand.showCardValue(playerHand.getHand()[i]) + "   \t");
                    // Passe à l'autre ligne d'impression.
//                    if (i == playerHand.getHand().length - 1)
//                        System.out.println();
                    if ((i + 1) % 13 == 0) {
                        onOff = false;
                        System.out.println();

                    }
                }
            }
            onOff = true;
            while (onOff) {
                for (int i = 0; i < playerHand.getHand().length; i++) {
                    if (playerHand.getHand()[i] == null)
                        System.out.print("      \t");
                    else
                        System.out.print("   " + playerHand.showCardColor(playerHand.getHand()[i]) + "   \t");
                    // Passe à l'autre ligne d'impression.
//                    if (i == playerHand.getHand().length - 1)
//                        System.out.println();
                    if ((i + 1) % 13 == 0) {
                        onOff = false;
                        System.out.println();

                    }
                }
            }
            onOff = true;
            while (onOff) {
                for (int i = 0; i < playerHand.getHand().length; i++) {
                    if (playerHand.getHand()[i] == null)
                        System.out.print("      \t");
                    else
                        System.out.print(" -----\t");
                    // Passe à l'autre ligne d'impression.
//                    if (i == playerHand.getHand().length - 1)
//                        System.out.println();
                    if ((i + 1) % 13 == 0) {
                        onOff = false;
                        System.out.println();

                    }
                }
            }
            onOff = true;
            while (onOff) {
                for (int i = 0; i < playerHand.getHand().length; i++) {

                    if (playerHand.getHand()[i] == null)
                        System.out.print("      \t");
                    if (playerHand.getHand()[i] != null) {
//                System.out.print("");
                        if (i >= 9)
                            System.out.print("   " + (i + 1) + "   ");
                        else
                            System.out.print("   " + (i + 1) + "    ");
                    }
                    // Passe à l'autre ligne d'impression.
//                    if (i == playerHand.getHand().length - 1)
//                        System.out.println();
                    if ((i + 1) % 13 == 0) {
                        onOff = false;
                        System.out.println();

                    }
                }
            }

        }
    }

    private void playerWin() {
        System.out.println("\n\t !!! Congrats you got them all !!! Your are very patient and very brave !!!");
    }

    public void getChrono() {
//        long numberOfDays = sw.getElapsedTimeSecs() / 86400;
//        long numberOfHours = (sw.getElapsedTimeSecs() % 86400) / 3600;
        long numberOfMinutes = ((sw.getElapsedTimeSecs() % 86400) % 3600) / 60;
        long numberOfSeconds = ((sw.getElapsedTimeSecs() % 8640) % 3600) % 60;

        if (numberOfMinutes == 0)
            System.out.println("\tIt took you " + numberOfSeconds + " seconds to put back the deck together !!! Can you do better !?!");
        else if (numberOfMinutes == 1)
            System.out.println("\tIt took you " + numberOfMinutes + " minute and " + numberOfSeconds + " seconds to put back the deck together !!! Can you do better !?!");
        else
            System.out.println("\tIt took you " + numberOfMinutes + " minutes and " + numberOfSeconds + " seconds to put back the deck together !!! Can you do better !?!");
    }

    public int setMode() {
        int choice;
        do {
            System.out.println("\n\t********************** SET MODE **********************");
            System.out.println("\t*    1- E-SPORT MODE - can you be the fastest?       *");
            System.out.println("\t*    2-  CHILL MODE  - no timer, just chill...       *");
            System.out.println("\t******************************************************");
            System.out.println();
            System.out.print("Select mode (1 or 2) : ");
            choice = Integer.parseInt(sc.nextLine());
        } while (choice < 1 || choice > 2);
        return choice;

    }
}
