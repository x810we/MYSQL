package MySql;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JasonDebugger {
    public static void main(String[] args) {
        String jsonFilePath = "/Users/x810we/Temp/conversations.json"; // Pfad zur JSON-Datei

        try {
            // JSON-Daten laden
            Gson gson = new Gson();
            try (FileReader reader = new FileReader(jsonFilePath)) {
                Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
                List<Map<String, Object>> conversations = gson.fromJson(reader, listType);


                System.out.println("Anzahl der Unterhaltungen: " + conversations.size());

                for (Map<String, Object> conversation : conversations) {
                    System.out.println("Unterhaltung: " + conversation);

                    if (conversation.containsKey("messages")) {
                        System.out.println("Feld 'messages' vorhanden.");
                    } else {
                        System.out.println("Feld 'messages' fehlt.");
                    }


                    Object messages = conversation.get("messages");
                    if (messages == null) {
                        System.out.println("Keine Nachrichten gefunden!");
                    } else {
                        System.out.println("Nachrichten: " + messages);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
