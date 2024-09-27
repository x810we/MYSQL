package MySql;

import java.awt.EventQueue;
public class LauncherEvent {
    public static void main(String[] args) {
    // Run this program on the Event Dispatch Thread (EDT)
    EventQueue. invokeLater(new Runnable(){
        public void run() {
            MainFrame frame = new MainFrame();
            frame.show();
         }
         }) ;
    }
}