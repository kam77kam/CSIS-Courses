package ceDataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// = = = = =   Do Not Modify   = = = = = 
/**
 * Tests methods of class ListA.
 * 
 * @author CSIS
 */
public class ListATest {

    private ListA list;  // empty list
    private ListA list3; // {10, 20, 30}

    @BeforeEach
    public void setUp() {
        list = new ListA(3);
        
        list3 = new ListA(5);
        list3.add(10);
        list3.add(20);
        list3.add(30);
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
        assertEquals("ListA [items=[5, 0, 0], n=1]", list.toString());
        assertEquals(1, list.size());
    }

    @Test
    public void add_TwoElements() {
        list.add(5);
        list.add(10);
        assertEquals("ListA [items=[5, 10, 0], n=2]", list.toString());
        assertEquals(2, list.size());
    }
    
    @Test
    public void add_MultipleElements() {
    	list3.add(40);
        assertEquals("ListA [items=[10, 20, 30, 40, 0], n=4]", list3.toString());
        assertEquals(4, list3.size());
    }
    
    @Test
    public void add_fullList() {
       	list3.add(40);
       	list3.add(50);
        assertThrows(IllegalStateException.class, () -> {
        	list3.add(60);
        });
    }
    
    // = = = toString = = = 
    @Test
    public void toString_emptyList() {
        assertEquals("ListA [items=[0, 0, 0], n=0]", list.toString());
    }
    
    @Test
    public void toString_SingleElement() {
        list.add(11);
        assertEquals("ListA [items=[11, 0, 0], n=1]", list.toString());
    }

    @Test
    public void toString_TwoElements() {
        list.add(11);
        list.add(22);
        assertEquals("ListA [items=[11, 22, 0], n=2]", list.toString());
    }
    
    @Test
    public void toString_ThreeElements() {
        list.add(11);
        list.add(22);
        list.add(33);
        assertEquals("ListA [items=[11, 22, 33], n=3]", list.toString());
    }
}