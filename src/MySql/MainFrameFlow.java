package MySql;

import javax.swing.*;
import java.awt.*;

public class MainFrameFlow{
    private JFrame frame;

    public MainFrameFlow() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Java Code Junkie - FlowLayout Demo");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel = new JPanel (new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground (Color.PINK);
        for (int i = 1; i <= 5; i++) {
            JButton button = new JButton("Button " + Integer.toString(i));
            panel. add (button);
        }

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        frame.add (panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void showl() {
        this. frame.setVisible(true);
    }
}