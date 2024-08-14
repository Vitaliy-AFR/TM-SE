package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal extends Terminal_logic {

    public static void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(command.equalsIgnoreCase(EXIT))) {
                command = reader.readLine();
                commandProcessing(command);
            }
        } catch (IOException ignore){}
    }

}
