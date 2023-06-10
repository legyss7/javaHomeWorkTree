import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human PetrovIvan = new Human("Ivan", "Petrov", Gender.Male,
                LocalDate.of(1960, 1, 1));
        Human PetrovaAnna = new Human("Anna", "Petrova", Gender.Female,
                LocalDate.of(1965, 10, 5));
        PetrovIvan.setSpouse(PetrovaAnna);
        PetrovaAnna.setSpouse(PetrovIvan);


        Human PetrovMaksim = new Human("Maksim", "Petrov", Gender.Male,
                LocalDate.of(1980, 12,11));
        Human PetrovaMarina = new Human("Marina", "Petrova", Gender.Female,
                LocalDate.of(1985,1,13));
        Human PetrovaLida = new Human("Lida", "Petrova",Gender.Female,
                LocalDate.of(1990,9,14));

        PetrovIvan.addChild(PetrovMaksim);
        PetrovIvan.addChild(PetrovaMarina);
        PetrovIvan.addChild(PetrovaLida);

        PetrovaAnna.addChild(PetrovMaksim);
        PetrovaAnna.addChild(PetrovaMarina);
        PetrovaAnna.addChild(PetrovaLida);

        PetrovMaksim.setFather(PetrovIvan);
        PetrovMaksim.setMother(PetrovaAnna);

        PetrovaMarina.setFather(PetrovIvan);
        PetrovaMarina.setMother(PetrovaAnna);

        PetrovaLida.setFather(PetrovIvan);
        PetrovaLida.setMother(PetrovaAnna);

        System.out.println(PetrovIvan);
        System.out.println(PetrovaAnna);
        System.out.println(PetrovMaksim);
        System.out.println(PetrovaMarina);
        System.out.println(PetrovaLida);

        System.out.println(PetrovaMarina.getFather());
        System.out.println(PetrovaMarina.getMother());
        System.out.println(PetrovaAnna.getSpouse());
        System.out.println(PetrovaAnna.getChildren());
    }
}