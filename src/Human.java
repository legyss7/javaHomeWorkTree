import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String surname;
    private Integer year;
    private Integer month;
    private Integer day;
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human> children = new ArrayList<>();


    public Human(String name, String surname,
                 Integer year, Integer month, Integer day) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addFather(Human father){
        this.father = father;
    }

    public void addMother(Human mother){
        this.mother = mother;
    }

    public void addSpouse(Human spouse){
        this.spouse = spouse;
    }

    public void addChild(Human child){
        this.children.add(child);
    }

    @Override
    public String toString() {
        String str = "==============================================\n";
        str = str + name + " " + surname + ", " +
                + year + '.' + month + '.' + day + ". \n";
        str = str + "Отец: ";
        if(father != null && father != null){
            str = str + father.name + " " + father.surname + ", " +
                    + father.year + '.' + father.month + '.' + father.day + "\n";
        }
        else {
            str = str + "информации нет!\n";
        }
        str = str + "Мать: ";
        if(mother != null && mother != null){
            str = str + mother.name + " " + mother.surname + ", " +
                    + mother.year + '.' + mother.month + '.' + mother.day+ "\n";
        }
        else {
            str = str + "информации нет!\n";
        }
        str = str + "Супруг(-a): ";
        if(spouse != null && spouse != null){
            str = str + spouse.name + " " + spouse.surname + ", " +
                    + spouse.year + '.' + spouse.month + '.' + spouse.day + "\n";
        }
        else {
            str = str + "информации нет!\n";
        }
        str = str + "Дети: ";
        if(children.size() != 0){
            for (int i = 0; i < children.size(); i++){
                str = str + "\n" + children.get(i).name + " " + children.get(i).surname + ", " +
                        + children.get(i).year + '.' + children.get(i).month + '.' + children.get(i).day;
            }
            str = str + "\n";
        }
        else {
            str = str + "информации нет!\n";
        }
        return str;

    }
}
