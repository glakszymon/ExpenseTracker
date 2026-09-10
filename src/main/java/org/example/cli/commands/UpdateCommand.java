package org.example.cli.commands;

import org.example.services.ExpenseService;
import picocli.CommandLine;

import java.time.format.DateTimeFormatter;

@CommandLine.Command(name = "update", description = "Update existing expense")
public class UpdateCommand implements Runnable{
    @CommandLine.Option(names = {"--id"}, required = true, description = "ID of updating expense")
    private int id;

    @CommandLine.Option(names = {"-a", "--amount"}, required = false, description = "Expense amount")
    private Integer amount;

    @CommandLine.Option(names = {"-d", "--description"}, required = false, description = "Expense description")
    private String description;

    @Override
    public void run()
    {
        var expenseService = new ExpenseService();
        var result = expenseService.UpdateAction(id, description, amount);

        if(result.success())
        {
            var rec = result.data();
            System.out.println("Update was successful");
            System.out.println(
                    "ID: " + rec.Id +
                    "\nDescription: " + rec.Description +
                    "\nAmount: " + rec.Amount +
                    "\nDate: " + rec.ExpenseDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }else
        {
            System.out.println(result.message());
        }
    }
}
