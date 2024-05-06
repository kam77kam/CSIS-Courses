package test;

import src.MonopolyBoard;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// The MonopolyGameTest class contains unit tests for the MonopolyBoard class.
class MonopolyGameTest {

    MonopolyBoard game = new MonopolyBoard(); // Instance of MonopolyBoard for testing

    // Check if the total number of spaces on the board is 40.
    @Test
    void getSpaceCount_Return40() {
        assertEquals(40, game.getPositionCount());
    }

    // Check if the name of the space at index 0 is "Go".
    @Test
    void getSpaceName_ReturnGo_Index0() {
        assertEquals("Go", game.getPositionName(0));
    }

    // Check if the name of the space at index 39 is "Boardwalk".
    @Test
    void getSpaceName_ReturnBoardwalk_Index39() {
        assertEquals("Boardwalk", game.getPositionName(39));
    }

    // Check if an IndexOutOfBoundsException is thrown when accessing a space with a negative index.
    @Test
    void getSpaceName_FromIndexNegative1_ReturnIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            game.getPositionName(-1);
        });
    }

    // Check if an IndexOutOfBoundsException is thrown when accessing a space with an index greater than the maximum.
    @Test
    void getSpaceName_FromIndex40_ReturnIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            game.getPositionName(40);
        });
    }

    // Check if the index of the space with name "Go" is 0.
    @Test
    void getSpaceIndexGo_ReturnIndex0() {
        assertEquals(0, game.getPositionIndex("Go"));
    }

    // Check if the index of the space with name "Boardwalk" is 39.
    @Test
    void getSpaceIndexBoardwalk_ReturnIndex39() {
        assertEquals(39, game.getPositionIndex("Boardwalk"));
    }

    // Check if the index of a space with a name that does not exist on the board is -1.
    @Test
    void getSpaceIndexHello_ReturnNegative1() {
        assertEquals(-1, game.getPositionIndex("Hello"));
    }

    // Check if the index of a space with a partial name that does not match any space on the board is -1.
    @Test
    void getSpaceIndexBo_ReturnNegative1() {
        assertEquals(-1, game.getPositionIndex("Bo"));
    }
}
