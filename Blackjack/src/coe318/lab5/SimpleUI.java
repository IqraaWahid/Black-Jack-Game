/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab5;

/**
 *
 * @author i2wahid
 */

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        //follow the sample output given
        System.out.println("House holds:\n" + this.game.getHouseCards().toString());
        System.out.println("You Hold:\n" + this.game.getYourCards().toString());
    }

  @Override
    public boolean hitMe() {
        System.out.println("Another card (y/n)? ");
        String userChoice = user.next();
        boolean choice = false; //store user's choice in this boolean variable
        switch(userChoice) {
            case "n": choice = false;//if user doesn't want another card:
                break;
            case "y": choice = true;//if user does want a new card
                break;
            default: //if user chooses something other than 'y' or 'n':
                System.out.println("Enter 'y' or 'n' to choose yes or no, respectively.");
                hitMe(); //call method again
        }
        return choice;
    }

  @Override
    public void gameOver() { 
        this.display();//output the what house and you hold using the displau method
        int you = game.score(game.getYourCards());//store your score into variable "you"
        int house = game.score(game.getHouseCards()); // store house score into variable "house"
        System.out.println("Your Score: " + you + ", House Score: " + house);
        
        //output who wins following the instructions:
        /*
        You lose if your score is more than 21 (no matter what the House's score is).
        You lose if your score is the same as the House's.
        
        You win if: You don't go over 21 and the House does go over 21
        Both your scores are 21 or under and your score is more than the House's.
        */
        //You win if:
        if(you<=21 && (you>house || house>21)) {
            System.out.println("You Win!");
        }
        else {//You lose (house wins), otherwise...:
            System.out.println("House Wins!");
        }
    }

}