package ceHeapSort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

/**
 * Tests the following three methods from class Mail:
 * randomMailCode, randomType, and compareTo
 * 
 * @author CSIS
 *
 */
class MailTest {
	private Mail mGround = new Mail(DeliveryType.GROUND, "ZRXTO");
	private Mail mOneDay = new Mail(DeliveryType.ONE_DAY, "AFBGE");
	
	
	// = = = test randomMailCode = = = 
	
	@Test
	void randomMailCode() {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < 100_000; i++) {
			char[] mailCode =  Mail.randomMailCode().toCharArray();
			// ensure the mail code is 5 characters long
			assertEquals(5, mailCode.length);
			
			for (int j = 0; j < 5; j++) {
				char c = mailCode[j];
				map.put(c, map.containsKey(c) ? (map.get(c) + 1) : 1);
			}
		}
		
		// ensure all letters A - Z were used but no other characters
		assertEquals(26, map.size());
		for (char c = 'A'; c <= 'Z'; c++) {
			assertTrue(map.containsKey(c));
		}
	}
		
	// = = = test randomType = = = 

	@Test
	void randomType() {
		HashMap<DeliveryType, Integer> map = new HashMap<>();
		for (int i = 0; i < 10_000; i++) {
			DeliveryType t =  Mail.randomType();
			map.put(t, map.containsKey(t) ? (map.get(t) + 1) : 1);
		}
		
		// ensure all delivery types were used
		assertEquals(DeliveryType.values().length, map.size());
	}
	
	// = = = test compareTo = = = 
	
	@Test
	void compareTo_smallerType() {
		assertTrue(mGround.compareTo(mOneDay) < 0);
	}
	
	@Test
	void compareTo_largerType() {
		assertTrue(mOneDay.compareTo(mGround) > 0);
	}
	
	@Test
	void compareTo_sameTypeSmallerMailCode() {
		Mail m = new Mail(DeliveryType.GROUND, "ZADBP");
		assertTrue(m.compareTo(mGround) < 0);
	}
	
	@Test
	void compareTo_sameTypeLargerMailCode() {
		Mail m = new Mail(DeliveryType.GROUND, "ZADBP");
		assertTrue(mGround.compareTo(m) > 0);
	}
	
	@Test
	void compareTo_sameTypeSameMailCode() {
		Mail m = new Mail(DeliveryType.GROUND, "ZRXTO");
		assertTrue(m.compareTo(mGround) == 0);
	}
}
