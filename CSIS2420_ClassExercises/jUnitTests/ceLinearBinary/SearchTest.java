package ceLinearBinary;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SearchTest {
	
	@Test
	void linear_firstElement_returnIndex0() {
		int list[] = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75};
		int expectedIndex = list.length-list.length;
	    int result = ceLinearBinary.Search.linear(list, list[expectedIndex]);
		assertEquals(expectedIndex, result,"Result of first element: ");
	}
	@Test
	void linear_middleElement_returnIndexOfElement() {
		int list[] = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75};
		//expected stores the index of the list divided by 2
		int expectedIndex = list.length/2;
		int result = ceLinearBinary.Search.linear(list, list[expectedIndex]);
		assertEquals(expectedIndex,result, "Middle element found: ");
	}
	@Test
	void linear_lastElement_returnLastIndex() {
		int list[] = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75};
		int expectedIndex = list.length-1;
		int result = ceLinearBinary.Search.linear(list, list[expectedIndex]);
		assertEquals(expectedIndex,result, "Returned last element: ");
	}
	@Test
	void linear_elementNotInArray_returnMinusOne() {
		int list[] = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75};
		int key = 1;
		int result = ceLinearBinary.Search.linear(list, key);
		assertNotEquals(key, result,"Element Not Found ");
	}
	@Test
	void linear_emptyArray_returnMinusOne() {
		int list[] = {};
		int key = 1;
		int result = ceLinearBinary.Search.linear(list, key);
		assertNotEquals(key, result,"Array Not Found ");
		
	}
//	@Test
//	void binary_firstElement_returnIndex0() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void binary_middleElement_returnIndexOfElement() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void binary_lastElement_returnLastIndex() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void binary_elementNoInArray_returnminusOne() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void binary_emptyArray_returnMinusOne() {
//		fail("Not yet implemented");
//	}

}
