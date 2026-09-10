package org.example.cli.commands;

import org.example.services.ConsolePrinter;
import org.example.services.ExpenseService;
import org.example.services.models.ExpenseRecord;
import org.example.services.models.Result;
import picocli.CommandLine;

import java.util.List;

@CommandLine.Command(name = "list", description = "Display the list of all expenses")
public class ListCommand implements Runnable {
    @CommandLine.Option(names = {"-m", "--month"}, required = false, description = "Month number (1-12) to list expenses for")
    private int monthNumber = -1;

    @Override
    public void run() {

        var expenseService = new ExpenseService();
        Result result = null;

        if(monthNumber == -1)
        {
            result = expenseService.ListAllAction();
        }else
        {
            result = expenseService.ListMonthAction(monthNumber);
        }

        if(result.success())
        {
            var printer = new ConsolePrinter();
            printer.PrintTable((List<ExpenseRecord>) result.data());
        }else
        {
            System.out.println(result.message());
        }

    }
}