package org.example.cli.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "add", description = "Add a new expense")
public class AddExpenseCommand implements Runnable {
    @CommandLine.Option(names = {"-a", "--amount"}, required = true, description = "Expense amount")
    private int amount;

    @CommandLine.Option(names = {"-d", "--description"}, required = true, description = "Expense description")
    private String description;

    @Override
    public void run() {
        // TODO: Dodać logikę związaną z dodawaniem nowego wydatku
        System.out.println("Dodano wydatek: " + description + " na kwotę: " + amount + " zł");
    }
}