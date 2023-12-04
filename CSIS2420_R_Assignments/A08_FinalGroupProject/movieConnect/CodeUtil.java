package movieConnect;

import java.util.ArrayList;
import java.util.Random;
/**
 * Utility class providing methods for code generation.
 * This class is specifically designed to generate a unique string code 
 * consisting of random letters (both lowercase and uppercase) and numbers.
 * 
 * @author Kamdon Bird, Haiyang Liu
 * @version 1.0
 */
public class CodeUtil {

	/**
     * Generates a unique code consisting of random letters followed by a single digit.
     * The method first creates a collection of all lowercase and uppercase letters, 
     * then selects four random letters from this collection. After appending a random 
     * digit at the end, it swaps the digit with a character at a random position in the code.
     *
     * @return A string representing the randomly generated code. 
     *         The code is a combination of four letters (a mix of lowercase and uppercase) 
     *         followed by a digit, with one character swap operation performed.
     */
    public static String getCode(){
        //Create a collection
        ArrayList<Character> list = new ArrayList<>();//52  Index range：0 ~ 51
        //Add the letters a-z A-Z
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));//a - z
            list.add((char)('A' + i));//A - Z
        }

        //Generates 4 random letters
        String result = "";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            //Get random index
            int randomIndex = r.nextInt(list.size());
            char c = list.get(randomIndex);
            result = result + c;
        }

        //Concatenate the numbers 0 to 9 at the end
        int number = r.nextInt(10);
        //Concatenate random numbers to the end of result
        result = result + number;
        //Turns a string into an array of characters
        char[] chars = result.toCharArray();//[A,B,C,D,5]
        //Generates a random index in the character array
        int index = r.nextInt(chars.length);
        //Take the number on the 4 index and swap it with the number on the random index
        char temp = chars[4];
        chars[4] = chars[index];
        chars[index] = temp;
        //Turn the character array back into a string
        String code = new String(chars);
        return code;
    }
}
