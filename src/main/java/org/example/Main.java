package org.example;

import org.example.cli.TrackerCLI;
import picocli.CommandLine;

public class Main {
    static void main(String[] args) {
        int exitCode = new CommandLine(new TrackerCLI()).execute(args);
        System.exit(exitCode);
    }
}