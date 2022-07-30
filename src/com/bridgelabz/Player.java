package com.bridgelabz;

import java.util.ArrayList;

public class Player {

    private String name;
    Card[] playerCards =new Card[9];
    static ArrayList<Player> playerList=new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public static void addPlayer(Player player){
        playerList.add(player);
    }

    public static void swapPlayer(int i, int j){
        Player player=playerList.get(i);
        playerList.set(i,playerList.get(j));
        playerList.set(j,player);
    }
    public static Player getPlayer(String name){
        Player player1=null;
        for (Player player:playerList) {
            if (player.getName().equalsIgnoreCase(name)) {
                player1 = player;
                break;
            }
        }
        return player1;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card[] getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(Card[] playerCards) {
        this.playerCards = playerCards;
    }

    @Override
    public String toString() {
        return name + ' ';
    }
}
