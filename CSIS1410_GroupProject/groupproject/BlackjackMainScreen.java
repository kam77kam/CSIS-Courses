/**
 * Assignment: A10
 * Program: BlackjackMainScreen
 * Created: Apr 20, 2019
 *
 * @Author Zachary Funk, Kamdon Bird, Mellisa Clark, Helaman Brown
 *
 * Notes:
 *
 *
 *
 */
package groupproject;

import javax.swing.*;

import groupproject.Deck.DECK;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

public class BlackjackMainScreen<DeckCard> {

    private JFrame frame;
    private JTextField nameField;
    private JPanel panelGame = new JPanel();
    private GameLogic myGame = new GameLogic();
    private ArrayList<JLabel> playerLabels = new ArrayList<>();
    private ArrayList<JLabel> dealerLabels = new ArrayList<>();
    private JLabel dslot1 = new JLabel();
    private JLabel pslot5 = new JLabel();
    private JLabel pslot4 = new JLabel();
    private JLabel pslot3 = new JLabel();
    private JLabel pslot2 = new JLabel();
    private JLabel pslot1 = new JLabel();
    private JLabel dslot5 = new JLabel();
    private JLabel dslot4 = new JLabel();
    private JLabel dslot3 = new JLabel();
    private JLabel dslot2 = new JLabel();
    private JButton deal = new JButton();
    private JButton hit = new JButton();
    private JButton stay = new JButton();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlackjackMainScreen window = new BlackjackMainScreen();
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
    public BlackjackMainScreen() {
        initMainScreen();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initMainScreen() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.getContentPane().setMinimumSize(new Dimension(750, 700));

        JPanel panelGame = new JPanel();
        panelGame.setOpaque(false);
        panelGame.setBackground(SystemColor.textHighlight);
        frame.getContentPane().add(panelGame, BorderLayout.NORTH);
        panelGame.setLayout(null);

        // these are the dealers card slot labels
        dslot5 = new JLabel("");
        dslot5.setBounds(600, 50, 100, 152);
        panelGame.add(dslot5);
        dslot5.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png")));

        dslot5.setBorder(BorderFactory.createLineBorder(Color.pink));

        dslot4 = new JLabel("");
        dslot4.setBounds(460, 50, 100, 152);
        panelGame.add(dslot4);
        dslot4.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png")));

        dslot4.setBorder(BorderFactory.createLineBorder(Color.yellow));

        dslot3 = new JLabel("");
        dslot3.setBounds(322, 50, 100, 152);
        panelGame.add(dslot3);
        dslot3.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png")));

        dslot3.setBorder(BorderFactory.createLineBorder(Color.green));

        dslot2 = new JLabel("");
        dslot2.setBounds(187, 50, 100, 152);
        panelGame.add(dslot2);
        dslot2.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png")));

        dslot2.setBorder(BorderFactory.createLineBorder(Color.blue));

        dslot1 = new JLabel("");
        dslot1.setBounds(50, 50, 100, 152);
        panelGame.add(dslot1);
        dslot1.setIcon(new ImageIcon(getClass().getResource("/cards/purple_back.png")));

        dslot1.setBorder(BorderFactory.createLineBorder(Color.white));

        // these are the player card slot labels
        pslot5 = new JLabel("");
        pslot5.setBounds(600, 300, 100, 152);
        panelGame.add(pslot5);
        pslot5.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png")));

        pslot5.setBorder(BorderFactory.createLineBorder(Color.pink));

        pslot4 = new JLabel("");
        pslot4.setBounds(460, 300, 100, 152);
        panelGame.add(pslot4);
        pslot4.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png")));

        pslot4.setBorder(BorderFactory.createLineBorder(Color.yellow));

        pslot3 = new JLabel("");
        pslot3.setBounds(322, 300, 100, 152);
        panelGame.add(pslot3);
        pslot3.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png")));

        pslot3.setBorder(BorderFactory.createLineBorder(Color.green));

        pslot2 = new JLabel("");
        pslot2.setBounds(187, 300, 100, 152);
        panelGame.add(pslot2);
        pslot2.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png")));

        pslot2.setBorder(BorderFactory.createLineBorder(Color.blue));

        pslot1 = new JLabel("");
        pslot1.setBounds(50, 300, 100, 152);
        panelGame.add(pslot1);
        pslot1.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png")));

        pslot1.setBorder(BorderFactory.createLineBorder(Color.white));

        // this shows the dealers score [field]
        JTextField dscore = new JTextField("Dealers Score:");
        dscore.setEditable(false);
        dscore.setBounds(50, 250, 144, 25);
        panelGame.add(dscore);
        dscore.setFont(new Font("Tahoma", Font.PLAIN, 18));

        // this shows the players score [field]
        JTextField pscore = new JTextField("Players Score:");
        pscore.setEditable(false);
        pscore.setBounds(50, 500, 150, 25);
        panelGame.add(pscore);
        pscore.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JPanel mainScreen = new JPanel();
        frame.getContentPane().add(mainScreen, BorderLayout.CENTER);
        mainScreen.setLayout(null);

        JLabel lblWelcomeToBlackjack = new JLabel("Welcome to BlackJack!");
        lblWelcomeToBlackjack.setFont(new Font("Times New Roman", Font.BOLD, 41));
        lblWelcomeToBlackjack.setBounds(160, 123, 412, 76);
        mainScreen.add(lblWelcomeToBlackjack);

        JLabel lblPleaseEnterYour = new JLabel("Please enter your name:");
        lblPleaseEnterYour.setFont(new Font("Sylfaen", Font.PLAIN, 30));
        lblPleaseEnterYour.setBounds(54, 237, 310, 82);
        mainScreen.add(lblPleaseEnterYour);

        nameField = new JTextField("");
        nameField.setFont(new Font("Sylfaen", Font.PLAIN, 30));
        nameField.setBounds(374, 237, 267, 82);
        mainScreen.add(nameField);
        nameField.setColumns(10);

        JButton btnSeePreviousPlayers = new JButton("See Previous Players");
        btnSeePreviousPlayers.setBounds(31, 590, 170, 37);
        JPanel previousPlayers = new JPanel();
        btnSeePreviousPlayers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                List<String> users = new ArrayList<>();
                users = BlackjackReaderWriter.readFile("./src/groupProject/app.txt");

                ;
                previousPlayers.setOpaque(false);
                previousPlayers.setBackground(SystemColor.textHighlight);previousPlayers.setLayout(null);
                
                
                String temp = new String("");
                for(String u : users){
                    temp += u + "\n";
//                    System.out.println(u.getFirstName());
                }
                
                JTextArea text = new JTextArea(5,20);
                JScrollPane scrollPane = new JScrollPane(text);
                text.setEditable(false);
                
                text.append(temp);
                
                text.setBackground(Color.MAGENTA);
                text.setOpaque(true);
                text.setBounds(600, 50, 300, 300);
                scrollPane.setBounds(0, 0, 750, 700);
                previousPlayers.add(scrollPane);
                frame.getContentPane().remove(mainScreen);
                frame.getContentPane().add(previousPlayers, BorderLayout.CENTER);
                
                
                text.setVisible(true);
                frame.setSize(751, 701);
                frame.setSize(750, 700);
            }
        });
        mainScreen.add(btnSeePreviousPlayers);
        JButton btnMainMenu = new JButton("Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(previousPlayers);
                frame.getContentPane().add(mainScreen);
                deal.setVisible(true);
                stay.setVisible(false);
                hit.setVisible(false);
                frame.setSize(751, 701);
                frame.setSize(750, 700);
            }
        });
        btnMainMenu.setBounds(611, 544, 100, 40);
        previousPlayers.add(btnMainMenu);
        

        JButton btnStart = new JButton("Click here to start!");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (nameField.getText().isEmpty()) {
                    JFrame parent = new JFrame();
                    JOptionPane.showMessageDialog(parent, "Enter your name please");
                } else {
                    BlackjackReaderWriter bjrw = new BlackjackReaderWriter();
                    try {
                    	User u = new User();
                    	u.setFirstName(nameField.getText());
                    	
                        bjrw.writeCsv("./src/groupProject/app.txt", nameField.getText());
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(BlackjackMainScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame.getContentPane().remove(mainScreen);
                    frame.getContentPane().add(panelGame);
                    
                    frame.setSize(751, 701);
                    frame.setSize(750, 700);
                }
            }
        });
        btnStart.setBounds(374, 348, 267, 43);
        mainScreen.add(btnStart);
        frame.setBounds(100, 100, 750, 703);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // these are the deal, stay, hit buttons
        JButton deal = new JButton("Deal");
        panelGame.add(deal);

        deal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                pslot1.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));

                deal.setVisible(false);
                hit.setVisible(true);
                stay.setVisible(true);
                blankCards();

                myGame.newRound();
                ArrayList<DECK> playerHand = myGame.getPlayerHand();
                int pSize = playerHand.size();
                for (int i = 0; i < pSize; i++) {
                    switch (i) {
                        case 0:
                            findImages(playerHand.get(i), i, pslot1);
                            break;
                        case 1:
                            findImages(playerHand.get(i), i, pslot2);
                            break;
                        case 2:
                            findImages(playerHand.get(i), i, pslot3);
                            break;
                        case 3:
                            findImages(playerHand.get(i), i, pslot4);
                            break;
                        case 4:
                            findImages(playerHand.get(i), i, pslot5);
                            break;

                        default:
                            break;
                    }
                }
                ArrayList<DECK> dealerHand = myGame.getDealerHand();
                int dSize = dealerHand.size();
                for (int i = 0; i < dSize; i++) {
                    switch (i) {
                        case 0:
                            findImages(dealerHand.get(i), i, dslot1);
                            break;
                        case 1:
                            findImages(dealerHand.get(i), i, dslot2);
                            break;
                        case 2:
                            findImages(dealerHand.get(i), i, dslot3);
                            break;
                        case 3:
                            findImages(dealerHand.get(i), i, dslot4);
                            break;
                        case 4:
                            findImages(dealerHand.get(i), i, dslot5);
                            break;

                        default:
                            break;
                    }
                }
                dscore.setText("Dealer score: " + myGame.curPoints(dealerHand));
                pscore.setText("Player score: " + myGame.curPoints(playerHand));
                playerBust(myGame.pOver21());
                //				deal.setVisible(true);
            }

        });
        deal.setBounds(150, 600, 75, 25);

        stay = new JButton("Stay");
        stay.addActionListener(new ActionListener() {
            ArrayList<DECK> dealerHand = myGame.getDealerHand();

            public void actionPerformed(ActionEvent arg0) {
                hit.setVisible(false);
                while (myGame.dOver21()) {
                    myGame.draw(myGame.getDealerHand());
                    if (myGame.dOver21() == false || dealerHand.size() > myGame.getPlayerHand().size() + 1) {
                        deal.setVisible(true);
                        stay.setVisible(false);
                    }
                    int dSize = dealerHand.size();
                    for (int i = 0; i < dSize; i++) {
                        switch (i) {
                            case 0:
                                findImages(dealerHand.get(i), i, dslot1);
                                break;
                            case 1:
                                findImages(dealerHand.get(i), i, dslot2);
                                break;
                            case 2:
                                findImages(dealerHand.get(i), i, dslot3);
                                break;
                            case 3:
                                findImages(dealerHand.get(i), i, dslot4);
                                break;
                            case 4:
                                findImages(dealerHand.get(i), i, dslot5);
                                break;

                            default:
                                break;
                        }
                    }
                    dscore.setText("Player score: " + myGame.curPoints(dealerHand));
                    dealerBust(myGame.dOver21());
                }
            }
        });
        stay.setBounds(300, 600, 75, 25);
        panelGame.add(stay);
        hit = new JButton("Hit");
        hit.addActionListener(new ActionListener() {
            ArrayList<DECK> playerHand = myGame.getPlayerHand();

            public void actionPerformed(ActionEvent e) {

                myGame.draw(myGame.getPlayerHand());

                if (myGame.pOver21() == false) {
                    deal.setVisible(true);
                    stay.setVisible(false);
                    hit.setVisible(false);
                } else {
                    deal.setVisible(false);
                    stay.setVisible(true);
                    hit.setVisible(true);
                }

                int pSize = playerHand.size();
                for (int i = 0; i < pSize; i++) {
                    switch (i) {
                        case 0:
                            findImages(playerHand.get(i), i, pslot1);
                            break;
                        case 1:
                            findImages(playerHand.get(i), i, pslot2);
                            break;
                        case 2:
                            findImages(playerHand.get(i), i, pslot3);
                            break;
                        case 3:
                            findImages(playerHand.get(i), i, pslot4);
                            break;
                        case 4:
                            findImages(playerHand.get(i), i, pslot5);
                            break;

                        default:
                            break;
                    }
                }

                pscore.setText("Player score: " + myGame.curPoints(playerHand));
                playerBust(myGame.pOver21());
            }
        });
        hit.setBounds(450, 600, 75, 25);
        panelGame.add(hit);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(panelGame);
                frame.getContentPane().add(mainScreen);
                deal.setVisible(true);
                stay.setVisible(false);
                hit.setVisible(false);
                frame.setSize(751, 701);
                frame.setSize(750, 700);
            }
        });
        btnMainMenu.setBounds(611, 544, 100, 40);
        panelGame.add(btnMainMenu);

    }

    private void findImages(DECK card, int index, JLabel label) {
        if (card.ordinal() == (DECK.CLUB_10.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/10C.png")));
        } else if (card.ordinal() == DECK.DIAMOND_10.ordinal()) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/10D.png")));
        } else if (card.ordinal() == DECK.HEART_10.ordinal()) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/10H.png")));
        } else if (card.ordinal() == DECK.SPADE_10.ordinal()) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/10S.png")));
        } else if (card.ordinal() == DECK.CLUB_2.ordinal()) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/2C.png")));
        } else if (card.ordinal() == DECK.DIAMOND_2.ordinal()) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/2D.png")));
        } else if (card.ordinal() == DECK.HEART_2.ordinal()) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/2H.png")));
        } else if (card.ordinal() == DECK.SPADE_2.ordinal()) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/2S.png")));
        } else if (card.ordinal() == (DECK.CLUB_3.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/3C.png")));
        } else if (card.ordinal() == (DECK.DIAMOND_3.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/3D.png")));
        } else if (card.ordinal() == (DECK.HEART_3.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/3H.png")));
        } else if (card.ordinal() == (DECK.SPADE_3.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/3S.png")));
        } else if (card.ordinal() == (DECK.CLUB_4.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/4C.png")));
        } else if (card.ordinal() == (DECK.DIAMOND_4.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/4D.png")));
        } else if (card.ordinal() == (DECK.HEART_4.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/4H.png")));
        } else if (card.ordinal() == (DECK.SPADE_4.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/4S.png")));
        } else if (card.ordinal() == (DECK.CLUB_5.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/5C.png")));
        } else if (card.ordinal() == (DECK.DIAMOND_5.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/5D.png")));
        } else if (card.ordinal() == (DECK.HEART_5.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/5H.png")));
        } else if (card.ordinal() == (DECK.SPADE_5.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/5S.png")));
        } else if (card.ordinal() == (DECK.CLUB_6.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/6C.png")));
        } else if (card.ordinal() == (DECK.DIAMOND_6.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/6D.png")));
        } else if (card.ordinal() == (DECK.HEART_6.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/6H.png")));
        } else if (card.ordinal() == (DECK.SPADE_6.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/6S.png")));
        } else if (card.ordinal() == (DECK.CLUB_7.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/7C.png")));
        } else if (card.ordinal() == (DECK.DIAMOND_7.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/7D.png")));
        } else if (card.ordinal() == (DECK.HEART_7.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/7H.png")));
        } else if (card.ordinal() == (DECK.SPADE_7.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/7S.png")));
        } else if (card.ordinal() == (DECK.CLUB_8.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/8C.png")));
        } else if (card.ordinal() == (DECK.DIAMOND_8.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/8D.png")));
        } else if (card.ordinal() == (DECK.HEART_8.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/8H.png/")));
        } else if (card.ordinal() == (DECK.SPADE_8.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/8S.png/")));
        } else if (card.ordinal() == (DECK.CLUB_9.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/9C.png/")));
        } else if (card.ordinal() == (DECK.DIAMOND_9.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/9D.png/")));
        } else if (card.ordinal() == (DECK.HEART_9.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/9H.png/")));
        } else if (card.ordinal() == (DECK.SPADE_9.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/9S.png/")));
        } else if (card.ordinal() == (DECK.CLUB_10.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/10C.png/")));
        } else if (card.ordinal() == (DECK.DIAMOND_10.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/10D.png/")));
        } else if (card.ordinal() == (DECK.HEART_10.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/10H.png/")));
        } else if (card.ordinal() == (DECK.SPADE_10.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/10S.png/")));
        } else if (card.ordinal() == (DECK.CLUB_JACK.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/JC.png/")));
        } else if (card.ordinal() == (DECK.DIAMOND_JACK.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/JD.png/")));
        } else if (card.ordinal() == (DECK.HEART_JACK.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/JH.png/")));
        } else if (card.ordinal() == (DECK.SPADE_JACK.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/JS.png/")));
        } else if (card.ordinal() == (DECK.CLUB_QUEEN.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/QC.png/")));
        } else if (card.ordinal() == (DECK.DIAMOND_QUEEN.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/QD.png/")));
        } else if (card.ordinal() == (DECK.HEART_QUEEN.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/QH.png/")));
        } else if (card.ordinal() == (DECK.SPADE_QUEEN.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/QS.png/")));
        } else if (card.ordinal() == (DECK.CLUB_KING.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/KC.png/")));
        } else if (card.ordinal() == (DECK.DIAMOND_KING.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/KD.png/")));
        } else if (card.ordinal() == (DECK.HEART_KING.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/KH.png/")));
        } else if (card.ordinal() == (DECK.SPADE_KING.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/KS.png/")));
        } else if (card.ordinal() == (DECK.CLUB_ACE.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/AC.png/")));
        } else if (card.ordinal() == (DECK.DIAMOND_ACE.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/AD.png/")));
        } else if (card.ordinal() == (DECK.HEART_ACE.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/AH.png/")));
        } else if (card.ordinal() == (DECK.SPADE_ACE.ordinal())) {
            label.setIcon(new ImageIcon(getClass().getResource("/cards/AS.png/")));
        }
        frame.setSize(751, 701);
        frame.setSize(750, 700);
    }

    public void playerBust(boolean over21) {
        if (myGame.curPoints(playerLabels) > 21) {
            JFrame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "You bust!");
        }
        if (myGame.curPoints(playerLabels) == 21) {
            JFrame parent1 = new JFrame();
            JOptionPane.showMessageDialog(parent1, "You win!");
            deal.setVisible(true);
            stay.setVisible(false);
            hit.setVisible(false);
        }
    }

    public void dealerBust(boolean over21) {
        if (myGame.curPoints(dealerLabels) > 21) {
            JOptionPane parent = new JOptionPane();
            JOptionPane.showMessageDialog(null, "You win!");

        }
        if (myGame.curPoints(dealerLabels) == 21) {
            JOptionPane parent1 = new JOptionPane();
            JOptionPane.showMessageDialog(null, "You lose!");

            deal.setVisible(true);
            stay.setVisible(false);
            hit.setVisible(false);
        }
    }

    private void blankCards() {
        pslot1.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));
        pslot2.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));
        pslot3.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));
        pslot4.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));
        pslot5.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));
        dslot1.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));
        dslot2.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));
        dslot3.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));
        dslot4.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));
        dslot5.setIcon(new ImageIcon(BlackjackGui.class.getResource("/cards/purple_back.png/")));
    }    
}
