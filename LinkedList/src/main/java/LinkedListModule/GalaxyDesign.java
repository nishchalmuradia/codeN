package LinkedListModule;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GalaxyDesign extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        // Set the background color to black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        // Draw the stars
        for (int i = 0; i < 500; i++) {
            int x = (int)(Math.random() * width);
            int y = (int)(Math.random() * height);
            int size = (int)(Math.random() * 3) + 1;
            g.setColor(Color.WHITE);
            g.fillOval(x, y, size, size);
        }

        // Draw the spiral arms of the galaxy
        int centerX = width / 2;
        int centerY = height / 2;
        int armWidth = 20;
        int armLength = 400;
        int numPoints = 300;
        double angleStep = Math.PI / (2 * numPoints);
        double angle = 0;
        int[] xPoints = new int[numPoints];
        int[] yPoints = new int[numPoints];
        for (int i = 0; i < numPoints; i++) {
            int x = (int)(centerX + (armLength * Math.cos(angle)) * Math.cos(angle));
            int y = (int)(centerY + (armLength * Math.cos(angle)) * Math.sin(angle));
            xPoints[i] = x;
            yPoints[i] = y;
            angle += angleStep;
        }
        g.setColor(new Color(128, 0, 128)); // purple color
        for (int i = 0; i < numPoints - 1; i++) {
            g.drawLine(xPoints[i], yPoints[i], xPoints[i + 1], yPoints[i + 1]);
            g.drawLine(xPoints[i], height - yPoints[i], xPoints[i + 1], height - yPoints[i + 1]);
        }

        // Draw the moon
        int moonRadius = 50;
        int moonX = centerX + armLength - moonRadius - 50;
        int moonY = centerY - moonRadius - 50;
        g.setColor(Color.GRAY);
        g.fillOval(moonX, moonY, moonRadius * 2, moonRadius * 2);
        g.setColor(Color.WHITE);
        g.fillOval(moonX + moonRadius / 2, moonY + moonRadius / 2, moonRadius, moonRadius);
    }

    public static void main(String[] args) {
        GalaxyDesign galaxy = new GalaxyDesign();
        JFrame frame = new JFrame("Galaxy Design");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(galaxy);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
