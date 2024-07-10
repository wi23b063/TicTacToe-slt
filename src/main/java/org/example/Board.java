package org.example;

public class Board {
    private char[][] cells;

    public Board(){
        cells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '-';
            }
        }

    }

    public boolean isCellEmpty(int x, int y){
        return cells[x][y] == '-';
    }

    public void place(int x, int y, char marker){
        if((x<3 && x>=0)&&(y<3 && y>=0)&& isCellEmpty(x,y)){
            this.cells[x][y] = marker;
        }
    }

    public boolean isFull(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if(cells[i][j]=='-'){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(char symbol) {
        for (int i = 0; i < cells.length; i++) {
            if (checkRow(i, symbol)) return true;
        }
        for (int i = 0; i < cells.length; i++) {
            if (checkColumn(i, symbol)) return true;
        }
        return checkDiagonals(symbol);
    }

    private boolean checkRow(int row, char symbol) {
        for (int i = 0; i < cells.length; i++) {
            if (cells[row][i] != symbol) return false;
        }
        return true;
    }

    private boolean checkColumn(int col, char symbol) {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][col] != symbol) return false;
        }
        return true;
    }

    private boolean checkDiagonals(char symbol) {
        boolean diagonal1 = true, diagonal2 = true;
        for (int i = 0; i < cells.length; i++) {
            diagonal1 &= (cells[i][i] == symbol);
            diagonal2 &= (cells[i][cells.length - i - 1] == symbol);
        }
        return diagonal1 || diagonal2;
    }

    public void print(){
        for(char[] row : cells){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '-';
            }

        }
    }



}
