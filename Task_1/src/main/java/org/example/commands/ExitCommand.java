package org.example.commands;

public class ExitCommand extends Commands {
    @Override
    public String description() {
        return "Закрыть программу";
    }

    @Override
    public String nameOfCommand() {
        return "exit";
    }

    @Override
    public void execute() {
        System.out.println("Завершение работы");
        System.exit(0);

    }
}
