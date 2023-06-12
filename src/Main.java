import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();

        Human PetrovIvan = new Human("Ivan", "Petrov", Gender.Male,
                LocalDate.of(1960, 1, 1));
        Human PetrovaAnna = new Human("Anna", "Petrova", Gender.Female,
                LocalDate.of(1965, 10, 5));
        PetrovIvan.setSpouse(PetrovaAnna);
        PetrovaAnna.setSpouse(PetrovIvan);
        tree.add(PetrovIvan);
        tree.add(PetrovaAnna);

        tree.add(new Human("Maksim", "Petrov", Gender.Male,
                LocalDate.of(1980, 12,11),
                tree.getByHuman("Ivan", "Petrov"),
                tree.getByHuman("Anna", "Petrova")));
        tree.add(new Human("Marina", "Petrova", Gender.Female,
                LocalDate.of(1985,1,13),
                tree.getByHuman("Ivan", "Petrov"),
                tree.getByHuman("Anna", "Petrova")));
        tree.add(new Human("Lida", "Petrova",Gender.Female,
                LocalDate.of(1990,9,14),
                tree.getByHuman("Ivan", "Petrov"),
                tree.getByHuman("Anna", "Petrova")));





        System.out.println(tree.getByHuman("Anna", "Petrova"));
    }
}