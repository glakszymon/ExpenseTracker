package org.example.cli.commands;

import org.example.services.ExpenseService;
import picocli.CommandLine;

@CommandLine.Command(name = "add", description = "Add a new expense")
public class AddExpenseCommand implements Runnable {
    @CommandLine.Option(names = {"-a", "--amount"}, required = true, description = "Expense amount")
    private int amount;

    @CommandLine.Option(names = {"-d", "--description"}, required = true, description = "Expense description")
    private String description;

    @Override
    public void run() {
        var expenseService = new ExpenseService();
        var result = expenseService.AddAction(description, amount);
        if(result.success())
        {
            System.out.println("Expense added successfully (ID: "+ result.data().Id + ")");
        }else
        {
            System.out.println("Expense adding failed:" + result.message());
        }
    }
}