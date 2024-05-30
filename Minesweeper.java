package Minesweeper;

import java.util.Random;

public class Minesweeper {
    boolean[][] mines;
    byte[][] solvedBoard;
    final static byte MINE = 9;
    public Minesweeper(int width, int height, int mines) {
        this.mines = generateMines(width, height, mines);
        this.solvedBoard = solvedBoard(this.mines);
        print2dArray(solvedBoard);
    }
    private boolean[][] generateMines(int width, int height, int mines) {
        boolean[][] result = new boolean[height][width];
        Random random = new Random();
        for (int i = 0; i < mines; ) {
            var loc = new Location(random.nextInt(width), random.nextInt(height));
            if (result[loc.y][loc.x]) {
                continue;
            }
            result[loc.y][loc.x] = true;
            i++;
        }
        return result;
    }
    private byte[][] solvedBoard(boolean[][] board) {
        byte[][] result = new byte[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                byte surrounding = surroundingMines(board, new Location(col, row));
                result[row][col] = surrounding;
            }
        }
        return result;
    }
    private byte surroundingMines(boolean[][] mines, Location loc) {
        if (mines[loc.y][loc.x]) {
            return MINE;
        }
        byte surroundingMines = 0;
        for (int row = loc.y - 1; row <= loc.y + 1; row++) {
            for (int col = loc.x - 1; col <= loc.x + 1; col++) {
                try{
                    if (mines[row][col]) {
                        surroundingMines++;
                    }
                } catch (IndexOutOfBoundsException e){}
            }
        }
        return surroundingMines;
    }
    private class Location {
        int x, y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private void print2dArray(byte[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new MinesweeperVisual();
        new Minesweeper(25, 50, 100);
    }
}
