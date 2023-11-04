package a07;

import edu.princeton.cs.algs4.SeparateChainingHashST;

/**
 * This class contains methods for generating magic squares and matching 
 * them with their sums.
 * 
 * @author ..... // TODO list all people and resources who contributed code
 *               //      include chat gpt and websites if you used their code
 *
 */
public class Magic {
	
	/**
	 * Generates a magic square of the specified order.
	 * The order of a magic square specifies its size.
	 * E.g., a magic square of order 3 is a 3x3 square. 
	 * 
	 * The order needs to be a positive number. If the use passes a number
	 * that is not positive, an IllegalArgumentException is thrown.
	 * If the order is 2, an UnsupportedOperationException is thrown.
	 * 
	 * @param order size of the square
	 * @return a magic square of the specified order
	 */
	public static int[][] square(int order) {
        if (order <= 0) {
            throw new IllegalArgumentException("Order must be a positive number.");
        }

        if (order == 2) {
            throw new UnsupportedOperationException("There is no magic square of order 2.");
        }

        
        // If order is odd, use the Siamese method.
        if (order % 2 == 1) {
            return generateOddMagicSquare(order);
        } else if (order % 4 == 0) {
            return generateDoublyEvenMagicSquare(order);
        } else {
            // Order is singly even. As of my last update, this is a complex case and may not have been implemented yet.
            // Uncomment the line below to throw an exception until this method is implemented.
            // throw new UnsupportedOperationException("Singly even-ordered magic square generation is not supported yet.");
            return generateSinglyEvenMagicSquare(order); // If you implement this method.
        }
    }

    private static int[][] generateOddMagicSquare(int order) {
    	// Initialize the magic square
        int[][] magicSquare = new int[order][order];

        int number = 1;
        int row = 0;
        int column = order / 2;
        int curr_row;
        int curr_col;
        while (number <= order * order) {
            magicSquare[row][column] = number;
            number++;
            curr_row = row;
            curr_col = column;
            row -= 1;
            column += 1;

            if (row == -1) {
                row = order - 1;
            }
            if (column == order) {
                column = 0;
            }
            if (magicSquare[row][column] != 0) {
                row = curr_row + 1;
                column = curr_col;
                if (row == -1) {
                    row = order - 1;
                }
            }
        }
		return magicSquare;
    }

    private static int[][] generateDoublyEvenMagicSquare(int order) {
        // Your new implementation for doubly even order magic squares.
        int[][] magicSquare = new int[order][order];

        // Fill the magic square by incrementing numbers
        int i, j;
        for (i = 0; i < order; i++) {
            for (j = 0; j < order; j++) {
                magicSquare[i][j] = (order*i) + j + 1;
            }
        }

        // Change values of specific cells
        for (i = 0; i < order/4; i++) {
            for (j = 0; j < order/4; j++) {
                magicSquare[i][j] = (order*order + 1) - magicSquare[i][j];
            }
        }
        for (i = 0; i < order/4; i++) {
            for (j = 3*order/4; j < order; j++) {
                magicSquare[i][j] = (order*order + 1) - magicSquare[i][j];
            }
        }
        for (i = 3*order/4; i < order; i++) {
            for (j = 0; j < order/4; j++) {
                magicSquare[i][j] = (order*order + 1) - magicSquare[i][j];
            }
        }
        for (i = 3*order/4; i < order; i++) {
            for (j = 3*order/4; j < order; j++) {
                magicSquare[i][j] = (order*order + 1) - magicSquare[i][j];
            }
        }
        for (i = order/4; i < 3*order/4; i++) {
            for (j = order/4; j < 3*order/4; j++) {
                magicSquare[i][j] = (order*order + 1) - magicSquare[i][j];
            }
        }

        return magicSquare;
    }
    

    private static int[][] generateSinglyEvenMagicSquare(int order) {
      
    	
        int halfOrder = order / 2;
        int subGridSize = halfOrder * halfOrder;
        int[][] magicSquare = new int[order][order];
        int[][] subMagicSquare = generateOddMagicSquare(halfOrder);

        int[] adder = new int[order * order];
        for (int i = 0; i < order * order; i++) {
            adder[i] = (i / order / halfOrder * 2 + i / halfOrder % 2) * subGridSize;
        }

        // Create the magic square using a sub-magic square and adding a value to get the correct sums.
        for (int row = 0; row < order; row++) {
            for (int col = 0; col < order; col++) {
                int quadrant = (row / halfOrder) * 2 + (col / halfOrder);
                magicSquare[row][col] = subMagicSquare[row % halfOrder][col % halfOrder] + adder[quadrant];
            }
        }

        return magicSquare;
    }



	
	/**
	 * Creates a symbol table that matches integers from 1 to n inclusive 
	 * to magic squares of the same order.
	 * There is one exception: The number 2 is not added as a key because there is 
	 * no 2x2 magic square.
	 * 
	 * There can be multiple magic squares of the same size.
	 * There are, for example, multiple 3x3 magic squares. 
	 * The number 3 is matched to one of them. 
	 * 
	 * The argument n needs to be a positive number. If the use passes a number
	 * that is not positive, an IllegalArgumentException is thrown.
	 * If n equals 2, the method returns a sybmol table of size one. The only key
	 * included in this symbol table is 1.
	 * 
	 * @param n highest order in the symbol table
	 * @return the symbol table 
	 */
    public static SeparateChainingHashST<Integer, int[][]> mapOrderToSquare(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Argument must be a positive number.");
        }

        SeparateChainingHashST<Integer, int[][]> symbolTable = new SeparateChainingHashST<>();
        
        // Include key 1 with a 1x1 magic square
        symbolTable.put(1, new int[][]{{1}});
        
        // Start from 3 and include all orders up to n
        for (int i = 3; i <= n; i++) {
            if (i != 2) { // We still skip 2 because a 2x2 magic square does not exist.
                symbolTable.put(i, square(i));
            }
        }

        return symbolTable;
    }

	// New method to test square and mapOrderToSquare methods
	public static void testCode() {
	    SeparateChainingHashST<Integer, int[][]> st = mapOrderToSquare(6);
	    System.out.println("Number of keys in the symbol table: " + st.size());
	    
	    // Iterate over the keys in the symbol table
	    for (Integer key : st.keys()) {
	        if (key != 2) { // Since 2x2 magic squares do not exist
	            System.out.println(key + " x " + key + ":");
	            System.out.println("------");
	            printMagicSquare(st.get(key));
	            System.out.println();
	        }
	    }
	}

	// Helper method to print a magic square
	private static void printMagicSquare(int[][] square) {
	    for (int[] row : square) {
	        for (int val : row) {
	            System.out.printf("%3d ", val);
	        }
	        System.out.println();
	    }
	}

	// main method that now only calls testCode
	public static void main(String[] args) {
	    testCode();
	}

}