package MySql;

import javax.swing.*;
import java.awt.GridLayout;

public class MainFrameGrid {
    private JFrame frame;
    private JPanel panel;

    public MainFrameGrid() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("GridLayout Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        panel = new JPanel(new GridLayout(4,5,10,10));
        for (int i = 1; i <= 20; i++) {
            JButton button = new JButton("Button " + Integer.toString(i));
            panel.add(button);
            frame.add(panel);

            frame.pack();
            frame.setVisible(true);
        }
    }
    public void showl() {
        this. frame.setVisible(true);
    }

}