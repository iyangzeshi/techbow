package bq_resume.chess;

public class Board {
    private final Piece[][] maze;

    public Board() {
        int rows = 8;
        int cols = 8;
        maze = new Piece[rows][cols];
    }
}
