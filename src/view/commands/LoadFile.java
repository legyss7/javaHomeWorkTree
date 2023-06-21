package view.commands;

import view.ConsoleUI;

public class LoadFile implements Command{
    private ConsoleUI consoleUI;

    public LoadFile(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }
    @Override
    public String getDescription() {
        return "Загрузить данные";
    }

    @Override
    public void execute() {
        consoleUI.loadFile();
    }
}
