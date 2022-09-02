package lab;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kamdon Bird
 *
 */
public class MountainApp {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Mountain> mountainList = new LinkedList();
		Mountain mountain = null;
		try (Scanner reader = new Scanner(MountainApp.class.getResourceAsStream("Mountains.csv"))) {
			while (reader.hasNext()) {
				mountain = getMountain(reader.nextLine());
				if (mountain != null) {
					mountainList.add(mountain);
				}
			}

		}catch(NumberFormatException | IndexOutOfBoundsException ex) {
			System.err.println(ex);
		}
		for (Mountain m : mountainList) {
			System.out.println(m);
		}
	}

	/**
	 * @param nextLine
	 * @return
	 */
	private static Mountain getMountain(String nextLine) {
		String[] line = nextLine.split(",");
		try {
			Mountain m = new Mountain(line[0], Integer.parseInt(line[1]), Boolean.parseBoolean(line[2]));
			return m;
		}catch(NumberFormatException | IndexOutOfBoundsException ex) {
			System.err.println(nextLine + "  .. could not be read in as a mountain");
		}
		return null;
	}
}
