package org.example.commands;

public abstract class Commands {
    public abstract String nameOfCommand();
    public abstract String description();
    public abstract void execute();

    protected final String INCORRECT_ANSWER = "Некорректный ответ";
    protected final String NO = "no";
    protected final String YES = "yes";

}
