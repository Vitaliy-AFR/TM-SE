package org.example.commands;

import org.example.TerminalLogic;

public class DeleteTaskProject implements Commands{
    @Override
    public String nameOfCommand() {
        return "delete task";
    }

    @Override
    public String description() {
        return "Удалить задачу";
    }

    @Override
    public void execute(TerminalLogic terminalLogic) {

    }
}
