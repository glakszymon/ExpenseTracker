package org.example.cli.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "list", description = "Display the list of all expenses")
public class ListCommand implements Runnable {
    @Override
    public void run() {
        // TODO: dodaj logikę wyświetlania listy wydatków
        System.out.println("Użyto komendy na listę wydatków");
    }
}