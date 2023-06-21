package view;

import presenter.Presenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
        presenter = new Presenter();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Приветствие");
        while (work) {
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                System.out.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)) {
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")) {
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }

    public void finish() {
        System.out.println("Приятно было поработать)");
        work = false;
    }

    public void addHuman() {
        Map<String, String> infoHuman = new HashMap<>();

        System.out.print("Введите имя: ");
        infoHuman.put("name", scanner.nextLine());
        System.out.print("Введите фамилию: ");
        infoHuman.put("surname", scanner.nextLine());
        System.out.print("Пол (муж - 1, жен - 2): ");
        infoHuman.put("gender", scanner.nextLine());
        System.out.println("Введите дату рождения ");
        System.out.print("Год: ");
        infoHuman.put("year", scanner.nextLine());
        System.out.print("Месяц (цифрой): ");
        infoHuman.put("month", scanner.nextLine());
        System.out.print("Число (месяца): ");
        infoHuman.put("day", scanner.nextLine());
        System.out.print("Введите имя отца: ");
        infoHuman.put("fatherName", scanner.nextLine());
        System.out.print("Введите фамилию отца: ");
        infoHuman.put("fatherSurname", scanner.nextLine());
        System.out.print("Введите имя матери: ");
        infoHuman.put("motherName", scanner.nextLine());
        System.out.print("Введите фамилию матери: ");
        infoHuman.put("motherSurname", scanner.nextLine());
        System.out.print("Введите имя супруа (-ги): ");
        infoHuman.put("spouseName", scanner.nextLine());
        System.out.print("Введите фамилию супруа (-ги): ");
        infoHuman.put("spouseSurname", scanner.nextLine());

        System.out.println();
        if (infoHuman.get("name") != "" && infoHuman.get("surname") != "") {
            presenter.addHuman(infoHuman);
        } else {
            System.out.println("Ошибка Ввода!");
            System.out.println("Поля: Имя и Фамилия являются обязательными!");
            System.out.println("Попробуйте снова!\n");
        }
    }

    public void getHuman() {
        Map<String, String> infoHuman = new HashMap<>();
        System.out.println("Поиск человека");
        System.out.print("Введите имя: ");
        infoHuman.put("name", scanner.nextLine());
        System.out.print("Введите фамилию: ");
        infoHuman.put("surname", scanner.nextLine());
        presenter.getNote(infoHuman);
    }

    public void getAllNote() {
        presenter.getAllNote();
    }
}
