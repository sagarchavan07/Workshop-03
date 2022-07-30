package com.bridgelabz;

import java.util.Scanner;

public class DeckOfCards {
    static Scanner scanner=new Scanner(System.in);
    void initializeCards(){
        System.out.println("initializing cards...");
        int cardIndex=0;
        for (int i = 0; i < Card.suitArray.length; i++) {
            for (int j = 0; j < Card.rankArray.length; j++) {
                Card card=new Card(Card.suitArray[i],Card.rankArray[j]);
                Card.cardArray[cardIndex++]=card;
            }
        }
        printCards(Card.cardArray);
    }
    void printCards(Card[] cards){
        System.out.print("Cards{");
        for (Card card : cards) {
            System.out.print(card.getSuit() + "-" + card.getRank() + ", ");
        }
        System.out.println("}");
    }
    void addPlayers(){
        int numOfPlayers;
        do {
            System.out.println("Enter number of players (2 to 4): ");
            numOfPlayers = scanner.nextInt();
        } while (numOfPlayers < 2 || numOfPlayers > 4);
        for (int i = 0; i < numOfPlayers; i++) {
            Player.addPlayer(new Player());
        }
        System.out.println("players added: "+numOfPlayers);
    }

    public static void main(String[] args) {
        DeckOfCards deckOfCards=new DeckOfCards();
        deckOfCards.initializeCards();
        deckOfCards.addPlayers();
    }
}
