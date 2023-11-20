package movieConnect;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
	private static CardLayout cardLayout = new CardLayout();
	private static JPanel cardPanel = new JPanel(cardLayout);
	private static User user; // Store the User object

	public App() {
		// Initialize the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 600);
		setLocationRelativeTo(null);

		// Create instances of each page
		RegisterJFrame startPage = new RegisterJFrame();
		MainPageJFrame mainPage = new MainPageJFrame();
		UserPageJFrame userPage = new UserPageJFrame();
//     FriendsPage friendsPage = new FriendsPage();
//     DetailsPage detailsPage = new DetailsPage();

		// Add pages to the card panel
		cardPanel.add(startPage, "startPage");
		cardPanel.add(mainPage, "mainPage");
		cardPanel.add(userPage, "userPage");
//     cardPanel.add(friendsPage, "friendsPage");
//     cardPanel.add(detailsPage, "detailsPage");

		// Show the start page initially
		showCard("startPage");

		// Add the card panel to the frame
		add(cardPanel);

		setVisible(true);
	}

	// Method to switch between cards
	public static void showCard(String cardName) {
		cardLayout.show(cardPanel, cardName);

		// Update user information on UserPage when switching to UserPage
		if (cardName.equals("userPage")) {
			((UserPageJFrame) cardPanel.getComponent(2)).updateUserInfo();
		}
	}
	
	public static void setUser(User newUser) {
	    user = newUser;
	}
	// Getter for the User object
	public static User getUser() {
		return user;
	}


	public static void main(String[] args) {
		// Run the application
		SwingUtilities.invokeLater(() -> new App());
	}
}
