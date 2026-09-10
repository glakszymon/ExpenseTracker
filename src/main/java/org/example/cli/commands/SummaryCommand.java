package org.example.cli.commands;

import org.example.services.ExpenseService;
import picocli.CommandLine;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

@CommandLine.Command(name = "summary", description = "Display the total sum of expenses")
public class SummaryCommand implements Runnable {
    @CommandLine.Option(names = {"-m", "--month"}, required = false, description = "Month number (1-12) to calculate expenses for")
    private int monthNumber = -1;

    @Override
    public void run() {

        var expenseService = new ExpenseService();

        if(monthNumber == -1)
        {
            var result = expenseService.SummaryAllAction();
            if(result.success())
            {
                System.out.println("Total expenses: " + result.data());
                return;
            }

            System.out.println(result.message());
        }else
        {
            var result = expenseService.SummaryMonthAction(monthNumber);

            if(result.success())
            {
                String monthName = Month.of( monthNumber ).getDisplayName( TextStyle.FULL , Locale.ENGLISH );
                System.out.println("Total expenses for "+ monthName +": " + result.data());
                return;
            }

            System.out.println(result.message());
        }

    }
}