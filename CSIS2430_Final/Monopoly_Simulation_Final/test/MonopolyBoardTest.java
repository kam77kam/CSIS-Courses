package test;

// The {@code MonopolyBoardTest} class contains unit tests for the {@link MonopolyBoard} class.
import src.MonopolyBoard;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MonopolyBoardTest {

    MonopolyBoard board = new MonopolyBoard(); // Instance of MonopolyBoard for testing
//    List<String> spaces = new ArrayList<>(); // List of space names

    // Test case for checking the total number of spaces on the board.
    @Test
    void getSpaceCount_Return40() {
        assertEquals(40, board.getPositionCount());
    }

    // Test case for checking the name of the space at index 0.
    @Test
    void getSpaceName_ReturnGo_Index0() {
        assertEquals("Go", board.getPositionName(0));
    }

    // Test case for checking the name of the space at index 39.
    @Test
    void getSpaceName_ReturnBoardwalk_Index39() {
        assertEquals("Boardwalk", board.getPositionName(39));
    }

    // Test case for checking if an IndexOutOfBoundsException is thrown when accessing a space with a negative index.
    @Test
    void getSpaceName_FromIndexNegative1_ReturnIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            board.getPositionName(-1);
        });
    }

    // Test case for checking if an IndexOutOfBoundsException is thrown when accessing a space with an index greater than the maximum
    @Test
    void getSpaceName_FromIndex40_ReturnIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            board.getPositionName(40);
        });
    }

    //Test case for checking the index of the space with name "Go"
    @Test
    void getSpaceIndexGo_ReturnIndex0() {
        assertEquals(0, board.getPositionIndex("Go"));
    }

    //Test case for checking the index of the space with name "Boardwalk"
    @Test
    void getSpaceIndexBoardwalk_ReturnIndex39() {
        assertEquals(39, board.getPositionIndex("Boardwalk"));
    }

    // Test case for checking the index of a space with a name that does not exist on the board*/
    @Test
    void getSpaceIndexHello_ReturnNegative1() {
        assertEquals(-1, board.getPositionIndex("Hello"));
    }

    // Test case for checking the index of a space with a partial name that does not match any space on the board
    @Test
    void getSpaceIndexBo_ReturnNegative1() {
        assertEquals(-1, board.getPositionIndex("Bo"));
    }
    
//	@Test
//	void getProperties() {
//		//Properties Added Only
//		//spaces.add("Go");
//		spaces.add("Mediterranean Avenue");
//		//spaces.add("Community Chest");
//		spaces.add("Baltic Avenue");
//		//spaces.add("Income Tax");
//		//spaces.add("Reading Railroad");
//		spaces.add("Oriental Avenue");
//		spaces.add("Chance");
//		spaces.add("Vermont Avenue");
//		spaces.add("Connecticut Avenue");
//		//spaces.add("Jail / Just Visiting");
//		spaces.add("St. Charles Place");
//		//spaces.add("Electric Company");
//		spaces.add("States Avenue");
//		spaces.add("Virginia Avenue");
//		//spaces.add("Pennsylvania Railroad");
//		spaces.add("St. James Place");
//		//spaces.add("Community Chest");
//		spaces.add("Tennessee Avenue");
//		spaces.add("New York Avenue");
//		//spaces.add("Free Parking");
//		spaces.add("Kentucky Avenue");
//		//spaces.add("Chance");
//		spaces.add("Indiana Avenue");
//		spaces.add("Illinois Avenue");
//		//spaces.add("B. & O. Railroad");
//		spaces.add("Atlantic Avenue");
//		spaces.add("Ventnor Avenue");
//		//spaces.add("Water Works");
//		spaces.add("Marvin Gardens");
//		//spaces.add("Go to Jail");
//		spaces.add("Pacific Avenue");
//		spaces.add("North Carolina Avenue");
//		//spaces.add("Community Chest");
//		spaces.add("Pennsylvania Avenue");
//		//spaces.add("Short Line");
//		//spaces.add("Chance");
//		spaces.add("Park Place");
//		spaces.add("Luxury Tax");
//		spaces.add("Boardwalk");
//		assertTrue(spaces.containsAll(board.getProperties()));
//
//	}
}
