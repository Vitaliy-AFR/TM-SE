package org.example.commands;

import org.example.TerminalLogic;

public class ExitCommand implements Commands {
    @Override
    public String description() {
        return "Закрыть программу";
    }

    @Override
    public String nameOfCommand() {
        return "exit";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {
        System.out.println("Завершение работы");
        System.exit(0);

    }
}
