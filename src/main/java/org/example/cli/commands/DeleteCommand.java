package org.example.cli.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "delete", description = "Delete an expense by its ID")
public class DeleteCommand implements Runnable {
    @CommandLine.Option(names = {"--id"}, required = true, description = "ID of the expense to delete")
    private int id;

    @Override
    public void run() {
        // TODO: dodaj tutaj logikę usuwania elementów
        System.out.println("Użyto komendy na USUWANIE elementu");
    }
}