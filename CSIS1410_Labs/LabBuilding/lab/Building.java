package lab;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * @author Kamdon Bird
 *
 */
@SuppressWarnings("serial")
public class Building extends JPanel {
    
    @Override
    protected void paintComponent(Graphics g) {
        Color[] colors = {Color.BLACK, Color.PINK, Color.CYAN, Color.GREEN};
        Random rand = new Random();
        super.paintComponent(g);
        int x = 30;
        int y = 20;
        g.setColor(Color.BLUE);
        g.fillRect(10, 10, 190, 400);
        g.setColor(colors[rand.nextInt(colors.length)]);
        for(int j = 0; j < 13; j++) {
            for(int i = 0; i < 6; i++) {
                g.setColor(colors[rand.nextInt(colors.length)]);
                g.fillRect(20 + (i * x), y, 20, 20);
            }
        y += 30;
        }
    }
}