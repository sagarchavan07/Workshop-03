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
            System.out.println("sequencing the Players order..");
            int n=Player.playerList.size();
            for (int i = 0; i < n; i++) {
                Player player=null;
                do {
                    System.out.println("enter player-" + (i + 1) + " name");
                    player = Player.getPlayer(scanner.next());
                    swapPlayer(i, Player.playerList.indexOf(player));
                }while (player == null);

            }
        }

    }
    public void swapPlayer(int i, int j){
        Player player=Player.playerList.get(i);
        Player.playerList.add(i,Player.playerList.get(j));
        Player.playerList.add(j,player);
    }

    public static void main(String[] args) {
        DeckOfCards deckOfCards=new DeckOfCards();
        deckOfCards.initializeCards();
        deckOfCards.addPlayers();
        deckOfCards.changePlayerOrder();

    }
}
