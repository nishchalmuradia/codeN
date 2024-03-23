package LinkedListModule;

import java.awt.Color;
        import java.awt.Graphics;
        import javax.swing.JFrame;
        import javax.swing.JPanel;

public class IndianFlag extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();

        // Draw the background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Draw the saffron color on the top
        g.setColor(new Color(255, 153, 51));
        g.fillRect(0, 0, width, height/3);

        // Draw the green color at the bottom
        g.setColor(new Color(19, 136, 8));
        g.fillRect(0, 2*height/3, width, height/3);

        // Draw the wheel in the center
        int cx = width/2;
        int cy = height/2;
        int radius = height/5;
        int chakraRadius = 0;

        // Calculate the radius of the chakra
        chakraRadius = (int)(0.15 * radius);

        // Draw the navy blue circle for the chakra
        g.setColor(new Color(0, 51, 153));
        g.fillOval(cx-radius, cy-radius, 2*radius, 2*radius);

        // Draw the 24 spokes of the chakra
        g.setColor(Color.WHITE);
        for (int i=0; i<24; i++) {
            double angle = i * Math.PI / 12;
            int x1 = (int)(cx + (radius-chakraRadius) * Math.cos(angle));
            int y1 = (int)(cy + (radius-chakraRadius) * Math.sin(angle));
            int x2 = (int)(cx + radius * Math.cos(angle));
            int y2 = (int)(cy + radius * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
        }

        // Draw the center of the chakra
        g.setColor(Color.WHITE);
        g.fillOval(cx-chakraRadius, cy-chakraRadius, 2*chakraRadius, 2*chakraRadius);
    }

    public static void main(String[] args) {
        IndianFlag flag = new IndianFlag();
        JFrame frame = new JFrame("Indian Flag");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(flag);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
