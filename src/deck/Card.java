/*
 * Sarah Overlander
 */
package deck;

/**
 * This class is used to define Card objects. Each card has a value and a suit.
 * Each property of a card has corresponding getters and setters.
 */
public class Card {

    private int value; //holds card numerical value
    private String suit; //holds card suit
    
    //Initilization
    public Card(int initvalue, String initsuit) {
        this.value = initvalue;
        this.suit = initsuit;
    }
    
    //Getters
    public int getValue() {
        return value;
    }
    
    public String getSuit() {
        return suit;
    }    
    
    //Setters
    public void setValue(int x) {
        this.value = x;
    }

    public void setSuit(String string) {
        this.suit = string;
    }
}
