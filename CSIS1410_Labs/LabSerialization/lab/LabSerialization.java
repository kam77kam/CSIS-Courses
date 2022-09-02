package lab;

import java.awt.Color;
import java.io.*;

public class LabSerialization {
	public static void main(String[] args) {
		ListVsSetDemo demo = new ListVsSetDemo(new ColoredSquare(4, Color.RED), new ColoredSquare(6, Color.BLUE),
				new ColoredSquare(4, Color.RED), new ColoredSquare(8, Color.YELLOW));
		testDemo(demo);

		String filename = "Demo.ser";
		serialize(demo, filename);
		ListVsSetDemo demo2 = (ListVsSetDemo)deSerialize(filename);
		testDemo(demo2);
	};

	private static void testDemo(ListVsSetDemo demo) {
		System.out.println("List:");
		System.out.println(demo.getListElements());
		System.out.println("Set:");
		System.out.println(demo.getSetElements());
	}

	private static void serialize(ListVsSetDemo demo, String filename) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(filename)))) {
			out.writeObject(demo);
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println();
		}
	}

	/**
	 * @param demo
	 * @param filename
	 * @return
	 */
	private static ListVsSetDemo deSerialize(String filename) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(filename)))) {
			ListVsSetDemo temp = (ListVsSetDemo)in.readObject();
			return temp;
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("File not found");
		} catch (ClassNotFoundException e) {
			
		}
		return null;
		
	}
}
