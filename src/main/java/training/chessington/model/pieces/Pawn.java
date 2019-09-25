package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        ArrayList<Move> moves = new ArrayList<>();

        if (from.getRow() >= 1 && from.getRow() <= 6) {
            addMove(from, moves, board);
        }

        return moves;
    }

    private void addMove(Coordinates from, ArrayList<Move> moves, Board board){
        move(from, moves, board);
        take(from, moves, board);
    }

    private void move(Coordinates from, ArrayList<Move> moves, Board board){
        if (getColour() == PlayerColour.WHITE) {

            if (from.getRow() == 6){

                nextMove(from, -2, moves, board);
            }
            nextMove(from, -1, moves, board);
        }
        else {

            if (from.getRow() == 1){

                nextMove(from, 2, moves, board);
            }
            nextMove(from, 1, moves, board);
        }
    }

    private static void nextMove(Coordinates from,int row, ArrayList<Move> moves, Board board){

        Coordinates front = new Coordinates(from.getRow() + row, from.getCol());
        if (board.get(front) == null) {
            Coordinates to = new Coordinates(from.getRow() + row, from.getCol());
            Move move = new Move(from, to);
            moves.add(move);
        }
    }

    private void take(Coordinates from, ArrayList<Move> moves, Board board) {
        if (getColour() == PlayerColour.WHITE) {
            nextTake(from, -1, -1, moves, board);
            nextTake(from, -1, 1, moves, board);
        }
        else {
            nextTake(from, 1, -1, moves, board);
            nextTake(from, 1, 1, moves, board);
        }
    }

}
