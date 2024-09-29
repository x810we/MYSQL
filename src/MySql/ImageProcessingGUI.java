package MySql;

import java.io.IOException;

public class ImageProcessingGUI {

    // Methode zum Starten des externen Programms
    public void startDatabaseProgram() {
        String command = "java -jar /Users/x810we/IdeaProjects/MySql/out/artifacts/MySql_jar/MySql.jar";

        try {
            // Startet das externe Programm
            Process process = Runtime.getRuntime().exec(command);
            // Wartet, bis das Programm beendet ist
            int exitCode = process.waitFor();
            System.out.println("Programm beendet mit Exit-Code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Beispiel zur Integration in deinen Button-Event-Listener
    public static void main(String[] args) {
        ImageProcessingGUI gui = new ImageProcessingGUI();

        // Simuliert das Drücken eines Buttons
        gui.startDatabaseProgram();
    }
}
