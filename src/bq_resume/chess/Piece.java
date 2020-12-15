package bq_resume.chess;

import java.util.List;

public abstract class Piece {

    Position curPosition;

    // return whether it can move x rows+, j cols+
    public abstract boolean move(int x, int j);

    // return whether it can move to endPosition
    public abstract boolean move(Position endPosition);

    // return the List<Postion> it can reach in one step
    public abstract List<Position> move();
}
