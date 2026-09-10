package org.example.services;

import org.example.services.models.ExpenseRecord;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConsolePrinter {

    private final String[] headers = {"ID", "Description", "Amount", "Date"};

    public void PrintTable(List<ExpenseRecord> data)
    {
        System.out.printf("%-5s %-20s %-7s %-10s%n", headers[0], headers[1], headers[2], headers[3]);
        for (var t : data)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            var finalDateString = t.ExpenseDateTime.format(formatter);

            System.out.printf("%-5s %-20s %-7s %-10s%n", t.Id, t.Description, t.Amount, finalDateString);
        }
    }
}

//TODO:Dynamicznie rysować tabele