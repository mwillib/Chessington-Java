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

        if (getColour() == PlayerColour.WHITE) {

            if (from.getRow() == 6){

                nextMove(from, -2, moves);
            }
            {
                nextMove(from, -1, moves);
            }


        }
        else {

            if (from.getRow() == 1){

                nextMove(from, 2, moves);
            }
            {
                nextMove(from, 1, moves);
            }
        }

        return moves;
    }

    private static void nextMove(Coordinates from,int i, ArrayList<Move> moves){

        Coordinates to = new Coordinates(from.getRow() + i, from.getCol());
        Move move = new Move(from, to);
        moves.add(move);
    }

    private static
}
