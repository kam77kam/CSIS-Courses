package lab;

import javax.swing.JFrame;

/**
 * @author Kamdon Bird
 *
 */
@SuppressWarnings("serial")
public class BuildingApp extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BuildingApp().run();
	}
	
	/**
	 * 
	 */
	public void run() {
		setBounds(100, 10, 400, 500);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    add(new Building());
	    setVisible(true); //always needed to see window
	}

}
