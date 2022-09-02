/*Assignment: package labCoin;
Program: CoinApp
Created: Mar 26, 2019
Author: Kamdon Bird
*/
package lab;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CoinApp extends JFrame{
	public CoinApp() {
		setSize(new Dimension(500, 300));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		JLabel coinLabel = new JLabel("");
		coinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		coinLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		getContentPane().add(coinLabel, BorderLayout.CENTER);
		
		JButton btnCent = new JButton("");
		btnCent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coinLabel.setText(Coin.CENT.toString());
			}
		});
		btnCent.setIcon(new ImageIcon(CoinApp.class.getResource("/Coins/UsCent.png")));
		panel.add(btnCent);
		
		JButton btnNickel = new JButton("");
		btnNickel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coinLabel.setText(Coin.NICKEL.toString());
			}
		});
		btnNickel.setIcon(new ImageIcon(CoinApp.class.getResource("/Coins/UsNickel.png")));
		panel.add(btnNickel);
		
		JButton btnDime = new JButton("");
		btnDime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coinLabel.setText(Coin.DIME.toString());
			}
		});
		btnDime.setIcon(new ImageIcon(CoinApp.class.getResource("/Coins/UsDime.png")));
		panel.add(btnDime);
		
		JButton btnQuarter = new JButton("");
		btnQuarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coinLabel.setText(Coin.QUARTER.toString());
			}
		});
		btnQuarter.setIcon(new ImageIcon(CoinApp.class.getResource("/Coins/UsQuarter.png")));
		panel.add(btnQuarter);
		

	}

	public static void main(String[] args) {
		for(Coin c : Coin.values()) {
			System.out.print(c.toString());
		}
		
		JFrame frame = new CoinApp();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
