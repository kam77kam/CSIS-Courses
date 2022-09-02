/**
 * Assignment: LabBalloon
 * Program: BalloonApp
 * Created: Mar 5, 2019
 * @Author Zachary Funk
 *
 * Notes:
 *
 *
 **/



package lab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BalloonApp {

	private JFrame frame;
	private final JButton btnNewButton = new JButton("Get Random Balloon");
	private JTextField textField;
	private Size[] sizes = Size.values();
//	private Icon[] icons;// = {BalloonApp.class.getResource("/balloon/balloon100.jpg"), BalloonApp.class.getResource("/balloon/balloon20.jpg")};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalloonApp window = new BalloonApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BalloonApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Random r = new Random();
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("LabBalloon");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		
		textField = new JTextField();
		
		Icon[] icons = {
				new ImageIcon(BalloonApp.class.getResource("/labBalloon/balloon100.jpg")),
				new ImageIcon(BalloonApp.class.getResource("/labBalloon/balloon20.jpg")),
				new ImageIcon(BalloonApp.class.getResource("/labBalloon/balloon40.jpg")),
				new ImageIcon(BalloonApp.class.getResource("/labBalloon/balloon60.jpg")),	
				new ImageIcon(BalloonApp.class.getResource("/labBalloon/balloon80.jpg"))};
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel balloon1 = new JLabel("");
		balloon1.setVerticalTextPosition(SwingConstants.BOTTOM);
		balloon1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		balloon1.setHorizontalTextPosition(SwingConstants.CENTER);
		balloon1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(balloon1);
		
		JLabel balloon2 = new JLabel("");
		balloon2.setVerticalTextPosition(SwingConstants.BOTTOM);
		balloon2.setHorizontalAlignment(SwingConstants.CENTER);
		balloon2.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_1.add(balloon2);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num1 = Math.abs(r.nextInt(sizes.length));
				int num2 = Math.abs(r.nextInt(sizes.length));
				Balloon b1 = new Balloon(r.nextBoolean(), sizes[num1]);
				Balloon b2 = new Balloon(r.nextBoolean(), sizes[num2]);
				balloon1.setIcon(icons[num1]);
				balloon2.setIcon(icons[num2]);
				balloon1.setText(b1.toString());
				balloon2.setText(b2.toString());

				if(b1.equals(b2)) {
					textField.setText("Equals");
					textField.setBackground(Color.GREEN);
				}
				else {
					textField.setText("Does Not Equal");
					textField.setBackground(Color.RED);
				}
			}
		});
		panel.add(btnNewButton);
		
		
		panel.add(textField);
		textField.setColumns(10);
		
		
	}

}
