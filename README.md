# Exercise: Player Deck - For the Java + Angular bootcamp from The Software Guild 

## Overview
This exercise has the main goal of allowing you to show off your mastery at manipulating arrays.

You will create a card deck application that allows the player to shuffle a deck of cards and play a card game that draws and plays cards until all cards in the deck have been used.

## Instructions
The application must be able to perform the following tasks:

At the start of a new game, it shuffles all cards using a deck shuffler.\
The player then draws X number of cards from the deck and "plays" the cards by displaying them in the UI.\
The played cards are then added to a discard pile.\
The player draws X new cards and repeats playing and discarding cards.\
When there are no cards left in the deck, the game should ask the player if they want to play again.\
If the answer is yes, create a new deck with the discard pile and start again.\
If the answer is no, end the game with a creative message to the player.

## Requirements
The application must include the following features:

The player must be able to continue drawing cards without errors.\
It should include different methods for drawing, shuffling and playing cards.\
It must include three arrays of a Card, using a custom class that includes {Title: String, Description: String}.
