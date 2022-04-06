package datafile;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.json.simple.parser.JSONParser;

public class JsonParser {

    public static void insert_note(String filePath, String date, String text)
    {
        JSONObject json = new JSONObject();
        try {
            json.put(date, text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String load_note(String filePath, String key)
    {
        String value = "";
        JSONParser parser = new JSONParser();
        try
        {
            FileReader fileReader = new FileReader(filePath);
            JSONObject json = (JSONObject)parser.parse(fileReader);
            value = (String) json.get(key);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return value;
    }
}
