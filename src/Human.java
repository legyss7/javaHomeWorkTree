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

    public void addFather(Human father) {
        this.father = father;
    }

    public void addMother(Human mother) {
        this.mother = mother;
    }

    public void addSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public String getFather() {
        String str = "Отец: ";
        if (father != null && father != null) {
            str = str + father.name + " " + father.surname + ", " +
                    +father.year + '.' + father.month + '.' + father.day + "\n";
        } else {
            str = str + "информации нет!\n";
        }
        return str;
    }

    public String getMother() {
        String str = "Мать: ";
        if (mother != null && mother != null) {
            str = str + mother.name + " " + mother.surname + ", " +
                    +mother.year + '.' + mother.month + '.' + mother.day + "\n";
        } else {
            str = str + "информации нет!\n";
        }
        return str;
    }

    public String getSpouse() {
        String str = "Супруг(-a): ";
        if (this.spouse != null && this.spouse != null) {
            str = str + this.spouse.name + " " + this.spouse.surname + ", " +
                    +this.spouse.year + '.' + this.spouse.month + '.' + this.spouse.day + "\n";
        } else {
            str = str + "информации нет!\n";
        }
        return str;
    }

    public String getChildren() {
        String str = "Дети: ";
        if (children.size() != 0) {
            for (int i = 0; i < children.size(); i++) {
                str = str + "\n" + children.get(i).name + " " + children.get(i).surname + ", " +
                        +children.get(i).year + '.' + children.get(i).month + '.' + children.get(i).day;
            }
            str = str + "\n";
        } else {
            str = str + "информации нет!\n";
        }
        return str;
    }

    @Override
    public String toString() {
        String str = "==============================================\n";
        str = str + name + " " + surname + ", " +
                +year + '.' + month + '.' + day + ". \n";
        str = str + getFather();
        str = str + getMother();
        str = str + getSpouse();
        str = str + getChildren();

        return str;

    }
}
