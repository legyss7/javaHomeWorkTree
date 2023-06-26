package model;

import model.dataSave.InterfaceIO;
import model.human.Gender;
import model.human.Human;
import java.time.LocalDate;
import java.util.Map;

public class Service {
    private FamilyTree<Human> tree;
    private String fileName;
    private InterfaceIO interfaceIO;

    public Service(InterfaceIO interfaceIO) {
        tree = new FamilyTree<>();
        fileName = "src/model/dataSave/data.txt";
        this.interfaceIO = interfaceIO;
    }



    public void addHuman(Map<String, String> infoHuman) {
        Gender gender;
        if (infoHuman.get("gender") == "1") {
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
        LocalDate localDate = LocalDate.parse(infoHuman.get("year")
                + infoHuman.get("month") + infoHuman.get("day"));

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

    public String loadFile() {
        tree = (FamilyTree<Human>) interfaceIO.readFile(fileName);
        return tree.getInfoFamilyTree();
    }

    public void saveFile() {
        interfaceIO.saveFile(tree, fileName);

    }
}
