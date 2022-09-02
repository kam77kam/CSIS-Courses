/*Assignment: package labdice;
Program: LabDice
Created: Feb 28, 2019
Author: Kamdon Bird
*/
package lab;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class LabDice extends JFrame {
	Icon die1 = new ImageIcon(LabDice.class.getResource("/labdice/die-1.png"));
	Icon die2 = new ImageIcon(LabDice.class.getResource("/labdice/die-2.png"));
	Icon die3 = new ImageIcon(LabDice.class.getResource("/labdice/die-3.png"));
	Icon die4 = new ImageIcon(LabDice.class.getResource("/labdice/die-4.png"));
	Icon die5 = new ImageIcon(LabDice.class.getResource("/labdice/die-5.png"));
	Icon die6 = new ImageIcon(LabDice.class.getResource("/labdice/die-6.png"));
	Icon[] dice = {die1, die2, die3, die4, die5, die6};
	Random r = new Random();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabDice frame = new LabDice();
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
	public LabDice() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(LabDice.class.getResource("/labdice/die-1.png")));
		contentPane.add(label, BorderLayout.CENTER);
		
		JButton btnRollEm = new JButton("Roll Em'");
		btnRollEm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setIcon(dice[r.nextInt(6)]);
			}
		});
		btnRollEm.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRollEm.setBackground(Color.BLACK);
		btnRollEm.setForeground(Color.PINK);
		contentPane.add(btnRollEm, BorderLayout.SOUTH);
		

	}

}
