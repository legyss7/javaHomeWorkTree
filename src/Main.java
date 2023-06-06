import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human PetrovIvan = new Human("Ivan", "Petrov",
                1, 1,1960);
        Human PetrovaAnna = new Human("Anna", "Petrova",
                10, 10,1965);
        PetrovIvan.addSpouse(PetrovaAnna);
        PetrovaAnna.addSpouse(PetrovIvan);


        Human PetrovMaksim = new Human("Maksim", "Petrov",
                12, 11,1980);
        Human PetrovaMarina = new Human("Marina", "Petrova",
                13, 1,1985);
        Human PetrovaLida = new Human("Lida", "Petrova",
                14, 9,1990);

        PetrovIvan.addChild(PetrovMaksim);
        PetrovIvan.addChild(PetrovaMarina);
        PetrovIvan.addChild(PetrovaLida);

        PetrovaAnna.addChild(PetrovMaksim);
        PetrovaAnna.addChild(PetrovaMarina);
        PetrovaAnna.addChild(PetrovaLida);

        PetrovMaksim.addFather(PetrovIvan);
        PetrovMaksim.addMother(PetrovaAnna);

        PetrovaMarina.addFather(PetrovIvan);
        PetrovaMarina.addMother(PetrovaAnna);

        PetrovaLida.addFather(PetrovIvan);
        PetrovaLida.addMother(PetrovaAnna);


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