package org.example.service;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileRepository {
    private final String _filePath = "src/main/resources/expenses.json";

    public void SaveFile(JSONArray array)
    {
        try (FileWriter file = new FileWriter(_filePath)) {
            file.write(array.toJSONString());
            file.flush();
            System.out.println("Pomyślnie zapisano plik JSON!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONArray ReadFile()
    {
        Path filePath = Path.of(_filePath);

        if (Files.notExists(filePath)) {
            return new JSONArray();
        }

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(_filePath)) {
            Object obj = parser.parse(reader);
            JSONArray data = (JSONArray) obj;
            return data;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
