package MySql;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class EntscheidungsfensterClass {

    public static void main(String[] args) {
        showDialogs();
    }

    public static void showDialogs() {
        JOptionPane.showConfirmDialog(null, "Eine Meldung");

        ImageIcon icon = new ImageIcon("bild.jpg");
        int antwort = JOptionPane.showConfirmDialog(null, "Eine Meldung", "Meldung", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, icon);

        if (antwort == JOptionPane.OK_OPTION) {
            System.out.println("Alles ok!");
        } else if (antwort == JOptionPane.NO_OPTION) {
            System.out.println("Nichts ist ok!");
        } else if (antwort == JOptionPane.CANCEL_OPTION) {
            System.out.println("Abbruch!");
        } else if (antwort == JOptionPane.CLOSED_OPTION) {
            System.out.println("Fenster geschlossen!");
        }
    }
}