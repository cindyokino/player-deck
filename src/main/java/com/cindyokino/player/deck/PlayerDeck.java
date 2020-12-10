package com.cindyokino.player.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Cindy
 */
public class PlayerDeck {
//        static int remainingCards = 52;
        
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        String answer = "";        
        List<Card> deckCards = new ArrayList<Card>();
        List<Card> playerCards = new ArrayList<Card>();
        List<Card> discardCards = new ArrayList<Card>();
        int numberOfCards = 52;
        int remainingCards = numberOfCards;
        
        // ================ Create the deck - this code will run once when start the app ================
        for (int i = 1; i <= numberOfCards; i++) {
            Card card = new Card(("Card " + i).toString(), ("This is the card " + i).toString());
            deckCards.add(card);
        }
        
        // ================ Play the game ================   
        while (!answer.equals("no")) {
            startGame(deckCards);  
            
            while (remainingCards > 0) { 
                manageCards(deckCards, playerCards, discardCards, remainingCards);
                remainingCards = deckCards.size();
            }
            
            while (!answer.equals("no")) {
                System.out.println("There are no more cards in the deck, would you like to play again? (yes / no)");
                answer = scn.nextLine();
                if (answer.equals("yes")) {
                    deckCards = discardCards;
                    discardCards = new ArrayList<Card>();
                    remainingCards = numberOfCards;
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
    public static void startGame(List<Card> deckCards) {    
        Collections.shuffle(deckCards);  // Shuffle cards from deckCards
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" >>> Welcome to the Hardest Card Game! <<< ");
    }         
    
    // ================ Method to ask how many cards to draw from deckCards ================
    public static int insertNumberToDraw(List<Card> deckCards, int remainingCards) {         
        Scanner scn2 = new Scanner(System.in);
        System.out.println("");        
        System.out.println("You have " + remainingCards + " remaining cards, please type how many cards do you want:");
        int n = scn2.nextInt();
        while (n > deckCards.size()) {
            System.out.println();
            System.out.println("Try again... You have " + remainingCards + " remaining cards, please type how many cards do you want:");
            n = scn2.nextInt();            
        }
        return n;
    }
    
    // ================ Method to draw cards from deckCards, and pass these cards from deckCards to playerCards ================
    public static List<Card> manageCards(List<Card> deckCards, List<Card> playerCards, List<Card> discardCards, int remainingCards) {
        int numberOfCardsToDraw = insertNumberToDraw(deckCards, remainingCards);   
        playerCards = new ArrayList<Card>(deckCards.subList(0, numberOfCardsToDraw)); // copy the first X cards from deckCards and save them as playerCards
        displayCards(playerCards);
        discardCards.addAll(playerCards); // copy the playerCards to the discardCards pile
        for (int i = 0; i < numberOfCardsToDraw; i++){ // delete the X cards from deckCards 
            deckCards.remove(0); //always delete from the top of the deck
       }
        return discardCards;
    }
    
    // ================ Method to display (print) cards from playerCards ================
    public static void displayCards(List<Card> playercards) {
        System.out.println("");
        System.out.println("This are your cards:");
        for (Card card : playercards) {
            System.out.println(card.getTitle());
        }
        System.out.println("------------------------------------------------------------");
    }
    
    
    
}
