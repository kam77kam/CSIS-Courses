/*Assignment: package labgui;
Program: LabGUI
Created: Feb 12, 2019
Author: Kamdon Bird
*/
package lab;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;


public class LabGUI {
	private static JTextField textField;
	private static JFrame frame;

	public static void main(String[] args) {
		//creating a frame or window
		frame = new JFrame();
		//allowing frame to close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//creating size
		frame.setBounds(10, 10, 400, 400);
		
		JLabel centerLabel = new JLabel("Hi");
		//creating foreground of window
		centerLabel.setForeground(Color.ORANGE);
		//creating color as red
		centerLabel.setBackground(Color.RED);
		frame.getContentPane().add(centerLabel);
		//allow foreground to be enabled
		centerLabel.setOpaque(true);
		centerLabel.setFont(new Font("Tacoma",0,77));
		//center alignment
		centerLabel.setHorizontalAlignment(JLabel.CENTER);
		centerLabel.setOpaque(true);
		centerLabel.setFont(new Font ("Papyrus", Font.BOLD,77));
		frame.getContentPane().add(centerLabel);
		
		JLabel lblNorth = new JLabel("My First Gui");
		lblNorth.setOpaque(true);
		lblNorth.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNorth.setBackground(Color.BLUE);
		lblNorth.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNorth, BorderLayout.NORTH);
		
		JButton btnWest = new JButton("WEST");
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnWest, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JLabel name = new JLabel("Name: ");
		panel.add(name);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(16);
		//allow window to be seen (defaults as false)
		frame.setVisible(true);
	}
}	