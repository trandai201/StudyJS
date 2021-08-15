/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

/**
 *
 * @author nguyenducthao
 */
import java.awt.*;
import javax.swing.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class create_JFrame_with_PerPixelTranslucency extends JFrame {

    public create_JFrame_with_PerPixelTranslucency() {
        super("GradientTranslucentWindow");

        setBackground(new Color(0, 0, 0, 0));
        setSize(new Dimension(300, 200));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 240;
                    final int G = 240;
                    final int B = 240;

                    Paint p
                            = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
                                    0.0f, getHeight(), new Color(R, G, B, 255), true);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        setContentPane(panel);
        setLayout(new GridBagLayout());
        add(new JButton("I am a Button"));
    }

    public static void main(String[] args) {
        // Determine what the GraphicsDevice can support.
        GraphicsEnvironment ge
                = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        boolean isPerPixelTranslucencySupported
                = gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);

        //If translucent windows aren't supported, exit.
        if (!isPerPixelTranslucencySupported) {
            System.out.println(
                    "Per-pixel translucency is not supported");
            System.exit(0);
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                create_JFrame_with_PerPixelTranslucency myPerPixelTranslucency = new create_JFrame_with_PerPixelTranslucency();

                // Display the window.
                myPerPixelTranslucency.setVisible(true);
            }
        });
    }
}
