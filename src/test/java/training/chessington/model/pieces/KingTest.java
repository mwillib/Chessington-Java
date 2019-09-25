package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KingTest {


    @Test
    public void whiteKingCanMoveUpOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
    }

    @Test
    public void blackKingCanMoveDownOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
    }

    @Test
    public void blackKingCanMoveDiagonallyOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
    }

    @Test
    public void whiteKingCanMoveDiagonallyOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(7, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
    }

    @Test
    public void whiteKingCannotMoveOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0, 7);
        board.placePiece(coords, king);
        List<Move> expectedMoves = new ArrayList<>();
        expectedMoves.add(new Move(coords, new Coordinates(0, 6)));
        expectedMoves.add(new Move(coords, new Coordinates(1, 6)));
        expectedMoves.add(new Move(coords, new Coordinates(1, 7)));

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        for (Move move : expectedMoves){
            assertThat(moves).contains(move);
        }
        assertThat(moves.size()).isEqualTo(expectedMoves.size());
    }

    @Test
    public void blackKingCannotMoveAtBottomOfBoard() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 7);
        board.placePiece(coords, king);
        List<Move> expectedMoves = new ArrayList<>();
        expectedMoves.add(new Move(coords, new Coordinates(0, 6)));
        expectedMoves.add(new Move(coords, new Coordinates(1, 6)));
        expectedMoves.add(new Move(coords, new Coordinates(1, 7)));

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        for (Move move : expectedMoves){
            assertThat(moves).contains(move);
        }
        assertThat(moves.size()).isEqualTo(expectedMoves.size());
    }
}