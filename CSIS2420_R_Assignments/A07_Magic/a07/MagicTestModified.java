package a07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.StdOut;

public class MagicTestModified {

	@Test
	public void square_negativeOrder() {
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> {PassedAllUnitTestsMagic.square(-1);});
	}
	@Test
	public void square_2() {
		Assertions.assertThrows(UnsupportedOperationException.class, 
				() -> {PassedAllUnitTestsMagic.square(2);});
	}
    @Test
    public void square_1() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(1)));
    }   
    @Test
    public void square_3() {
    	int order = 3;
    	int[][] square = PassedAllUnitTestsMagic.square(order);
        printSquare(order, square);
        Assertions.assertTrue(isMagicSquare(square));
    }

    @Test
    public void square_4() {
    	int order = 4;
    	int[][] square = PassedAllUnitTestsMagic.square(order);
        printSquare(order, square);
        Assertions.assertTrue(isMagicSquare(square));
    }
    @Test
    public void square_5() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(5)));
    }
    @Test
    public void square_6() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(6)));
    }
    @Test
    public void square_7() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(7)));
    }
    @Test
    public void square_8() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(8)));
    }
    @Test
    public void square_9() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(9)));
    }
    @Test
    public void square_10() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(10)));
    }
    @Test
    public void square_11() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(11)));
    }
    @Test
    public void square_12() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(12)));
    }
    @Test
    public void square_13() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(13)));
    }
    @Test
    public void square_14() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(14)));
    }
    @Test
    public void square_15() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(15)));
    }    
    @Test
    public void square_16() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(16)));
    }
    @Test
    public void square_17() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(17)));
    }    
    @Test
    public void square_18() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(18)));
    }
    @Test
    public void square_19() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(19)));
    }    
    @Test
    public void square_20() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(20)));
    }
    @Test
    public void square_21() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(21)));
    }    
    @Test
    public void square_22() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(22)));
    } 
    @Test
    public void square_23() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(23)));
    }
    @Test
    public void square_24() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(24)));
    }
    @Test
    public void square_25() {
        Assertions.assertTrue(isMagicSquare(PassedAllUnitTestsMagic.square(25)));
    }    

    private boolean isMagicSquare(int[][] square) {
        int n = square.length;

        // Calculate the sum of the first row
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += square[0][i];
        }

        // Check each row
        for (int i = 1; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += square[i][j];
            }
            if (rowSum != sum) {
                return false;
            }
        }

        // Check each column
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += square[i][j];
            }
            if (colSum != sum) {
                return false;
            }
        }

        // Check diagonal from top-left to bottom-right
        int diagonalSum = 0;
        for (int i = 0; i < n; i++) {
            diagonalSum += square[i][i];
        }
        if (diagonalSum != sum) {
            return false;
        }

        // Check diagonal from bottom-left to top-right
        diagonalSum = 0;
        for (int i = 0; i < n; i++) {
            diagonalSum += square[i][n - 1 - i];
        }
        if (diagonalSum != sum) {
            return false;
        }

        // If all checks passed, it's a magic square
        return true;
    }
    
	private void printSquare(int order, int[][] square) {
		StdOut.println(order + " x " + order + ":");
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                StdOut.printf("%4d", square[i][j]);
            }
            StdOut.println();
        }
        StdOut.println();
	}
}