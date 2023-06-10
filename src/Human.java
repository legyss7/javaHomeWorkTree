import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate birthday;
    private LocalDate dayOfDeath;
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human> children;


    public Human(String name, String surname,
                 Gender gender, LocalDate birthday, Human father, Human mother) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }
    public Human(String name, String surname,
                 Gender gender, LocalDate birthday) {
        this(name, surname, gender, birthday, null, null);
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public boolean addChild(Human child) {
        if(!children.contains(child)){
            this.children.add(child);
            return true;
        }
        return false;
    }

    public String getFather() {
        String str = "Отец: ";
        if (father != null && father != null) {
            str = str + father.name + " " + father.surname + ", " +
                    + father.birthday.getDayOfMonth() + " "
                    + father.birthday.getMonth() + " "
                    + father.birthday.getYear() + "\n";
        } else {
            str = str + "информации нет!\n";
        }
        return str;
    }

    public String getMother() {
        String str = "Мать: ";
        if (mother != null && mother != null) {
            str = str + mother.name + " " + mother.surname + ", " +
                    + mother.birthday.getDayOfMonth() + " "
                    + mother.birthday.getMonth() + " "
                    + mother.birthday.getYear() + "\n";
        } else {
            str = str + "информации нет!\n";
        }
        return str;
    }

    public String getSpouse() {
        String str = "Супруг(-a): ";
        if (spouse != null && spouse != null) {
            str = str + spouse.name + " " + spouse.surname + ", " +
                    + spouse.birthday.getDayOfMonth() + " "
                    + spouse.birthday.getMonth() + " "
                    + spouse.birthday.getYear() + "\n";
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
                        + children.get(i).birthday.getDayOfMonth() + " "
                        + children.get(i).birthday.getMonth() + " "
                        + children.get(i).birthday.getYear();
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
                + birthday.getDayOfMonth() + " " + birthday.getMonth() + " " + birthday.getYear() + ". \n";
        str = str + getFather();
        str = str + getMother();
        str = str + getSpouse();
        str = str + getChildren();

        return str;

    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.name.equals(name);
    }
}
