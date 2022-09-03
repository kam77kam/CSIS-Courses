package ceLinearBinary;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SearchTest {

	@Test
	void linear_firstElement_returnIndex0() {
		int list[] = {5,10,15,20,25,30};
	    int key = 10;
	    int result = ceLinearBinary.Search.linear(list, key);
		assertEquals(1, result);
	}
//	@Test
//	void linear_middleElement_returnIndexOfElement() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void linear_lastElement_returnLastIndex() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void linear_elementNotInArray_returnMinusOne() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void linear_emptyArray_returnMinusOne() {
//		fail("Not yet implemented");
//	}
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
