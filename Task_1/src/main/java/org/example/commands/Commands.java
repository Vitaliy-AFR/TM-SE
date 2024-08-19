package org.example.commands;

import org.example.TerminalLogic;

public interface Commands {
    String nameOfCommand();
    String description();
    void execute(TerminalLogic terminalLogic);
}
