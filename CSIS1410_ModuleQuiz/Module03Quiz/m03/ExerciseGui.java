/*Assignment: Module 03 CODE
Program: ExerciseGui
Created: Mar 14, 2019
Author: Kamdon Bird
 */
package m03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * @author Kamdon Bird
 *
 */
public class ExerciseGui extends JFrame {

	/**
	 * Background events
	 */
	private JPanel contentPane;
	/**
	 * JTextField called txtVot that creates a heading "V O T E"
	 */
	private JTextField txtVOT;

	/**
	 * count for democrats starting at 0 and going up 1
	 */
	int counterL = 00;
	/**
	 * count for republicans starting at 0 and going up 1
	 */
	int counterR = 00;
	/**
	 * converts counterL to a string
	 */
	String zeroL;
	/**
	 * converts counterR to a string
	 */
	String zeroR;

	/**
	 * Launch the application.
	 * @param args 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExerciseGui frame = new ExerciseGui();
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
	public ExerciseGui() {
		createBackground();

		//creates a gray background for images
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);

		createVoteText();

		JLabel lblRepublican = new JLabel("Republican: ");
		lblRepublican.setFont(new Font("Courier New", Font.PLAIN, 18));

		JLabel lblDemocrat = new JLabel("Democrat: ");
		lblDemocrat.setFont(new Font("Courier New", Font.PLAIN, 18));

		JLabel leftNum = new JLabel("00");
		leftNum.setFont(new Font("Courier New", Font.PLAIN, 18));

		JLabel rightNum = new JLabel("00");
		rightNum.setFont(new Font("Courier New", Font.PLAIN, 18));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(10)
						.addComponent(txtVOT, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(25)
						.addComponent(lblRepublican)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(rightNum)
						.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
						.addComponent(lblDemocrat)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(leftNum)
						.addGap(25))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(txtVOT, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRepublican)
								.addComponent(lblDemocrat)
								.addComponent(rightNum)
								.addComponent(leftNum))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		//Button for republicans
		JButton right = new JButton("");
		right.setIcon(new ImageIcon(ExerciseGui.class.getResource("/module03/images/Republican-logo.png")));
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counterR += 1;
				String newNum = Integer.toString(counterR);
				if(counterR < 10) {
					rightNum.setText(newNum);
					zeroR = "0";
					rightNum.setText(zeroR + newNum);
				}else if(counterR > 99) {
					rightNum.setText("99");
				}else
					rightNum.setText(newNum);
			}
		});


		//Button for democrats 
		JButton left = new JButton("");
		left.setIcon(new ImageIcon(ExerciseGui.class.getResource("/module03/images/Democrat-logo.png")));
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counterL += 1;
				String newNum = Integer.toString(counterL);
				if(counterL < 10) {
					leftNum.setText(newNum);
					zeroL = "0";
					leftNum.setText(zeroL + newNum);
				}else if(counterL > 99) {
					leftNum.setText("99");
				}else
					leftNum.setText(newNum);

			}
		});


		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(right, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
						.addComponent(left, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(right, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
								.addComponent(left, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * creates "Vote" text for heading
	 */
	private void createVoteText() {
		txtVOT = new JTextField();
		txtVOT.setForeground(Color.DARK_GRAY);
		txtVOT.setBorder(null);
		txtVOT.setBackground(UIManager.getColor("Button.light"));
		txtVOT.setHorizontalAlignment(SwingConstants.CENTER);
		txtVOT.setFont(new Font("Tahoma", Font.BOLD, 26));
		txtVOT.setText("V O T E");
		txtVOT.setColumns(10);
	}
	/**
	 * creates background for events
	 */
	private void createBackground() {
		//creates JPanel with a group layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}
}