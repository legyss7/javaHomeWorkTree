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
        System.out.print(text);
    }

    @Override
    public void start() {
        print("Приветствие\n");
        while (work) {
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                System.out.println("Ошибка ввода\n");
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
        print("Приятно было поработать)\n");
        work = false;
    }

    public void addHuman() {
        Map<String, String> infoHuman = new HashMap<>();

        print("Введите имя: ");
        infoHuman.put("name", scanner.nextLine());
        print("Введите фамилию: ");
        infoHuman.put("surname", scanner.nextLine());
        print("Пол (муж - 1, жен - 2): ");
        infoHuman.put("gender", scanner.nextLine());
        print("Введите дату рождения \n");
        print("Год: ");
        infoHuman.put("year", scanner.nextLine());
        print("Месяц (цифрой): ");
        infoHuman.put("month", scanner.nextLine());
        print("Число (месяца): ");
        infoHuman.put("day", scanner.nextLine());
        print("Введите имя отца: ");
        infoHuman.put("fatherName", scanner.nextLine());
        print("Введите фамилию отца: ");
        infoHuman.put("fatherSurname", scanner.nextLine());
        print("Введите имя матери: ");
        infoHuman.put("motherName", scanner.nextLine());
        print("Введите фамилию матери: ");
        infoHuman.put("motherSurname", scanner.nextLine());
        print("Введите имя супруа (-ги): ");
        infoHuman.put("spouseName", scanner.nextLine());
        print("Введите фамилию супруа (-ги): ");
        infoHuman.put("spouseSurname", scanner.nextLine());

        System.out.println();
        if (infoHuman.get("name") != "" && infoHuman.get("surname") != "") {
            presenter.addHuman(infoHuman);
            print("Запись добавлена \n");
        } else {
            print("Ошибка Ввода!\n");
            print("Поля: Имя и Фамилия являются обязательными!\n");
            print("Попробуйте снова!\n");
        }
    }

    public void getHuman() {
        Map<String, String> infoHuman = new HashMap<>();
        print("Поиск человека\n");
        print("Введите имя: ");
        infoHuman.put("name", scanner.nextLine());
        print("Введите фамилию: ");
        infoHuman.put("surname", scanner.nextLine());
        print(presenter.getNote(infoHuman));
    }

    public void loadFile(){
        print(presenter.loadFile());
        print("Данные загружены \n");
    }

    public void saveFile(){
        presenter.saveFile();
        print("Данные сохранены \n");
    }

    public void getAllNote() {
        print(presenter.getAllNote());
    }
}
