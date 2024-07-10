package org.example;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player('X');
        Player player2 = new Player('O');
        TicTacToe game = new TicTacToe(player1,player2);
        game.start();
    }
}