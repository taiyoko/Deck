/*
 * Sarah Overlander
 * CSC 3410 Fall 2015
 * Assignment 1
 */
package deck;

import java.util.Vector;
import java.util.Random;
import java.util.Collections;


/**
 * This program is designed to create a vector that is a deck of cards.
 * The deck is initialized with the cards grouped by suits (hearts, clubs,
 * spades, and diamonds) then by card value order within each suit.
 * The listing of the cards is displayed on screen, then the deck is shuffled 
 * at least 20 times and displayed again.
 * 
 * The shuffling algorithm is the Fisher-Yates shuffle, using a new Random seed
 * with each shuffle pass. The function nextInt is pseudorandom based on the
 * seed, thus why I chose to change seeds each pass.
 */
public class Deck {

    /**
     * The only command line argument is for times to shuffle, if it is less
     * than 20, it will shuffle 20 times, if greater, it will shuffle the
     * specified number of times.
     */
    public static void main(String[] args) {
        int times = 0;
        if (args.length > 0) {
            try {
                times = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer greater than 20.");
                System.exit(1);
            }
        }
        
        Vector<Object> deck = new Vector<>(13,1);
        
        /**
         * This loop initializes all the card objects into the vector and prints
         * the deck to the standard output as cards are created. The outer loop,
         * 0-3 determines suit, and the inner loop determines value, then adds 
         * the card to the vector and prints it, with an exception for Aces
         * being added before the inner loop due to needing to be value 1 but
         * print before Kings (as though they were rank 14).
         */
        for (int i = 0; i < 4; i++) {
	    String initSuit = null;
                switch (i) {
                    case 0: initSuit = "Hearts";
                            break;
                    case 1: initSuit = "Clubs";
                            break;
                    case 2: initSuit = "Spades";
                            break;
                    case 3: initSuit = "Diamonds";
                            break;
                }

	/**
	 * This is to add the ace for each suit, given that Aces are high and
	 * thus don't really work with the rest of the inner loop.
	 */

	    deck.addElement(new Card(1, initSuit));
	    Card toPrint = (Card)deck.lastElement();
	    printCard(toPrint);

            for (int j = 13; j > 1; j--) {
                deck.addElement(new Card((j), initSuit));
                toPrint = (Card)deck.lastElement();
                printCard(toPrint);
            }
        }
        /**
         * This section calls the Shuffle function, ensuring that the deck is
         * shuffled at least 20 times, though command line arguments allow for
         * more shuffling passes.
         */
        if (times <= 20) {
            Shuffle(deck, 20);
            times = 20;
        } else {
            Shuffle(deck, times);
        }
        /**
         * This section adds space between the first printing of the ordered
         * deck and the now shuffled deck, then prints out how many times it
         * was shuffled and the results.
         */
        System.out.println("\n\n\n");
        System.out.println("After shuffling the deck " + times + " times:");
        for (int m = 0; m < 52; m++) {
            //Elements of the vectore are stored as Objects, so we must cast
            //them back to the Card type before we can print them.
            Card currentCard = (Card)deck.get(m);
            printCard(currentCard);
        }
    }
    
    private static void Shuffle(Vector v, int t) {
        for (int p = 0; p < t; p++){
            Random r = new Random();
            for (int q = 0; q < 50; q++) {
                Collections.swap(v, q, r.nextInt(51));
            }
        }
    }
    
    /**
     * This function is to consolidate card printing to output into one place,
     * rather than have the same code in two places. 
     */
    private static void printCard(Card c) {
        int currentValue = c.getValue();
        String currentSuit = c.getSuit();
        switch (currentValue) {
                case 1: System.out.println("Ace of " + currentSuit);
                        break;
                case 13: System.out.println("King of " + currentSuit);
                        break;
                case 12: System.out.println("Queen of " + currentSuit);
                        break;
                case 11: System.out.println("Jack of " + currentSuit);
                        break;
                default: System.out.println(currentValue + " of " + currentSuit);
                        break;
        }
    }
}