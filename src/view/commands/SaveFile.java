package view.commands;

import view.ConsoleUI;

public class SaveFile implements Command {
    private ConsoleUI consoleUI;

    public SaveFile(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Сохранить данные";
    }

    @Override
    public void execute() {
        consoleUI.saveFile();
    }
}
