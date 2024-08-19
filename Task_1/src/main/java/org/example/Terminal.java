package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {

    public void run() {
        TerminalLogic terminalLogic = new TerminalLogic();
        terminalLogic.commandProcessing();
    }

}
