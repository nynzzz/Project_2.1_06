package sneakthrough.Logic;

import sneakthrough.Player.HumanPlayer;
import sneakthrough.Player.Player;

public class Board {
    private Piece[][] grid;
    private int size;

    public Board() {
        this.size = 8;
        this.grid = new Piece[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        // the first two and last two rows are filled with pieces
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                // if upper 2 rows
                if(i < 2){
                    int[] position = {i, j};
                    grid[i][j] = new Piece("black", false, position);
                }
                // if bottom 2 rows
                else if(i > size - 3){
                    int[] position = {i, j};
                    grid[i][j] = new Piece("white", false, position);
                }
                // if middle rows
                else{
                    grid[i][j] = null;
                }
            }
        }
    }

    public void printBoard(){
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                if(grid[i][j] == null){
                    System.out.print("0");
                }
                else{
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }

    public Piece[][] getGrid() {
        return grid;
    }

    public void setGrid(Piece[][] grid) {
        this.grid = grid;
    }

    public int getSize() {
        return size;
    }

    public void removeCapturedPiece(Piece piece){
        int[] position = piece.getPosition();
        grid[position[0]][position[1]] = null;
    }
}