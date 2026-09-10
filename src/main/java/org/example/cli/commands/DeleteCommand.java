package org.example.cli.commands;

import org.example.services.ExpenseService;
import picocli.CommandLine;

@CommandLine.Command(name = "delete", description = "Delete an expense by its ID")
public class DeleteCommand implements Runnable {
    @CommandLine.Option(names = {"--id"}, required = true, description = "ID of the expense to delete")
    private int id;

    @Override
    public void run() {
        var expenseService = new ExpenseService();
        var result = expenseService.DeleteAction(id);
        if(result.success())
        {
            System.out.println("Expense deleted successfully (ID: " + id + ")");
        }else
        {
            System.out.println("Expense deleting failed:" + result.message());
        }
    }
}