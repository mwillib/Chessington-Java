package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KnightTest {

    @Test
    public void whiteKnightCannotMoveOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, knight);
        List<Move> expectedMoves = new ArrayList<>();
        expectedMoves.add(new Move(coords, new Coordinates(1, 2)));
        expectedMoves.add(new Move(coords, new Coordinates(2, 1)));

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        for (Move move : expectedMoves){
            assertThat(moves).contains(move);
        }
        assertThat(moves.size()).isEqualTo(expectedMoves.size());
    }

    @Test
    public void blackKnightCannotMoveAtBottomOfBoard() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, knight);
        List<Move> expectedMoves = new ArrayList<>();
        expectedMoves.add(new Move(coords, new Coordinates(1, 2)));
        expectedMoves.add(new Move(coords, new Coordinates(2, 1)));

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        for (Move move : expectedMoves){
            assertThat(moves).contains(move);
        }
        assertThat(moves.size()).isEqualTo(expectedMoves.size());
    }

    @Test
    public void checkIfKnightMovesInLShape (){
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(2, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 2)));

    }

    @Test
    public void knightCantTakesOwnPiece(){
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.BLACK);
        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 0);
        Coordinates coords1 = new Coordinates(2,1);
        board.placePiece(coords, knight);
        board.placePiece(coords, pawn);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 2)));
    }
}
