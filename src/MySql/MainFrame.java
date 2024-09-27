package MySql;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame frame;
    private JPanel panel;

    public MainFrame() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("JButton Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));


        frame.add(panel, BorderLayout.CENTER);
    }

    public void show() {
        this.frame.setVisible(true);
    }
}
