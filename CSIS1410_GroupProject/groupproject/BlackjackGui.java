/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

/**
 *
 * @author Helaman
 */
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class BlackjackGui extends JFrame implements ActionListener {

	// these declare the deal, hit, and stay [buttons]
	private JButton deal;

	// this is the background label
	private JLabel bg;

	private int dealer = 1;
	JPanel panel;

	public BlackjackGui() {

		// this is the blackjack table
		Container contentPane = getContentPane();

		contentPane.setLayout(null);

		contentPane.setBackground(Color.GREEN);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setTitle("Blackjack 21");

		setSize(750, 700);

		setResizable(false);

		setLocation(100, 25);

		panel = new JPanel();
		panel.setBounds(0, 0, 743, 700);
		getContentPane().add(panel);
		panel.setLayout(null);

		// these are the deal, stay, hit buttons
		deal = new JButton("Deal");
		deal.setBounds(150, 600, 75, 25);
		panel.add(deal);

		JButton stay = new JButton("Stay");
		stay.setBounds(300, 600, 75, 25);
		panel.add(stay);

		JButton hit = new JButton("Hit");
		hit.setBounds(450, 600, 75, 25);
		panel.add(hit);

		// these are the dealers card slot labels
		JLabel dslot5 = new JLabel("");
		dslot5.setBounds(600, 50, 100, 152);
		panel.add(dslot5);
		dslot5.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));

		dslot5.setBorder(BorderFactory.createLineBorder(Color.pink));

		JLabel dslot4 = new JLabel("");
		dslot4.setBounds(460, 50, 100, 152);
		panel.add(dslot4);
		dslot4.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));

		dslot4.setBorder(BorderFactory.createLineBorder(Color.yellow));
		
		JLabel dslot3 = new JLabel("");
		dslot3.setBounds(322, 50, 100, 152);
		panel.add(dslot3);	
		dslot3.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));	
				
		dslot3.setBorder(BorderFactory.createLineBorder(Color.green));

		JLabel dslot2 = new JLabel("");
		dslot2.setBounds(187, 50, 100, 152);
		panel.add(dslot2);
		dslot2.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));

		dslot2.setBorder(BorderFactory.createLineBorder(Color.blue));

		JLabel dslot1 = new JLabel("");
		dslot1.setBounds(50, 50, 100, 152);
		panel.add(dslot1);
		dslot1.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));

		dslot1.setBorder(BorderFactory.createLineBorder(Color.white));

		// these are the player card slot labels
		JLabel pslot5 = new JLabel("");
		pslot5.setBounds(600, 300, 100, 152);
		panel.add(pslot5);
		pslot5.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));

		pslot5.setBorder(BorderFactory.createLineBorder(Color.pink));

		JLabel pslot4 = new JLabel("");
		pslot4.setBounds(460, 300, 100, 152);
		panel.add(pslot4);
		pslot4.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));

		pslot4.setBorder(BorderFactory.createLineBorder(Color.yellow));

		JLabel pslot3 = new JLabel("");
		pslot3.setBounds(322, 300, 100, 152);
		panel.add(pslot3);
		pslot3.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));

		pslot3.setBorder(BorderFactory.createLineBorder(Color.green));

		JLabel pslot2 = new JLabel("");
		pslot2.setBounds(187, 300, 100, 152);
		panel.add(pslot2);
		pslot2.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));

		pslot2.setBorder(BorderFactory.createLineBorder(Color.blue));

		JLabel pslot1 = new JLabel("");
		pslot1.setBounds(50, 300, 100, 152);
		panel.add(pslot1);
		pslot1.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));

		pslot1.setBorder(BorderFactory.createLineBorder(Color.white));

		// this shows the dealers score [field]
		JTextField dscore = new JTextField("Dealers Score:");
		dscore.setBounds(50, 250, 144, 25);
		panel.add(dscore);
		dscore.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// this shows the players score [field]
		JTextField pscore = new JTextField("Players Score:");
		pscore.setBounds(50, 500, 150, 25);
		panel.add(pscore);
		pscore.setFont(new Font("Tahoma", Font.PLAIN, 18));

		bg = new JLabel();
		bg.setOpaque(true);
		bg.setBounds(0, 0, 743, 700);
		panel.add(bg);

		bg.setBorder(BorderFactory.createLineBorder(Color.black));

		pscore.addActionListener(this);

		dscore.addActionListener(this);

		hit.addActionListener(this);

		stay.addActionListener(this);

		deal.addActionListener(this);

		bg.setIcon(new ImageIcon(BlackjackGui.class.getResource("")));

	}

	public static void main(String args[]) {

		BlackjackGui frame = new BlackjackGui();

		frame.setVisible(true);

	}

	// this will show the dealer and player cards when deal button is pressed
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof JButton) {

			JButton clicked = (JButton) e.getSource();

			if (clicked == deal) {

				{

					//                    dslot1.setIcon(as);
					//
					//                    pslot1.setIcon(ths);
					//
					//                    dslot2.setIcon(backofcard);
					//
					//                    pslot2.setIcon(fos);

				}

			}

		}

	}

}
