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

        checkRow(from, moves, board);

        return moves;
    }

    private void checkRow(Coordinates from, ArrayList<Move> moves, Board board){
        if (getColour() == PlayerColour.WHITE) {

            if (from.getRow() == 6){

                nextMove(from, -2, moves, board);
            }
            {
                nextMove(from, -1, moves, board);
            }
        }
        else {

            if (from.getRow() == 1){

                nextMove(from, 2, moves, board);
            }
            {
                nextMove(from, 1, moves, board);
            }
        }
    }

    private static void nextMove(Coordinates from,int i, ArrayList<Move> moves, Board board){

        Coordinates front = new Coordinates(from.getRow() + i, from.getCol());
        if (board.get(front) == null) {
            Coordinates to = new Coordinates(from.getRow() + i, from.getCol());
            Move move = new Move(from, to);
            moves.add(move);
        }
    }

}
