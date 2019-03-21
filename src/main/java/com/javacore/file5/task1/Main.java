package com.javacore.file5.task1;

import com.javacore.file5.task1.view.ConsoleView;

import java.util.Scanner;

/**
 * Application entry point.
 */
public class Main {

    public static void main(String[] args) {
        printHelp();
        startConsoleUI();
    }

    private static void printHelp() {
        System.out.println("cd [directory] - change directory;\n" +
                "ls - list files;\n" +
                "mk [file] - create empty file\n" +
                "rm [file] - remove file;\n" +
                "[file] - edit file;\n" +
                "help - show help;" +
                "stop - exit.\n");
    }

    private static void startConsoleUI() {
        final ConsoleView consoleView = new ConsoleView();
        final Scanner scanner = new Scanner(System.in);
        boolean start = true;

        while (start) {
            System.out.print(consoleView.getPath().toString() + ">");

            final String input = scanner.nextLine();

            final String[] argsArr = input.split(" ");
            final String command = argsArr[0];
            final String parameter = input.replace(command, "").trim();

            switch (command) {
                case "cd":
                    consoleView.changePath(parameter);
                    break;
                case "mk":
                    consoleView.createFile(parameter);
                    break;
                case "rm":
                    consoleView.deleteFile(parameter);
                    break;
                case "ls":
                    consoleView.listFiles();
                    break;
                case "help":
                    printHelp();
                    break;
                case "stop":
                    start = false;
                    break;
                default:
                    consoleView.editFile(command);
                    break;
            }
        }
    }
}