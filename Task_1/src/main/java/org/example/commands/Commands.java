package org.example.commands;

import org.example.TerminalLogic;

import java.util.Scanner;

public abstract class Commands {
    public abstract String nameOfCommand();
    public abstract String description();
    public abstract void execute();


    protected final String INCORRECT_ANSWER = "Некорректный ответ";

}
