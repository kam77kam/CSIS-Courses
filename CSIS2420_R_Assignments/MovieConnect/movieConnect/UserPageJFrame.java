package movieConnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPageJFrame extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNumberField;
    private JButton backButton;

    public UserPageJFrame() {
        setLayout(new BorderLayout()); // Use BorderLayout for the main panel

        // Create a separate panel for the back button
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Create the back button
        backButton = new JButton("Back");
        backButtonPanel.add(backButton);

        // Add action listener to the back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch back to the main page
                App.showCard("mainPage");
            }
        });

        // Add the backButtonPanel to the main panel at the top
        add(backButtonPanel, BorderLayout.NORTH);

        // Create components for the user page
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        phoneNumberField = new JTextField(20);

        // Make text fields uneditable
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        phoneNumberField.setEditable(false);

        // Create a panel for the user information fields
        JPanel userInfoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        userInfoPanel.add(new JLabel("First Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        userInfoPanel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        userInfoPanel.add(new JLabel("Last Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        userInfoPanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        userInfoPanel.add(new JLabel("Phone Number:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        userInfoPanel.add(phoneNumberField, gbc);

        // Add the userInfoPanel to the main panel
        add(userInfoPanel, BorderLayout.CENTER);
    }

    public void updateUserInfo() {
        // Update text fields with user information
        firstNameField.setText(App.getUser().getFirstName());
        lastNameField.setText(App.getUser().getLastName());
        phoneNumberField.setText(App.getUser().getPhoneNumber());
    }
}