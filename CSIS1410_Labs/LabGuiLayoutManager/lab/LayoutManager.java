/*Assignment: package layout;
Program: LayoutManager
Created: Feb 28, 2019
Author: %{user}
*/
package lab;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LayoutManager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutManager frame = new LayoutManager();
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
	public LayoutManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel label1 = new JLabel("1");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label1);
		label1.setOpaque(true);
		label1.setBackground(Color.RED);
		
		JLabel label2 = new JLabel("2");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label2);
		label2.setOpaque(true);
		label2.setBackground(Color.YELLOW);

		JLabel label3 = new JLabel("3");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label3);
		label3.setOpaque(true);
		label3.setBackground(Color.GREEN);
		
		JLabel label4 = new JLabel("4");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setOpaque(true);
		label4.setBackground(Color.BLUE);
		panel_1.add(label4);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("<====");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(label1.getBackground() == Color.BLUE) {
					label1.setBackground(Color.YELLOW);
					label4.setBackground(Color.BLUE);
				}else if(label2.getBackground() == Color.BLUE){
					label2.setBackground(Color.YELLOW);
					label1.setBackground(Color.BLUE);
				}else if(label3.getBackground() == Color.BLUE) {
					label3.setBackground(Color.YELLOW);
					label2.setBackground(Color.BLUE);
				}else if (label4.getBackground() == Color.BLUE){
					label4.setBackground(Color.YELLOW);
					label3.setBackground(Color.BLUE);
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("====>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label1.getBackground() == Color.BLUE) {
					label1.setBackground(Color.YELLOW);
					label2.setBackground(Color.BLUE);
				}else if(label2.getBackground() == Color.BLUE){
					label2.setBackground(Color.YELLOW);
					label3.setBackground(Color.BLUE);
				}else if(label3.getBackground() == Color.BLUE) {
					label3.setBackground(Color.YELLOW);
					label4.setBackground(Color.BLUE);
				}else if (label4.getBackground() == Color.BLUE){
					label4.setBackground(Color.YELLOW);
					label1.setBackground(Color.BLUE);
				}
			}
		});
		panel.add(btnNewButton);
		
	}

}
