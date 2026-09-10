package org.example.cli;

import org.example.cli.commands.AddExpenseCommand;
import org.example.cli.commands.DeleteCommand;
import org.example.cli.commands.ListCommand;
import org.example.cli.commands.SummaryCommand;
import picocli.CommandLine;

@CommandLine.Command(
        name = "expenses",
        mixinStandardHelpOptions = true,
        description = "Menedżer wydatków CLI",
        subcommands = {
                AddExpenseCommand.class,
                ListCommand.class,
                SummaryCommand.class,
                DeleteCommand.class
        }
)
public class TrackerCLI implements Runnable {

    @Override
    public void run() {
        System.out.println("Użyj --help, aby zobaczyć dostępne polecenia.");
    }
}
