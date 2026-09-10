package org.example.services;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import org.example.services.models.ExpenseRecord;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static com.github.freva.asciitable.HorizontalAlign.CENTER;
import static com.github.freva.asciitable.HorizontalAlign.LEFT;

public class ConsolePrinter {

    public void PrintTable(List<ExpenseRecord> data) {

        String table = TablePrep(data);
        System.out.println(table);
    }

    private String TablePrep(List<ExpenseRecord> data)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return AsciiTable.getTable(AsciiTable.BASIC_ASCII_NO_DATA_SEPARATORS, data, Arrays.asList(
                new Column()
                        .header("ID")
                        .headerAlign(CENTER)
                        .dataAlign(CENTER)
                        .with(e -> String.valueOf(e.Id)),
                new Column()
                        .header("Description")
                        .headerAlign(CENTER)
                        .dataAlign(LEFT)
                        .with(e -> e.Description),
                new Column()
                        .header("Amount")
                        .headerAlign(CENTER)
                        .dataAlign(CENTER)
                        .with(e -> e.Amount + ""),
                new Column()
                        .header("Date")
                        .headerAlign(CENTER)
                        .dataAlign(LEFT)
                        .with(e -> e.ExpenseDateTime.format(formatter))
        ));

    }
}