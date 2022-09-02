/*Assignment: package changingimages;
Program: ChangingImages
Created: Mar 26, 2019
Author: Kamdon Bird
 */
package changingimages;

import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * @author Kamdon Bird
 *
 */
public class ChangingImages extends JFrame {

	//Fields
	/**
	 * I've made 4 seasons for my building
	 */
	JPanel panel;
	/**
	 * I've made 4 seasons for my building
	 */
	private JPanel contentPane;
	/**
	 * Images to change to spring selection
	 */
	ImageIcon[] spring = { new ImageIcon(ChangingImages.class.getResource("mapple.png")),
			new ImageIcon(ChangingImages.class.getResource("red.png")),
			new ImageIcon(ChangingImages.class.getResource("autumn.png")) };

	/**
	 * images to change to summer selection
	 */
	ImageIcon[] summer = { new ImageIcon(ChangingImages.class.getResource("dirtbike.png")),
			new ImageIcon(ChangingImages.class.getResource("sun.png")),
			new ImageIcon(ChangingImages.class.getResource("beach.png")) };

	/**
	 * Images to change to fall selection
	 */
	ImageIcon[] fall = { new ImageIcon(ChangingImages.class.getResource("fall.png")),
			new ImageIcon(ChangingImages.class.getResource("wreath.png")),
			new ImageIcon(ChangingImages.class.getResource("pumpkin.png")) };

	/**
	 * Images to change the winter selection
	 */
	ImageIcon[] winter = { new ImageIcon(ChangingImages.class.getResource("snowflake.png")),
			new ImageIcon(ChangingImages.class.getResource("tree.png")),
			new ImageIcon(ChangingImages.class.getResource("snowman.png")) };

	/**
	 * Images for submit button
	 */
	ImageIcon[] building = { new ImageIcon(ChangingImages.class.getResource("church.png")),
			new ImageIcon(ChangingImages.class.getResource("school.jpg")),
			new ImageIcon(ChangingImages.class.getResource("house.png")) };

	private static int buildingCounter = 0;
	private static int springCounter = 0;
	private static int summerCounter = 0;
	private static int fallCounter = 0;
	private static int winterCounter = 0;
	
	//Methods
	/**
	 * Create the frame.
	 */
	public ChangingImages() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));

		JCheckBox chckbxSpring = new JCheckBox("Spring");
		panel_1.add(chckbxSpring);
		chckbxSpring.setHorizontalAlignment(SwingConstants.LEFT);

		JCheckBox chckbxSummer = new JCheckBox("Summer");
		panel_1.add(chckbxSummer);
		chckbxSummer.setHorizontalAlignment(SwingConstants.LEFT);

		JCheckBox chckbxFall = new JCheckBox("Fall");
		panel_1.add(chckbxFall);
		chckbxFall.setHorizontalAlignment(SwingConstants.LEFT);

		JCheckBox chckbxWinter = new JCheckBox("Winter");
		panel_1.add(chckbxWinter);
		chckbxWinter.setHorizontalAlignment(SwingConstants.LEFT);

		JButton btnSubmit = new JButton("Submit");
		panel_1.add(btnSubmit);

		panel = new nested();

		contentPane.add(panel, BorderLayout.CENTER);
		btnSubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (chckbxSpring.isSelected()) {
					springCounter++;
					springCounter %= 3;
				}
				if (chckbxSummer.isSelected()) {
					summerCounter++;
					summerCounter %= 3;
				}
				if (chckbxFall.isSelected()) {
					fallCounter++;
					fallCounter %= 3;
				}
				if (chckbxWinter.isSelected()) {
					winterCounter++;
					winterCounter %= 3;
				}
				if (!chckbxSpring.isSelected() && !chckbxWinter.isSelected() && !chckbxSummer.isSelected()
						&& !chckbxFall.isSelected()) {
					buildingCounter++;
					buildingCounter %= 3;
				}
				panel = new nested();
				repaint();
			}
		});
	}
	
	//Override Methods
	public class nested extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			building[buildingCounter].paintIcon(this, g, 50, 0);
			fall[fallCounter].paintIcon(this, g, 100, 700);
			spring[springCounter].paintIcon(this, g, 250, 700);
			winter[winterCounter].paintIcon(this, g, 500, 700);
			summer[summerCounter].paintIcon(this, g, 750, 700);
			

		}
	}
	
	//Main Method
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangingImages frame = new ChangingImages();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


}