package test;

import src.Player;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerTest {

	Player player = new Player();
	
    @Test
    void getCurrentPosition_Return0() {
    	
        assertEquals(0, player.getCurrentPosition()); // Initial position should be 0 (Go)
    }
    
    @Test
    void getTotalMoves_Return0() {
    	
        assertEquals(0, player.getTotalMoves()); // Initial moves should be 0
    }
	
	@Test
    void move_UpdatePosition_Return1() {
		
        player.move(1);	// Move player by 1 space
        assertEquals(1, player.getCurrentPosition());
    }
	
	@Test
    void move_UpdateMoves_Return2() {
        
        player.move(7); // Move player by 7 spaces
        assertEquals(1, player.getTotalMoves());
        
        player.move(5); // Move player by 5 more spaces
        assertEquals(2, player.getTotalMoves());
    }
	
	@Test
    void move_40Positions_Mod40_Return0() {
        
        player.move(39); // Move player by 39 spaces
        assertEquals(39, player.getCurrentPosition());
        
        player.move(1); // Move player by 1 more spaces back to space Go
        assertEquals(0, player.getCurrentPosition());
    }
}
