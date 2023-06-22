
import view.ConsoleUI;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();

//        FamilyTree<Human> tree = new FamilyTree<>();
//
//        Human PetrovIvan = new Human("Ivan", "Petrov", Gender.Male,
//                LocalDate.of(1960, 1, 1));
//        Human PetrovaAnna = new Human("Anna", "Petrova", Gender.Female,
//                LocalDate.of(1965, 10, 5));
//        PetrovIvan.setSpouse(PetrovaAnna);
//        PetrovaAnna.setSpouse(PetrovIvan);
//        tree.add(PetrovIvan);
//        tree.add(PetrovaAnna);
//
//        tree.add(new Human("Maksim", "Petrov", Gender.Male,
//                LocalDate.of(1980, 12, 11),
//                tree.getByHuman("Ivan", "Petrov"),
//                tree.getByHuman("Anna", "Petrova"), null));
//        tree.add(new Human("Marina", "Petrova", Gender.Female,
//                LocalDate.of(1985, 1, 13),
//                tree.getByHuman("Ivan", "Petrov"),
//                tree.getByHuman("Anna", "Petrova"),null));
//        tree.add(new Human("Lida", "Petrova", Gender.Female,
//                LocalDate.of(1990, 9, 14),
//                tree.getByHuman("Ivan", "Petrov"),
//                tree.getByHuman("Anna", "Petrova"),null));
//
//
//        String fileName = "src/model.dataSave/data.txt";
//        InterfaceIO interfaceIO = new FileHandler();
//        interfaceIO.saveFile(tree, fileName);
//        FamilyTree treeFile = (FamilyTree) interfaceIO.readFile(fileName);
//        System.out.println(treeFile.getInfoFamilyTree());


//        for (Human model.human : tree) {
//            System.out.println(model.human.getInfoHuman());
//        }
//        System.out.println();
//
//        tree.sortByName();
//        for (Human model.human : tree) {
//            System.out.println(model.human.getInfoHuman());
//        }
//        System.out.println();
//
//        tree.sortByBirthday();
//        for (Human model.human : tree) {
//            System.out.println(model.human.getInfoHuman());
//        }
    }


}