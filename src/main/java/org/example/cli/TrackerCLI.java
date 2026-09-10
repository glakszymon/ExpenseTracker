package org.example.cli;

import org.example.cli.commands.*;
import picocli.CommandLine;

@CommandLine.Command(
        name = "expenses",
        mixinStandardHelpOptions = true,
        description = "Menedżer wydatków CLI",
        subcommands = {
                AddExpenseCommand.class,
                ListCommand.class,
                SummaryCommand.class,
                DeleteCommand.class,
                UpdateCommand.class
        }
)
public class TrackerCLI implements Runnable {

    @Override
    public void run() {
        System.out.println("Użyj --help, aby zobaczyć dostępne polecenia.");
    }
}
