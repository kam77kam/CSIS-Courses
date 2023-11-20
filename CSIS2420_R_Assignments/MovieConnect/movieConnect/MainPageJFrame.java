package movieConnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageJFrame extends JPanel {
    public MainPageJFrame() {
        setLayout(new BorderLayout());

        // Create a panel for the top buttons
        JPanel topButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton userButton = new JButton("User");
        JButton friendsButton = new JButton("Friends");

        // Add action listeners to the buttons
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the account page
                App.showCard("userPage");
            }
        });

        friendsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the friends page
                App.showCard("friendsPage");
            }
        });

        topButtonPanel.add(userButton);
        topButtonPanel.add(friendsButton);

        // Create a panel for the bottom buttons
        JPanel bottomButtonPanel = new JPanel(new BorderLayout());
        JButton dislikeButton = new JButton("Dislike");
        JButton likeButton = new JButton("Like");
        JButton detailsButton = new JButton("Details");

        // Add action listeners to the buttons
        dislikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle dislike action
            }
        });

        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle like action
            }
        });

        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the details page
                App.showCard("detailsPage");
            }
        });

        bottomButtonPanel.add(dislikeButton, BorderLayout.WEST);
        bottomButtonPanel.add(likeButton, BorderLayout.EAST);
        bottomButtonPanel.add(detailsButton, BorderLayout.CENTER);

        // Add the top and bottom button panels to the main panel
        add(topButtonPanel, BorderLayout.NORTH);
        add(bottomButtonPanel, BorderLayout.SOUTH);
    }
}