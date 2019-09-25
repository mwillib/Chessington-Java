package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }

    protected boolean checkOnBoard(Coordinates from, int col, int row) {
        Coordinates front = new Coordinates(from.getRow() + row, from.getCol() + col);

        return front.getCol() >= 0 && front.getCol() <= 7 && front.getRow() >= 0 && front.getRow() <= 7;
    }

    protected void nextTake(Coordinates from, int col, int row, ArrayList<Move> moves, Board board){

        Coordinates front = new Coordinates(from.getRow() + row, from.getCol() + col);

        if (front.getCol() >= 0 && front.getCol() <= 7 && front.getRow() >= 0 && front.getRow() <= 7) {
            Piece piece = board.get(front);

            if (piece != null && piece.getColour() != getColour()) {
                Coordinates to = new Coordinates(from.getRow() + row, from.getCol() + col);
                Move move = new Move(from, to);
                moves.add(move);
            }
        }
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }
}
