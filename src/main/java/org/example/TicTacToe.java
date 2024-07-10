package org.example;

import java.util.Scanner;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;


    public TicTacToe(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentPlayer = player1;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        board.print();

        while(true){

            System.out.println("current player: "+currentPlayer);
            System.out.println("enter row (0-2): ");
            int x = sc.nextInt();
            while(x<0 || x>2){
                System.out.println("invalid input, try again: ");
                x=sc.nextInt();
            }

            System.out.println("enter column (0-2): ");
            int y = sc.nextInt();
            while(y<0 || y>2){
                System.out.println("invalid input, try again: ");
                y=sc.nextInt();
            }


            if(board.isCellEmpty(x,y)) {
                board.place(x, y, currentPlayer.getMarker());
                board.print();
                System.out.println();
                System.out.println("------------");
                if (board.checkWin(currentPlayer.getMarker())) {
                    board.print();
                    System.out.println(currentPlayer + " won!");
                    System.out.println();
                    System.out.println("------------");
                    board.clear();
                } else if (board.isFull()) {
                    board.print();
                    System.out.println("draw");
                }
                switchCurrentPlayer();
            }else{
                System.out.println("invalid move, try again");

            }
        }
    }

    private void switchCurrentPlayer(){
        if(currentPlayer==player1){
            currentPlayer = player2;
        }else{
            currentPlayer = player1;
        }

    }

}
