/*  Assignment: A06 RedCounter
 	Program: RedCounter
	Created: 3/13/2019
	Author: Kamdon Bird
 */
package redCounter;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

/**
 * @author Kamdon Bird
 *
 */
public class RedCounter extends JFrame {

	/**
	 * for background initialization
	 */
	private JPanel contentPane;

	/**
	 * this is my counter to count every time the button is clicked and turns red
	 */
	int counter;  
	/**
	 * Launch the application.
	 * @param args 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedCounter frame = new RedCounter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RedCounter() {
		//fields
		counter = 0;  //counter is declared for method ActionPerformed (doesn't reset to 0 every time ActionPerformed is run)

		createPanel(); //creating Panel
		//TextFields and Events
		JLabel leftLabel = RedCounterLabel();
		JButton btnClickMe = createButton();
		kamdonLabel();

		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {   /*method creates a random color every time button is pushed and 
																counts once the color is red counter will go up 1*/
				Random random = new Random();
				int rand = random.nextInt(5);  

				Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.ORANGE}; /*the only 5 random colors
																									 I want it to pick from*/
				btnClickMe.setBackground(colors[rand]);
				if (btnClickMe.getBackground().equals(Color.RED)) {  //if the button is red add a 1 to counter display count
					counter += 1;
					if(counter<10) {
						leftLabel.setText("Red Counter: 0" + counter);
					}else 
						leftLabel.setText("Red Counter: " + counter);				
				}				
			}
		});
	}

	/**
	 * sets up background
	 */
	private void createPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	/**
	 * @return leftLabel for display
	 */
	private JLabel RedCounterLabel() {
		JLabel leftLabel = new JLabel("Red Counter: 00");
		leftLabel.setFont(new Font("Monospaced", Font.BOLD, 29));
		leftLabel.setBackground(Color.GRAY);
		leftLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(leftLabel, BorderLayout.WEST);
		return leftLabel;
	}

	/**
	 * returns btnClickme for display
	 */
	private JButton createButton() {
		JButton btnClickMe = new JButton("Click Me");
		btnClickMe.setFont(new Font("Monospaced", Font.BOLD, 35));
		btnClickMe.setForeground(Color.WHITE);
		btnClickMe.setBackground(Color.BLUE);
		contentPane.add(btnClickMe, BorderLayout.EAST);
		return btnClickMe;
	}

	/**
	 * Kamdon the name is displayed
	 */
	private void kamdonLabel() {
		JLabel lblKamdonGui = new JLabel("Kamdon's GUI");
		lblKamdonGui.setHorizontalAlignment(SwingConstants.CENTER);
		lblKamdonGui.setFont(new Font("Segoe Print", Font.BOLD, 33));
		lblKamdonGui.setBackground(Color.LIGHT_GRAY);
		contentPane.add(lblKamdonGui, BorderLayout.SOUTH);
	}
}
