package com.cindyokino.player.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Cindy
 */
public class PlayerDeck {
        static int remainingCards;
        
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int numberOfCards = 52;
        String answer = "";        
        ArrayList<Card> deckCards = new ArrayList<Card>();
        ArrayList<Card> playerCards = new ArrayList<Card>();
        ArrayList<Card> discardCards = new ArrayList<Card>();
        
        // ================ Create the deck ================
        for (int i = 0; i < numberOfCards; i++) {
            Card card = new Card();
            deckCards.add(card);
        }
        
        // ================ Play the game ================
        while (!answer.equals("no")) {
            startGame(deckCards);   

            while (remainingCards > 0) {
                insertNumberToDraw(deckCards, remainingCards);
    //            drawCards(deckCards);
    //            displayCards();
                calculateRemainingNumberOfCards(deckCards, discardCards);          
            }

//            System.out.println("There are no more cards in the deck, would you like to play again? (yes / no)");
//            answer = scn.nextLine();
            
            while (!answer.equals("no")) {
                System.out.println("There are no more cards in the deck, would you like to play again? (yes / no)");
                answer = scn.nextLine();
                if (answer.equals("yes")) {
                    break;
                }
                if (answer.equals("no")) {
                    System.out.println(); 
                    System.out.println("Thank you for playing the most famous Card Game in the world!!!"); 
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");      
                    break;
                }
            }
        }
    }
    
     // ================ Method to start the game - shuffle cards and welcome the player ================
    public static void startGame(ArrayList<Card> deckCards) {    
        Collections.shuffle(deckCards);  // Shuffle cards from deckCards
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" >>> Welcome to the Hardest Card Game! <<< ");
        System.out.println();
    }    
    
    // ================ Method to calculate the remaining number of cards from deckCards ================
    public static int calculateRemainingNumberOfCards(ArrayList<Card> deckCards, ArrayList<Card> discardCards) {
        remainingCards = deckCards.size() - discardCards.size();
        return remainingCards;
    }    
    
    // ================ Method to draw cards from deckCards ================
    public static int insertNumberToDraw(ArrayList<Card> deckCards, int remainingCards) {
        Scanner scn2 = new Scanner(System.in);
        System.out.println("You have " + remainingCards + " remaining cards, please type how many cards do you want:");
        int n = scn2.nextInt();
        while (n < deckCards.size()) {
            System.out.println("You have " + remainingCards + " remaining cards, please type how many cards do you want:");
            n = scn2.nextInt();            
        }
        return n;
    }
    
}
