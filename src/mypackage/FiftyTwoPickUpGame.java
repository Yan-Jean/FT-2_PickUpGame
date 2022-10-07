package mypackage;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
                    cardsLeft();
                    display();
                    pickCard();

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

    private void pickCard() {
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

    private void deal() {
        for (int i = 0; i < playerHand.getHand().length; i++) {
            playerHand.addCard(deck.drawCard());
        }
    }

    private void cardsLeft() {
        if (numOfCardsLeft == 0) {
            numOfCardsLeft = 52;
        }
        if (numOfCardsLeft == 1)
            System.out.println("Only 1 card left, keep up the good work!");
        else
            System.out.println("\t" + numOfCardsLeft-- + " more cards to pick up!\n");

    }


    private void display() {
        int header = 0;
        int color = 0;
        int value = 0;
        int footer = 0;
        int count = 0;
        for (int j = 0; j < playerHand.getHand().length; j += 13) {

            for (int i = 0; i < playerHand.getHand().length; i++) {

                if (playerHand.getHand()[header] == null)
                    System.out.print("      \t");
                else
                    System.out.print(" -----\t");

                if ((i + 1) % 13 == 0) {
                    System.out.println();
                    header++;
                    break;
                }
                header++;
            }

            for (int i = 0; i < playerHand.getHand().length; i++) {

                if (playerHand.getHand()[value] == null)
                    System.out.print("      \t");
                else {
                    System.out.print("   " + playerHand.showCardValue(playerHand.getHand()[value]) + "   \t");
                }

                if ((i + 1) % 13 == 0) {
                    System.out.println();
                    value++;
                    break;
                }
                value++;
            }

            for (int i = 0; i < playerHand.getHand().length; i++) {

                if (playerHand.getHand()[color] == null)
                    System.out.print("      \t");
                else {
                    System.out.print("   " + playerHand.showCardColor(playerHand.getHand()[color]) + "   \t");
                }

                if ((i + 1) % 13 == 0) {
                    System.out.println();
                    color++;
                    break;
                }
                color++;
            }

            for (int i = 0; i < playerHand.getHand().length; i++) {
                if (playerHand.getHand()[footer] == null)
                    System.out.print("      \t");
                else
                    System.out.print(" -----\t");

                if ((i + 1) % 13 == 0) {
                    System.out.println();
                    footer++;
                    break;
                }
                footer++;
            }

            for (int i = 0; i < playerHand.getHand().length; i++) {

                if (playerHand.getHand()[count] == null)
                    System.out.print("      \t");
                if (playerHand.getHand()[count] != null) {

                    if (count >= 9)
                        System.out.print("   " + (count + 1) + "   ");
                    else
                        System.out.print("   " + (count + 1) + "    ");
                }

                if ((i + 1) % 13 == 0) {
                    System.out.println("\n");
                    count++;
                    break;
                }
                count++;
            }
        }
    }

    private void playerWin() {
        System.out.println("\n\t !!! Congrats you got them all !!! Your are very patient and very brave !!!\n");
        System.out.println("\t\t\t\t\t\t\t\t\t---------  ");
        System.out.println("\t\t\t\t\t\t\t\t\t  ♦ ♦ ♦     ");
        System.out.println("\t\t\t\t\t\t\t\t\t  ♦ ♥ ♦      ");
        System.out.println("\t\t\t\t\t\t\t\t\t  ♦ ♦ ♦     ");
        System.out.println("\t\t\t\t\t\t\t\t\t---------\n");
    }

    private void getChrono() {
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

    private int setMode() {
        String choice = "";
//        String cheatCode = Integer.toString(choice);
        int parseChoice = 0;
        do {
            try {
                System.out.println("\n\t********************** SET MODE **********************");
                System.out.println("\t*    1- E-SPORT MODE - can you be the fastest?       *");
                System.out.println("\t*    2-  CHILL MODE  - no timer, just chill...       *");
                System.out.println("\t******************************************************");
                System.out.println();
                System.out.print("Select mode (1 or 2) : ");
                if (choice.equals("clear")){
                    playerWin();
                    getChrono();
                }
                choice = sc.nextLine();
                parseChoice = Integer.parseInt(choice);
                if (parseChoice < 1 || parseChoice > 2) {
                    throw new InputMismatchException();
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInput a number! 1 or 2.");
            } catch (InputMismatchException e) {
                System.out.println("\nChoose number! 1 for E-Sport Mode or choose number 2 for Chill Mode.");
            }
        } while (parseChoice < 1 || parseChoice > 2);
        return parseChoice;
    }
}
