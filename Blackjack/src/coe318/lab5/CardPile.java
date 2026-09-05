/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab5;

/**
 *
 * @author i2wahid
 */

import java.util.ArrayList;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;

    public CardPile() {
        //Initialize the instance variable.
        cards = new ArrayList<Card>(); //will only hold type Card data
    }
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) {
        this.cards.add(card);// adding a card to the arraylist pile
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
        int n = (int) (Math.random()*this.cards.size()); //random number generator from zero to the size of the array lift
        return (this.cards.remove(n));//remove the card with the element n (chosen at random)
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        String allCards = "";
        for(Card card: this.cards) { //loops through each Card object in the arraylist "cards"
            allCards = allCards + card.toString() + "\n";
        }
        return allCards; //return string containing all cards
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }
}