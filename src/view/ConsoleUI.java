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

    private Map<String, String> infoDataHuman;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
        presenter = new Presenter();
        infoDataHuman = new HashMap<>();
    }

    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void start() {
        print("Приветствие\n");
        while (work) {
            print(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                print("Ошибка ввода\n");
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
        inputDataHuman();
        if (checkInputDataHumanName()) {
            if (checkInputDataHumanDate()) {
                presenter.addHuman(infoDataHuman);
                print("Запись добавлена \n");
            }
            else{
                print("Ошибка Ввода даты рождения!\n");
                print("Попробуйте снова!\n");
            }
        }
        else {
            print("Ошибка Ввода!\n");
            print("Поля: Имя и Фамилия являются обязательными!\n");
            print("Попробуйте снова!\n");
        }
        print("\n");
    }

    private void inputDataHuman() {
        print("Введите имя: ");
        infoDataHuman.put("name", scanner.nextLine());
        print("Введите фамилию: ");
        infoDataHuman.put("surname", scanner.nextLine());
        print("Пол (муж - 1, жен - 2): ");
        infoDataHuman.put("gender", scanner.nextLine());
        print("Введите дату рождения \n");
        print("Год: ");
        infoDataHuman.put("year", scanner.nextLine());
        print("Месяц (цифрой): ");
        infoDataHuman.put("month", scanner.nextLine());
        print("Число (месяца): ");
        infoDataHuman.put("day", scanner.nextLine());
        print("Введите имя отца: ");
        infoDataHuman.put("fatherName", scanner.nextLine());
        print("Введите фамилию отца: ");
        infoDataHuman.put("fatherSurname", scanner.nextLine());
        print("Введите имя матери: ");
        infoDataHuman.put("motherName", scanner.nextLine());
        print("Введите фамилию матери: ");
        infoDataHuman.put("motherSurname", scanner.nextLine());
        print("Введите имя супруа (-ги): ");
        infoDataHuman.put("spouseName", scanner.nextLine());
        print("Введите фамилию супруа (-ги): ");
        infoDataHuman.put("spouseSurname", scanner.nextLine());
        print("\n");
    }

    private boolean checkInputDataHumanName() {
        boolean checkFlag = true;
        if (!(infoDataHuman.get("name") != ""
                && infoDataHuman.get("surname") != "")) {
            checkFlag = false;
        }
        return checkFlag;
    }

    private boolean checkInputDataHumanDate() {
        if (infoDataHuman.get("year") != "" && infoDataHuman.get("month") != "" && infoDataHuman.get("day") != "") {
            String year = infoDataHuman.get("year");
            String month = infoDataHuman.get("month");
            String day = infoDataHuman.get("day");
            if(Integer.parseInt(year) < 1000 || Integer.parseInt(year) > 10000){
                return false;
            }
            if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12) {
                return false;
            }
            if (Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31) {
                return false;
            }

            if (Integer.parseInt(month) < 10) {
                month = "-0" + month;
            } else {
                month = "-" + month;
            }
            if (Integer.parseInt(day) < 10) {
                day = "-0" + day;
            } else {
                day = "-" + day;
            }
            infoDataHuman.put("month", month);
            infoDataHuman.put("day", day);
            return true;
        } else {
            return false;
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

    public void loadFile() {
        print(presenter.loadFile());
        print("Данные загружены \n");
    }

    public void saveFile() {
        presenter.saveFile();
        print("Данные сохранены \n");
    }

    public void getAllNote() {
        print(presenter.getAllNote());
    }
}
