package a01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//= = = =   Do Not Modify This Class = = = =
/**
 * Tests the methods specified in A01Version1.
 * 
 * @author CSIS
 */
class A01_Version1Test {

	// = = = everyOther
	
	@Test
	public void everyOther_evenLength() {
		int[] numbers = { 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 };
		int[] results = A01Version1.everyOther(numbers);
		assertArrayEquals(new int[] { 10, 20, 30, 40, 50 }, results);
	}

	@Test
	public void everyOther_oddLength() {
		int[] numbers = { 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60 };
		int[] results = A01Version1.everyOther(numbers);
		assertArrayEquals(new int[] { 10, 20, 30, 40, 50, 60 }, results);
	}

	@Test
	public void everyOther_TwoElements() {
		int[] numbers = { 10, 15 };
		assertArrayEquals(new int[] { 10 }, A01Version1.everyOther(numbers));
	}

	@Test
	public void everyOther_OneElement() {
		int[] numbers = { 10 };
		assertArrayEquals(new int[] { 10 }, A01Version1.everyOther(numbers));
	}

	@Test
	public void everyOther_emptyArray() {
		int[] numbers = {};
		assertArrayEquals(new int[] {}, A01Version1.everyOther(numbers));
	}

	@Test
	public void everyOther_invalidInput_null() {
		assertThrows(NullPointerException.class, () -> {
			A01Version1.everyOther(null);
		});
	}

	// = = = isPalindrome

	@Test
	public void isPalindrome_oneElementPalindrome() {
		String[] array = { "hello" };
		assertTrue(A01Version1.isPalindrome(array));
	}

	@Test
	public void isPalindrome_oddNumberOfElements() {
		Character[] array = { 'K', 'A', 'Y', 'A', 'K' };
		assertTrue(A01Version1.isPalindrome(array));
	}

	@Test
	public void isPalindrome_evenNumberOfElements() {
		Character[] array = { 'd', 'e', 'e', 'd'};
		assertTrue(A01Version1.isPalindrome(array));
	}
	
	@Test
	public void isPalindrome_long() {
		Character[] array = { 't', 'a', 't', 't', 'a', 'r', 'r', 'a', 't', 't', 'a', 't' };
		assertTrue(A01Version1.isPalindrome(array));
	}

	@Test
	public void isPalindrome_NoPalindromen_MiddleElementsDiffer() {
		Character[] array = { 't', 'a', 't', 't', 'a', 'r', 'R', 'a', 't', 't', 'a', 't' };
		assertFalse(A01Version1.isPalindrome(array));
	}
	
	@Test
	public void isPalindrome_NoPalindrome_FirstAndLastElementsDiffer() {
		Character[] array = { 'd', 'e', 'e', 'r' };
		assertFalse(A01Version1.isPalindrome(array));
	}

	@Test
	public void isPalindrome_invalidInput_emptyArray() {
		assertThrows(IllegalArgumentException.class, () -> {
			A01Version1.isPalindrome(new Integer[0]); });
	}

	@Test
	public void isPalindrome_invalidInput_null() {
		assertThrows(NullPointerException.class, () -> {
			A01Version1.isPalindrome(null); });
	}

	// = = =   findMaximumAbsoluteValue   = = =
	
	@Test
    void findMaximumAbsoluteValue_positiveMaxValue() {
        int[][] a = {
            {3, -5, 2},
            {9, -4, 1},
            {7, 8, -6}
        };
        int max = A01Version1.findMaximumAbsoluteValue(a);
        assertEquals(9, max);
	}
	
	@Test
    void findMaximumAbsoluteValue_negativeMaxValue() {
        int[][] a = {
            {-5, 0, -2, 3},
            {8, -4, -1, 5},
            {-9, 6, -3, 1},
            {-7, -8, -6, 0}
        };
        int max = A01Version1.findMaximumAbsoluteValue(a);
        assertEquals(9, max);
	}
	
	@Test
    void findMaximumAbsoluteValue_allNumbersEqual() {
        int[][] a = {
            {7, 7},
            {7, 7}
        };
        int max = A01Version1.findMaximumAbsoluteValue(a);
        assertEquals(7, max);
	}
	
	@Test
    void findMaximumAbsoluteValue_allAbsoluteValuesEqual() {
        int[][] a = {
            {2, -2, 2, 2, 2},
            {2, 2, 2, -2, 2},
            {-2, 2, 2, 2, 2},
            {2, 2, -2, 2, 2},
            {2, 2, 2, 2, -2}
        };
        int max = A01Version1.findMaximumAbsoluteValue(a);
        assertEquals(2, max);
	}

	@Test
    void findMaximumAbsoluteValue_singleElementArray() {
        int[][] a = {{7}}; // Array with one element
        int max = A01Version1.findMaximumAbsoluteValue(a);
        assertEquals(7, max);
    }


	@Test
    void findMaximumAbsoluteValue_emptyArray() {
        int[][] a = {}; // Empty array
        int max = A01Version1.findMaximumAbsoluteValue(a);
        assertEquals(0, max);
	}
	
    
    // = = = diagonalSum = = = 
     
	 @Test
	 void diagonalSum_singleElementMatrix() {
        int[][] matrix = {
            {1}
        };
        assertEquals(1, A01Version1.diagonalSum(matrix));
    }
    
    @Test
    void diagonalSum_2x2Matrix() {
        int[][] matrix = {
            {1, 2},
            {3, 4}
        };
        assertEquals(5, A01Version1.diagonalSum(matrix));
    }
    
    @Test
    void diagonalSum_3x3Matrix() {
        int[][] matrix = {
            {1, 2, 0},
            {4, 0, 6},
            {0, 9, 8}
        };
        assertEquals(0, A01Version1.diagonalSum(matrix));
    }
    
    @Test
    void diagonalSum_largerMatrix() {
        int[][] matrix = {
            {2, 0, 0, 4, 9, -3},
            {0, 5, -2, 0, 1 ,0},
            {-4, 0, 3, 6, 3, 7}, 
            {5, 7, 2, 0, -9 ,0},
            {6, 3, 7, -1, 6, 2}, 
            {8, -5, 2, 6, 7, 1}
        };
        assertEquals(17, A01Version1.diagonalSum(matrix));
    }
    
    @Test
    void diagonalSum_invalidInput_emptyMatrix() {
        int[][] matrix = {}; 
        assertThrows(IllegalArgumentException.class, () -> {
        	A01Version1.diagonalSum(matrix);
        });
    }
    
    @Test
    void diagonalSum_invalidInput_matrixNotSquare() {
        int[][] matrix = {
                {2, 0, 0, 4},
                {0, 5, -2, 0, 1},
                {6, 3, 0}
            };
        assertThrows(IllegalArgumentException.class, () -> {
        	A01Version1.diagonalSum(matrix);
        });
    }
    
    @Test
    void diagonalSum_invalidInput_null() {
        assertThrows(NullPointerException.class, () -> {
        	A01Version1.diagonalSum(null);
        });
    }
}
