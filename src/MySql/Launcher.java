package MySql;

import javax.swing.SwingUtilities;
public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               // JFrameOne main0 = new JFrameOne();
                MainFrame mF1 = new MainFrame();
                mF1.show();

                MainFrameFlow mF2 = new MainFrameFlow();
                mF2.showl();

                MainFrameGrid mF3 = new MainFrameGrid();
                mF3.showl();
               // main0.show(true);
               // MainWindow main = new MainWindow();
               // main.show();

            }
        });
    }
}