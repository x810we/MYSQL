package MySql;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class ConversationImporter {

    // MySQL-Verbindungsdetails
    private static final String DB_URL = "jdbc:mysql://localhost:3306/HausHalt";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "soswind22";

    public static void main(String[] args) {
        String jsonFilePath = "/Users/x810we/Temp/conversations.json"; // Pfad zur JSON-Datei

        try {
            // JSON-Daten laden
            List<Map<String, Object>> conversations = parseJsonFile(jsonFilePath);

            // Daten in die MySQL-Datenbank übertragen
            insertConversationsIntoDatabase(conversations);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Map<String, Object>> parseJsonFile(String filePath) throws IOException {
        // JSON-Datei einlesen und parsen
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
            return gson.fromJson(reader, listType);
        }
    }

    private static void insertConversationsIntoDatabase(List<Map<String, Object>> conversations) {
        String insertSQL = "INSERT INTO conversations (conversation_id, timestamp, message) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            for (Map<String, Object> conversation : conversations) {
                // Extrahiere die Conversation-ID
                String conversationId = (String) conversation.get("id");

                // Extrahiere die Nachrichtenliste (falls vorhanden)
                List<Map<String, Object>> messages = (List<Map<String, Object>>) conversation.get("messages");

                if (messages == null || messages.isEmpty()) {
                    System.out.println("Keine Nachrichten in der Unterhaltung mit ID: " + conversationId);
                    continue; // Überspringe diese Unterhaltung
                }

                for (Map<String, Object> message : messages) {
                    String timestamp = (String) message.get("timestamp");
                    String content = (String) message.get("content");

                    // Füge den Eintrag in die Datenbank ein
                    pstmt.setString(1, conversationId);
                    pstmt.setString(2, timestamp);
                    pstmt.setString(3, content);

                    pstmt.executeUpdate();
                }
            }

            System.out.println("Daten erfolgreich importiert!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertConversationsIntoDatabase(List<Map<String, Object>> conversations, Connection connection) {
        String insertSql = "INSERT INTO conversations (id, createdAt, lastUpdatedAt) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
            for (Map<String, Object> conversation : conversations) {
                String id = (String) conversation.get("id");
                String createdAt = (String) conversation.get("createdAt");
                String lastUpdatedAt = (String) conversation.get("lastUpdatedAt");

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
