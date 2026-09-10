package org.example.cli.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "summary", description = "Display the total sum of expenses")
public class SummaryCommand implements Runnable {
    @CommandLine.Option(names = {"-m", "--month"}, required = false, description = "Month number (1-12) to calculate expenses for")
    private int monthNumber;

    @Override
    public void run() {
        // TODO: dodaj logikę sumowania listy wydatków
        System.out.println("Użyto komendy na SUMĘ wydatków");
    }
}