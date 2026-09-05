/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab5;

/**
 *
 * @author i2wahid
 */

public class Card implements Comparable {
  //Symbolic constants: determined by constructor input parameters
    int rank, suit;
    boolean faceUp;
    
  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) {
    this.rank=rank;
    this.suit=suit;
    this.faceUp=faceUp;
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return this.faceUp;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp=faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return this.rank;
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return this.suit;
  }
  
  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) { //checking if object ob does NOT belong to Card class
      return false;
    }
    Card c = (Card) ob; //cast "ob" to class 'Card' type
    if(this.rank==c.rank){
        return true; //since the ranks are the same, cards are equal
    }
    else{
        return false; //since the ranks are different, the cards are different
    }
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }
  
  /*The Card class compareTo(Card c) method should return a negative, zero or positive
  value depending on whether this is less than, equal to or greater than the other card.
  
  For 2 cards of unequal rank, the one with the higher rank is bigger. If the ranks are
  the same, the suit is considered; the suit orders (from lowest to highest) are Clubs, Diamonds,
  Hearts, Spades.
  
  The Card equals(Card c) method should only return true if the cards have the same suit and rank.
  */
  public int compareTo(Card c) {
    if (this.rank > c.rank){
        return 1;
    }
    else if (this.rank < c.rank){
        return -1;
    }
    else{ //if ranks of both cards are equal
        if(this.suit > c.suit){
            return 1;
        }
        else if(this.suit < c.suit){
            return -1;
        }
        else{//is rank and suit of both cards are equal
            return 0;
        }
    }
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
    // numbered cards: 1-10
    // face cards: jack:11, queen:12, king:13, ace:14
    String rank = "";
    switch(this.rank){
        case 11 : rank = "Jack";
            break;
        case 12 : rank = "Queen";
            break;
        case 13 : rank = "King";
            break;
        case 14 : rank = "Ace";
            break;
        default: rank = Integer.toString(this.rank); //when none of the cases match, the integer is converted to a string and stored into the Strign variable "rank"
    }
    return rank; //return the String "rank"
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
    String suit = "";
    
    switch(this.suit){
        case 0 : suit = "Clubs"; //if this.suit=0, then let the String "suit" = "Clubs"
            break;
        case 1 : suit = "Diamonds";
            break;
        case 2 : suit = "Hearts";
            break;
        case 3 : suit = "Spades";
            break;
        
    }
    return suit;
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
      String output = "";

      if(this.faceUp){
        output = this.getRankString() + " of " + this.getSuitString(); //returns the rank and suit obtained from the methods (so in String form)
      }
      else{
        output = "?";
      }
      return output;
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}
