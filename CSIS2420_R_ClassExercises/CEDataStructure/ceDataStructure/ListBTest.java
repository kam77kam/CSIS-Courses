package ceDataStructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// = = = = =   Do Not Modify   = = = = = 
/**
 * Tests methods of class ListB.
 * 
 * @author CSIS
 */
public class ListBTest {

    private ListB list;  // empty list
    private ListB list3; // {10, 20, 30}

    @BeforeEach
    public void setUp() {
        list = new ListB();
        
        list3 = new ListB();
        list3.add(10);
        list3.add(20);
        list3.add(30);
    }
    
    // = = = lastElement = = = 
    @Test
    public void lastElement_EmptyList() {
        assertThrows(NoSuchElementException.class, () -> list.lastItem());
    }
    
    @Test
    public void lastElement_SingleElement() {
    	list.add(10);
    	assertEquals(10, list.lastItem());
    }

    @Test
    public void lastElement_multipleElements() {
    	assertEquals(30, list3.lastItem());
    }

    // = = = size = = = 
    @Test
    public void size_EmptyList() {
        assertEquals(0, list.size());
    }

    @Test
    public void size_MultipleElements() {
        assertEquals(3, list3.size());
    }

    // = = = isEmpty = = = 
    @Test
    public void isEmpty_EmptyList() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmpty_MultipleElements() {
        assertFalse(list3.isEmpty());;
    }  
    
    // = = = add = = = 
    @Test
    public void add_SingleElement() {
        list.add(5);
        assertEquals("5 ", list.toString());
        assertEquals(1, list.size());
    }

    @Test
    public void add_TwoElements() {
        list.add(5);
        list.add(10);
        assertEquals("5 10 ", list.toString());
        assertEquals(2, list.size());
    }
    
    @Test
    public void add_MultipleElements() {
    	list3.add(40);
        assertEquals("10 20 30 40 ", list3.toString());
        assertEquals(4, list3.size());
    }
    
    // = = = toString = = = 
    @Test
    public void toString_emptyList() {
        assertEquals("", list.toString());
    }
    
    @Test
    public void toString_SingleElement() {
        list.add(11);
        assertEquals("11 ", list.toString());
    }

    @Test
    public void toString_TwoElements() {
        list.add(11);
        list.add(22);
        assertEquals("11 22 ", list.toString());
    }
    
    @Test
    public void toString_ThreeElements() {
        list.add(11);
        list.add(22);
        list.add(33);
        assertEquals("11 22 33 ", list.toString());
    }
}