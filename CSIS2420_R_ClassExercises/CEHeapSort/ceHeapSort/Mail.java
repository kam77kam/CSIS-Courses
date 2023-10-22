package ceHeapSort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Represents a mail item with a specific delivery type and mail code. The class
 * implements the Comparable interface to allow comparison based on the delivery
 * type and mail code. Re
 * 
 * @author CSIS + Kamdon Bird
 */
public class Mail implements Comparable<Mail> {

	private DeliveryType type;
	private String mailCode;

	/**
	 * Constructs a Mail object with the specified delivery type and mail code.
	 *
	 * @param type     the delivery type of the mail
	 * @param mailCode the unique code associated with the mail
	 */
	public Mail(DeliveryType type, String mailCode) {
		this.type = type;
		this.mailCode = mailCode;
	}

	/**
	 * Constructs a Mail object with a randomly selected delivery type and a random
	 * five-letter mail code.
	 * 
	 */
	public Mail() {
		this.type = randomType();
		this.mailCode = randomMailCode();
	}

	/**
	 * Creates a random five-letter code consisting of all upper-case letters. E.g.,
	 * PXASV
	 * 
	 * @return a random 5-letter code
	 */
	static String randomMailCode() {
		StringBuilder randomMailString = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			randomMailString.append((char) ('A' + StdRandom.uniformInt(0, 27)));
		}
		return randomMailString.toString();

	}

	/**
	 * Returns a randomly selected delivery type.
	 *
	 * @return a randomly selected DeliveryType
	 */
	static DeliveryType randomType() {
		return DeliveryType.values()[StdRandom.uniformInt(DeliveryType.values().length)];
	}

	/**
	 * Returns a string representation of the Mail object formatted as
	 * "mailCode(type)"
	 *
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return mailCode + "(" + type + ")";
	}

	/**
	 * Compares two Mail objects based on the delivery type. If the types are the
	 * same, the Mail objects are compared by mail code.
	 *
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Mail other) {
		if (other.type == null ) {
			throw new NullPointerException("Cant compare a null object");
		} else if (other.type == this.type) {
			return other.mailCode.compareTo(this.mailCode);
		} else if (other.type == DeliveryType.ONE_DAY) {
			return 1;
		} else if (other.type == DeliveryType.TWO_DAY) {
			if (this.type == DeliveryType.ONE_DAY) {
				return -1;
			} else
				return 1;
		} else if (other.type == DeliveryType.PRIORITY) {
			if (this.type == DeliveryType.ONE_DAY || this.type == DeliveryType.ONE_DAY) {
				return -1;
			} else
				return 1;
		} else if (other.type == DeliveryType.AIR) {
			if (this.type != DeliveryType.GROUND) {
				return 1;
			} else
				return -1;
		} else
			return -1;
	}

}
