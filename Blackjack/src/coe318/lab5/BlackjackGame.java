/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author i2wahid
 */

package coe318.lab5;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class BlackjackGame {

  private CardPile deck;
  private CardPile houseCards;
  private CardPile yourCards;
  private boolean houseDone;
  private boolean playerDone;
  private UserInterface ui;

  public BlackjackGame(UserInterface ui) {
    this.ui = ui;
    ui.setGame(this);
    deck = new CardPile();
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));
      }
    }
    houseCards = new CardPile();
    yourCards = new CardPile();
    houseDone = false;
    playerDone = false;
  }

  public void start() {
    Card c;
    c = deck.removeRandom();
    c.setFaceUp(false);
    getHouseCards().add(c);
    getHouseCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    ui.display();
  }

  public void play() {
    while (!houseDone || !playerDone) {
      if (!houseDone) {
        if (score(getHouseCards()) <= 17) {
          getHouseCards().add(deck.removeRandom());
          ui.display();
        } else {
          houseDone = true;
        }
      }
      if (!playerDone) {
        if (ui.hitMe()) {
          getYourCards().add(deck.removeRandom());
          ui.display();
        } else {
          playerDone = true;
        }
      }
    }
  }

  public void end() {
    getHouseCards().getCards().get(0).setFaceUp(true);
    ui.gameOver();
  }
  
  /**
   * Determine the score of a pile of cards.
   *
   * @param p
   * @return the score
   */
  
  /*
  Instructions (in Overview):
  An Ace has a score of 1. (This differs from real Blackjack where the Ace can have a score of
  either 1 or 11 at the player's discretion. The simplified version for this lab is easier to
  program.)
  A Jack, Queen or King has a score of 10.
  All other cards have a score equal to their rank. (For example, the 4 of Hearts or the 4 of
  any suit have a rank of 4 and a score of 4.)
  */
  public int score(CardPile p) {
        int score = 0; //set initial --> this will change the value of score
        for (Card card : p.getCards()) { //loop through the cards of object p and check:
            if (card.rank == 14) { //is rank =14 (Ace has a score of 1)
                score = score + 1;
            }
            else if (card.rank > 10) { //else if the rank is bigger than 10 (Jack, Queen or King has a score of 10)
                score = score + 10;
            }
            else { //for all other ranks, their score is equal to their ranks
                score = score + card.rank;
            }
        }
        return score; //return updated score
  }
  
  /**
   * @return the houseCards
   */
  public CardPile getHouseCards() {
    return houseCards;
  }

  /**
   * @return the yourCards
   */
  public CardPile getYourCards() {
    return yourCards;
  }

  public static void main(String[] args) {
    BlackjackGame game = new BlackjackGame(new SimpleUI());
    game.start();
    game.play();
    game.end();
  }
}