package com.bridgelabz;

import java.util.ArrayList;
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
            System.out.println("enter new planer name");
            String playerName=scanner.next();
            Player.addPlayer(new Player(playerName));
        }
        System.out.println("players added: "+numOfPlayers);
    }

    void changePlayerOrder(){
        System.out.println(Player.playerList);
        System.out.print("Do you want to change Player Order (y/n): ");

        if (scanner.next().equalsIgnoreCase("y")){
            int n=Player.playerList.size();
            for (int i = 0; i < n; i++) {
                Player player=null;
                do {
                    System.out.println("enter player-" + (i + 1) + " name");
                    player = Player.getPlayer(scanner.next());
                    Player.swapPlayer(i, Player.playerList.indexOf(player));
                }while (player == null);
            }
        }
        System.out.println(Player.playerList);
    }

    void shuffleCards(){
        System.out.println("shuffling Cards...");
        for (int i = 0; i < Card.cardArray.length; i++) {
            int random= ( (int)( Math.random()*1000 ) % (Card.cardArray.length-1) );
            swapCards(i,random);
        }
        printCards(Card.cardArray);
    }
    void swapCards(int i, int j){
        Card temp=Card.cardArray[i];
        Card.cardArray[i]=Card.cardArray[j];
        Card.cardArray[j]=temp;
    }
    public void distributeCards(ArrayList<Player> playerList, Card[] cardArray){
        System.out.println("distributing cards...");
        int cardIndex=0;
        for (Player player:playerList) {
            for (int i = 0; i < 9; i++) {
                player.playerCards[i]=cardArray[cardIndex++];
            }
        }
    }
    public static void main(String[] args) {
        DeckOfCards deckOfCards=new DeckOfCards();
        deckOfCards.initializeCards();
        deckOfCards.addPlayers();
        deckOfCards.changePlayerOrder();
        deckOfCards.shuffleCards();
        deckOfCards.distributeCards(Player.playerList,Card.cardArray);
    }
}
