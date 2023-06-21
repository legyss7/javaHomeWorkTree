package view.commands;

import view.ConsoleUI;

public class GetHuman implements Command {
    private ConsoleUI consoleUI;

    public GetHuman(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Поиск человека";
    }

    @Override
    public void execute() {
        consoleUI.getHuman();
    }
}
