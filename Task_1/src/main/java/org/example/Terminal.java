package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {

    public static void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            TerminalLogic terminalLogic = new TerminalLogic();
            while (!(terminalLogic.command.equalsIgnoreCase(terminalLogic.EXIT))) {
                terminalLogic.command = reader.readLine();
                terminalLogic.commandProcessing(terminalLogic.command);
            }
        } catch (IOException ignore){}
    }

}
