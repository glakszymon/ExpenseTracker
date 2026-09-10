package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileRepository {
    public void SaveFile(JSONArray array)
    {
        try (FileWriter file = new FileWriter("src/main/resources/expenses.json")) {
            file.write(array.toJSONString());
            file.flush();
            System.out.println("Pomyślnie zapisano plik JSON!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONArray ReadFile()
    {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/expenses.json")) {
            Object obj = parser.parse(reader);
            JSONArray data = (JSONArray) obj;
            return data;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
