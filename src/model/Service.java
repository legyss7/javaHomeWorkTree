package model;

import model.dataSave.FileHandler;
import model.dataSave.InterfaceIO;
import model.human.Gender;
import model.human.Human;
import java.time.LocalDate;
import java.util.Map;

public class Service {
    FamilyTree<Human> tree;

    public Service() {
        tree = new FamilyTree<>();
    }

    public void addHuman(Map<String, String> infoHuman) {
        Gender gender;
        if (infoHuman.get("gender") == "1") {
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
        LocalDate localDate;
        String date;
        if (infoHuman.get("year") != "" && infoHuman.get("month") != "" && infoHuman.get("day") != "") {
            String month = infoHuman.get("month");
            String day = infoHuman.get("day");
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
            date = infoHuman.get("year") + month + day;

        } else {
            date = "1111-11-11";
        }
        localDate = LocalDate.parse(date);

        tree.add(new Human(infoHuman.get("name"), infoHuman.get("surname"), gender,
                localDate, tree.getByHuman(infoHuman.get("fatherName"), infoHuman.get("fatherSurname")),
                tree.getByHuman(infoHuman.get("motherName"), infoHuman.get("motherSurname")),
                tree.getByHuman(infoHuman.get("spouseName"), infoHuman.get("spouseSurname"))));

        if (infoHuman.get("spouseName") != "" && infoHuman.get("spouseSurname") != "") {
            tree.getByHuman(infoHuman.get("spouseName"), infoHuman.get("spouseSurname"))
                    .setSpouse(tree.getByHuman(infoHuman.get("name"), infoHuman.get("surname")));
        }
    }

    public String getHuman(Map<String, String> infoHuman) {
        Human human = tree.getByHuman(infoHuman.get("name"), infoHuman.get("surname"));
        if (human == null) {
            return "Человек ненайден!\n";
        }
        return human.getInfoHumanFull();
    }

    public String getInfoFamilyTree() {
        return tree.getInfoFamilyTree();
    }

    public void loadFile() {
        String fileName = "src/model/dataSave/data.txt";
        InterfaceIO interfaceIO = new FileHandler();
        tree = (FamilyTree) interfaceIO.readFile(fileName);
        System.out.println(tree.getInfoFamilyTree());
        System.out.println("Данные загружены \n");
    }

    public void saveFile() {
        String fileName = "src/model/dataSave/data.txt";
        InterfaceIO interfaceIO = new FileHandler();
        interfaceIO.saveFile(tree, fileName);
        System.out.println("Данные сохранены \n");
    }
}
