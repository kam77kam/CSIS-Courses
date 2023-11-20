package movieConnect;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class RegisterJFrame extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNumberField;
    private JButton nextButton;

    // Store user information
    private User user;

    public RegisterJFrame() {
        // Initialize User object with empty values
        user = new User("", "", "");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

		// Create components for the start page
		firstNameField = new JTextField(20);
		lastNameField = new JTextField(20);
		phoneNumberField = new JTextField(20);
		user = new User("", "", "");
		nextButton = new JButton("Next");
		nextButton.setEnabled(false); // Initially, disable the button

		// Add action listener to the button
		nextButton.addActionListener(e -> {
		    App.showCard("mainPage");
		    App.setUser(user); // Update the user object in App
		});

		// Add document listeners to the text fields
		firstNameField.getDocument().addDocumentListener(new MyDocumentListener());
		lastNameField.getDocument().addDocumentListener(new MyDocumentListener());
		phoneNumberField.getDocument().addDocumentListener(new MyDocumentListener());

		// Add components to the panel using GridBagLayout
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		add(new JLabel("First Name:"), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // Span the remaining columns
		add(firstNameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1; // Reset gridwidth
		add(new JLabel("Last Name:"), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // Span the remaining columns
		add(lastNameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1; // Reset gridwidth
		add(new JLabel("Phone Number:"), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // Span the remaining columns
		add(phoneNumberField, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // Span the remaining columns
		gbc.anchor = GridBagConstraints.CENTER;
		add(nextButton, gbc);
	}

    private class MyDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateUserData();
            checkFields();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateUserData();
            checkFields();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateUserData();
            checkFields();
        }

        private void updateUserData() {
            // Update user information
            user = new User(firstNameField.getText(), lastNameField.getText(), phoneNumberField.getText());
        }

        private void checkFields() {
            // Check if all text fields are filled and phone number is exactly 10 digits
            boolean fieldsFilled = !user.getFirstName().isEmpty()
                    && !user.getLastName().isEmpty()
                    && !user.getPhoneNumber().isEmpty()
                    && user.getPhoneNumber().length() == 10;

            nextButton.setEnabled(fieldsFilled);
        }
    }
}