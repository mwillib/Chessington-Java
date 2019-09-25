package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        ArrayList<Move> moves = new ArrayList<>();

        moveH(from, moves, board);
        moveV(from, moves, board);

        return moves;

    }

    private void moveH(Coordinates from, ArrayList<Move> moves, Board board) {

        for (int i = 0; i <= 14; i++) {
            nextMoveH(from, 0, i - 7, moves, board);
        }

    }

    private void moveV(Coordinates from, ArrayList<Move> moves, Board board) {

        for (int i = 0; i <= 14; i++) {
            nextMoveV(from, i - 7, 0, moves, board);
        }

    }

    private void nextMoveH(Coordinates from, int col, int row, ArrayList<Move> moves, Board board) {

        if (checkOnBoard(from, col, row)) {
            Coordinates front = new Coordinates(from.getRow() + row, from.getCol());
            Piece piece = board.get(front);

            if (piece == null || piece.getColour() != getColour()) {
                Coordinates to = new Coordinates(from.getRow() + row, from.getCol());
                Move move = new Move(from, to);
                moves.add(move);
            }
        }
    }

    private void nextMoveV(Coordinates from, int col, int row, ArrayList<Move> moves, Board board) {

        if (checkOnBoard(from, col, row)) {

            Coordinates front = new Coordinates(from.getRow(), from.getCol() + col);
            Piece piece = board.get(front);

            if (piece == null || piece.getColour() != getColour()) {
                Coordinates to = new Coordinates(from.getRow(), from.getCol() + col);
                Move move = new Move(from, to);
                moves.add(move);
            }
        }
    }
}
