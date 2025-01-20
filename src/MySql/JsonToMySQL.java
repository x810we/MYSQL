package MySql;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JsonToMySQL {

    public static void main(String[] args) {
        String jsonFilePath = "/Users/x810we/Temp/conversations.json"; // Pfad zur JSON-Datei
        String jdbcUrl = "jdbc:mysql://localhost:3306/HausHalt"; // Datenbank-URL
        String dbUser = "root"; // Datenbank-Benutzername
        String dbPassword = "soswind22"; // Datenbank-Passwort

        try {
            // Lese die JSON-Datei
            List<Map<String, Object>> conversations = readConversationsFromJson(jsonFilePath);

            // Verbindung zur Datenbank herstellen
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                // Konversationen in die Datenbank einfügen
                insertConversationsIntoDatabase(conversations, connection);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Map<String, Object>> readConversationsFromJson(String filePath) throws Exception {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());
        }
    }

    private static void insertConversationsIntoDatabase(List<Map<String, Object>> conversations, Connection connection) {
        String insertSql = "INSERT INTO conversations (id, createdAt, lastUpdatedAt) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
            for (Map<String, Object> conversation : conversations) {
                String id = (String) conversation.get("id");
                String createdAt = (String) conversation.get("createdAt");
                String lastUpdatedAt = (String) conversation.get("lastUpdatedAt");

                // Debugging: Zeige fehlende Felder an
                if (id == null) {
                    System.out.println("Warnung: 'id' fehlt in einer Konversation.");
                    continue;
                }

                statement.setString(1, id);
                statement.setString(2, createdAt);
                statement.setString(3, lastUpdatedAt);
                statement.addBatch();
            }
            statement.executeBatch();
            System.out.println("Konversationen erfolgreich in die Datenbank eingefügt.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
