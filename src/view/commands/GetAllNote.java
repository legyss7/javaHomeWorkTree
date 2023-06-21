package view.commands;

import view.ConsoleUI;

public class GetAllNote implements Command {
    private ConsoleUI consoleUI;

    public GetAllNote(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Показать все записи";
    }

    @Override
    public void execute() {
        consoleUI.getAllNote();
    }
}
