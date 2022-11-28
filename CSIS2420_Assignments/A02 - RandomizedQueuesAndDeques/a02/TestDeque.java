/*
 * Created by: Kamdon Bird
 * Created date: Nov 27, 2022
 * Course class: CSIS 2420
 * Assignment: A02 - RandomizedQueuesAndDeques
 */
package a02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestDeque {
	Deque<String> myNameArray = new Deque<String>();
	
	@Test
	void iteratorHasNextFalse() {
		assertEquals(false, myNameArray.iterator().hasNext());
	}
	@Test
	void iteratorHasNextTrue() {
		myNameArray.addFirst("Kamdon");
		assertEquals(true, myNameArray.iterator().hasNext());
	}
	@Test
	void iteratorNextExceptionCase() {
		assertThrows(java.lang.UnsupportedOperationException.class, () -> myNameArray.iterator().next());
	}
	@Test
	void iteratorNext() {
		myNameArray.addFirst("Kamdon");
		assertEquals("Kamdon", myNameArray.iterator().next());
	}
	@Test
	void iteratorRemove() {
		assertThrows(java.lang.UnsupportedOperationException.class, () -> myNameArray.iterator().remove());
	}
	@Test
	void addFirst() {
		myNameArray.addFirst("Bird");
		myNameArray.addFirst("Troy");
		myNameArray.addFirst("Kamdon");
		assertEquals("Kamdon", myNameArray.iterator().next());
	}
	@Test
	void addLast() {
		myNameArray.addLast("Kamdon");
		myNameArray.addLast("Troy");
		myNameArray.addLast("Bird");
		assertEquals("Kamdon", myNameArray.iterator().next());
	}
	@Test
	void removeFirst() {
		myNameArray.addFirst("Bird");
		myNameArray.addFirst("Troy");
		myNameArray.addFirst("Kamdon");
		myNameArray.removeFirst();
		assertEquals("Troy", myNameArray.iterator().next());
		
	}
	@Test 
	void removeLast(){
		myNameArray.addLast("Kamdon");
		myNameArray.addLast("Troy");
		myNameArray.addLast("Bird");
		assertEquals("Bird", myNameArray.removeLast());
	}
	@Test
	void IsEmpty(){
		assertEquals(true, myNameArray.isEmpty());
	}
	@Test
	void IsNotEmpty(){
		myNameArray.addFirst("Kamdon");
		assertEquals(false, myNameArray.isEmpty());
	}
	@Test
	void DequeSize() {
		myNameArray.addFirst("Kamdon");
		assertEquals(1,myNameArray.size());
	}
}
