package org.example;

import org.example.cli.TrackerCLI;
import org.example.service.models.ExpenseRecord;
import org.example.service.DataConverter;
import org.example.service.JsonFileRepository;
import picocli.CommandLine;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new TrackerCLI()).execute(args);
        System.exit(exitCode);

//        -----------------------------------------
        var jsonFileRepository = new JsonFileRepository();
        var dataConverter = new DataConverter();

        var w = jsonFileRepository.ReadFile();
        var y = dataConverter.JSONArrayToData(w);

        for(var t : y)
        {
            System.out.println(t.Amount + " " + t.Description + " " + t.ExpenseDateTime);
        }

        var temp = new ArrayList<ExpenseRecord>();
        for (int i = 1; i <= 10; i++) {
            var t = new ExpenseRecord();
            t.ExpenseDateTime = LocalDateTime.now();
            t.Description = "wydatek nr." + i;
            t.Amount = i * 100;

            temp.add(t);
        }

        var e = dataConverter.DataToJSONArray(temp);
        jsonFileRepository.SaveFile(e);

    }
}

// TODO: musze zrobic JSON Array jako głowny element w weenątrz JSON object