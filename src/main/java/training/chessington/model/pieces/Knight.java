package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        ArrayList<Move> moves = new ArrayList<>();

        move(from, moves, board);

        return moves;
    }

    private void move(Coordinates from, ArrayList<Move> moves, Board board) {
        nextMove(from, 1, 2, moves, board);
        nextMove(from, 1, -2, moves, board);
        nextMove(from, -1, -2, moves, board);
        nextMove(from, -1, 2, moves, board);
        nextMove(from, 2, 1, moves, board);
        nextMove(from, 2, -1, moves, board);
        nextMove(from, -2, -1, moves, board);
        nextMove(from, -2, 1, moves, board);
    }

    private void nextMove(Coordinates from, int col, int row, ArrayList<Move> moves, Board board) {

        Coordinates front = new Coordinates(from.getRow() + col, from.getCol() + row);

        if (front.getCol() >= 0 && front.getCol() <= 7 && front.getRow() >= 0 && front.getRow() <= 7) {
            Piece piece = board.get(front);

            if (piece == null || piece.getColour() != getColour()) {
                Coordinates to = new Coordinates(from.getRow() + col, from.getCol() + row);
                Move move = new Move(from, to);
                moves.add(move);
            }
        }
    }
}
