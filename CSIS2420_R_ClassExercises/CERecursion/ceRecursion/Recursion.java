package ceRecursion;

public class Recursion {
	/**
	 * The first number is the seed provided by the client. Calculate the next
	 * number the following way: If the number is even, the next number is half the
	 * number otherwise, the next number is three times the number + 1 Repeat 2
	 * until you reach 1
	 * 
	 * @author Kamdon
	 * @param seed
	 */
	public static void hailstorm(int seed) {
		if (seed < 0) {
			throw new IllegalArgumentException("The seed can't be a negative number or zero");
		} else if (seed == 1) {
			System.out.print(seed + " ");
			seed = 1;
		} else if (seed % 2 == 0) {
			System.out.print(seed + " ");
			hailstorm(seed = seed / 2);
		} else {
			System.out.print(seed + " ");
			hailstorm(seed = (seed * 3) + 1);
		}

	}

//~~~~~~~~~~~~~~~~~~TEST CLIENT~~~~~~~~~~~~~~~~//
	public static void main(String[] args) {
		hailstorm(3);
		System.out.println();
		hailstorm(16);
		System.out.println();
		hailstorm(17);
		System.out.println();
		hailstorm(24);
	}

}
