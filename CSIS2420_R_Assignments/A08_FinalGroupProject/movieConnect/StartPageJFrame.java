package movieConnect;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * The main frame for the Movie Connect application's start page. Allows users
 * to log in, input credentials, and navigate to the main page or exit the
 * application. The class handles user authentication, displays a verification
 * code, and provides visual feedback on mouse interactions.
 * 
 * @author Kamdon Bird, Haiyang Liu
 * @version 1.0
 */
@SuppressWarnings("serial")
public class StartPageJFrame extends JFrame implements MouseListener {

	/**
	 * A list of all users in the Movie Connect application. The list is initially
	 * populated with predefined user data.
	 */
	static ArrayList<User> allUsers = new ArrayList<>();
	static {
		allUsers.add(new User("Abbas Al-Younis", "12345"));
	    allUsers.add(new User("Ahmed Ali", "23456"));
	    allUsers.add(new User("Cannon Anderson", "34567"));
	    allUsers.add(new User("Haydon Anderson", "45678"));
	    allUsers.add(new User("Angel Ayala", "56789"));
	    allUsers.add(new User("Kamdon Bird", "56789"));
	    allUsers.add(new User("Cristian CamargoMorales", "78901"));
	    allUsers.add(new User("Jesse Cherry", "89012"));
	    allUsers.add(new User("Rafe Danos", "90123"));
	    allUsers.add(new User("Tanner Durrant", "01234"));
	    allUsers.add(new User("Noah Ewell", "12345"));
	    allUsers.add(new User("Samantha Gill", "23456"));
	    allUsers.add(new User("Valor Goff", "34567"));
	    allUsers.add(new User("Kimani Griffin", "45678"));
	    allUsers.add(new User("Jordan Johnson", "56789"));
	    allUsers.add(new User("Eliza Kitchens", "67890"));
	    allUsers.add(new User("Lexus Lindeman", "78901"));
	    allUsers.add(new User("Haiyang Liu", "12345"));
	    allUsers.add(new User("Jonathan Monstrola", "90123"));
	    allUsers.add(new User("Margarethe Posch", "01234"));
	    allUsers.add(new User("Tyson Potter", "12345"));
	    allUsers.add(new User("Syed Rahman", "23456"));
	    allUsers.add(new User("Zachary Royer", "34567"));
	    allUsers.add(new User("Trenton Stratton", "45678"));
	    allUsers.add(new User("Christopher Talbot", "56789"));
	    allUsers.add(new User("Xandon Vincent", "67890"));
	    allUsers.add(new User("Chanphone Visathip", "78901"));
	}

	private JButton login = new JButton();
	private JButton exit = new JButton();

	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JTextField code = new JTextField();
	private JLabel rightCode = new JLabel();

	/**
	 * Creates an instance of the StartPageJFrame. Initializes the frame, sets up
	 * components, and makes the frame visible.
	 */
	public StartPageJFrame() {
		initJFrame();
		initView();
		this.setVisible(true);
	}

	/**
	 * Initializes the visual components of the frame. Adds input fields, buttons,
	 * and sets up the background image.
	 */
	public void initView() {
		// Add user name text
		JLabel usernameText = new JLabel(new ImageIcon("A08_FinalGroupProject/movieConnect/Resources/Images/username.png"));
		usernameText.setBounds(116, 125, 45, 45);
		this.getContentPane().add(usernameText);
		username.setBounds(195, 134, 200, 30);
		this.getContentPane().add(username);
		// Add password text
		JLabel passwordText = new JLabel(new ImageIcon("A08_FinalGroupProject/movieConnect/Resources/Images/password.png"));
		passwordText.setBounds(116, 185, 47, 47);
		this.getContentPane().add(passwordText);
		// Password entry field
		password.setBounds(195, 195, 200, 30);
		this.getContentPane().add(password);
		// Verification code
		JLabel codeText = new JLabel(new ImageIcon("A08_FinalGroupProject/movieConnect/Resources/Images/verifycode.png"));
		codeText.setBounds(114, 245, 50, 50);
		this.getContentPane().add(codeText);
		// Verification code input field
		code.setBounds(195, 256, 100, 30);
		this.getContentPane().add(code);
		String codeStr = CodeUtil.getCode();
		// Set content
		rightCode.setText(codeStr);
		rightCode.setForeground(Color.WHITE);
		rightCode.setFont(new Font("Serif", Font.BOLD, 12));
		rightCode.setOpaque(true); // Make the background color visible
		rightCode.setBackground(Color.BLACK); // Set background color
		rightCode.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3)); // Set the border color and width
		rightCode.addMouseListener(this);
		rightCode.setBounds(300, 256, 50, 30);
		// Add to interface
		this.getContentPane().add(rightCode);
		login.setBounds(100, 310, 127, 45);
		login.setIcon(new ImageIcon("A08_FinalGroupProject/movieConnect/Resources/Images/login.png"));
		login.setBorderPainted(false);
		login.setContentAreaFilled(false);
		login.addMouseListener(this);
		this.getContentPane().add(login);

		// Add registration button
		exit.setBounds(265, 310, 110, 45);
		exit.setIcon(new ImageIcon("A08_FinalGroupProject/movieConnect/Resources/Images/exit.png"));
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.addMouseListener(this);
		this.getContentPane().add(exit);
		// Add background image
		JLabel background = new JLabel(new ImageIcon("A08_FinalGroupProject/movieConnect/Resources/Images/login.jpg"));
		background.setBounds(0, 0, 490, 405);
		this.getContentPane().add(background);

	}

	/**
	 * Initializes the frame settings, such as size, title, default close operation,
	 * and layout.
	 */
	public void initJFrame() {
		this.setSize(488, 430);
		this.setTitle("Movie Connect V1.0 Login");
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setLayout(null);
	}

	/**
	 * Handles mouse click events on components. Performs actions based on the
	 * source of the click, such as logging in, exiting, or changing the
	 * verification code.
	 *
	 * @param e The MouseEvent containing information about the mouse click.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == login) {
			System.out.println("Login Button Clicked");
			String usernameInput = username.getText();
			@SuppressWarnings("deprecation")
			String passwordInput = password.getText();
			String codeInput = code.getText();
			// Create a User object
			User userInfo = new User(usernameInput, passwordInput);
			System.out.println("The entered user name is" + usernameInput);
			System.out.println("The entered password is" + passwordInput);

			if (codeInput.length() == 0) {
				showJDialog("The verification code cannot be empty");
			} else if (usernameInput.length() == 0 || passwordInput.length() == 0) {
				System.out.println("The user name or password is empty");
				showJDialog("	The user name or password is empty.");
			} else if (!codeInput.equalsIgnoreCase(rightCode.getText())) {
				showJDialog("      Wrong Verificaiton Code.");
			} else if (contains(userInfo)) {
				System.out.println("The User name and Password are correct");
				this.setVisible(false);
				new MainPageJFrame(userInfo);
			} else {
				System.out.println("	The user name or password is incorrect.");
				showJDialog("	The user name or password is incorrect.");
			}
		} else if (e.getSource() == exit) {
			System.out.println("Exit button was clicked");
			System.exit(0); // Exit the application
		} else if (e.getSource() == rightCode) {
			System.out.println("Change verification code");
			// Get a new capTCHA
			String code = CodeUtil.getCode();
			rightCode.setText(code);
		}
	}

	/**
	 * Displays a modal dialog with the specified content.
	 * The dialog is a small pop-up window that provides information or prompts the user for input.
	 *
	 * @param content The content to be displayed in the dialog.
	 */
	public void showJDialog(String content) {
		JDialog jDialog = new JDialog();
		jDialog.setSize(250, 200);
		jDialog.setAlwaysOnTop(true);
		jDialog.setLocationRelativeTo(null);
		jDialog.setModal(true);
		// Create a Jlabel object to manage the text and add it to the pop-up
		JLabel warning = new JLabel(content);
		warning.setBounds(0, 0, 200, 150);
		jDialog.getContentPane().add(warning);
		// Let the pop-up show
		jDialog.setVisible(true);
	}

	/**
	 * Handles mouse press events on components. Changes the appearance of buttons
	 * when pressed.
	 *
	 * @param e The MouseEvent containing information about the mouse press.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == login) {
			login.setIcon(new ImageIcon("A08_FinalGroupProject/movieConnect/Resources/Images/loginclick.png"));
		} else if (e.getSource() == exit) {
			exit.setIcon(new ImageIcon("A08_FinalGroupProject/movieConnect/Resources/Images/exitpress.png"));
		}
	}

	/**
	 * Handles mouse release events on components. Resets the appearance of buttons
	 * when released.
	 *
	 * @param e The MouseEvent containing information about the mouse release.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == login) {
			login.setIcon(new ImageIcon("A08_FinalGroupProject/movieConnect/Resources/Images/login.png"));
		} else if (e.getSource() == exit) {
			exit.setIcon(new ImageIcon("A08_FinalGroupProject/movieConnect/Resources/Images/exit.png"));
		}
	}

	/**
	 * Handles mouse enter events on components. (Unused in the current
	 * implementation.)
	 *
	 * @param e The MouseEvent containing information about the mouse enter event.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Handles mouse exit events on components. (Unused in the current
	 * implementation.)
	 *
	 * @param e The MouseEvent containing information about the mouse exit event.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * Checks whether a user with the provided credentials exists in the list of all
	 * users.
	 *
	 * @param userInput The User object containing the entered username and
	 *                  password.
	 * @return true if the user exists, false otherwise.
	 */
	public boolean contains(User userInput) {
		for (int i = 0; i < allUsers.size(); i++) {
			User rightUser = allUsers.get(i);
			if (userInput.getUsername().equals(rightUser.getUsername())
					&& userInput.getPassword().equals(rightUser.getPassword())) {
				return true;
			}
		}
		return false;
	}
}