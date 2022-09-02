package lab;

public class DemoWrapperClass {
	public String minMax() {
		return String.format(
				"Byte:\n" + 
				"Min: %d\n" + 
				"Max: %d\n\n" + 
				"Short:\n" + 
				"Min: %,d\n" + 
				"Max: %,d\n\n" + 
				"Integer:\n" + 
				"Min: %,d\n" + 
				"Max: %,d\n\n" + 
				"Long:\n" + 
				"Min: %,d\n" + 
				"Max: %,d\n",
				Byte.MIN_VALUE,
				Byte.MAX_VALUE,
				Short.MIN_VALUE,
				Short.MAX_VALUE,
				Integer.MIN_VALUE,
				Integer.MAX_VALUE,
				Long.MIN_VALUE,
				Long.MAX_VALUE
				);
	}
	public String toBinary (int number) {
		return String.format(
				"Binary: %s\n" + 
				"Octal : %s\n" + 
				"Hex   : %s\n",
				Integer.toBinaryString(number),
				Integer.toOctalString(number),
				Integer.toHexString(number)
				);
	}
	public String charProperties(char c) {
		return String.format(
				"White space: %b\n" + 
				"Digit: %b\n" + 
				"Letter: %s\n",
				Character.isWhitespace(c),
				Character.isDigit(c),
				Character.isLetter(c) ? c + "|" + (Character.isUpperCase(c) 
						? Character.toLowerCase(c) : Character.toUpperCase(c))
						: false
				);
	}
}
