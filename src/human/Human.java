package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, InterfaceHuman {
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

    @Override
    public void setFather(Human father) {
        this.father = father;
    }
    @Override
    public void setMother(Human mother) {
        this.mother = mother;
    }
    @Override
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    @Override
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public Gender getGender() {
        return gender;
    }
    @Override
    public LocalDate getBirthday() {
        return birthday;
    }
    @Override
    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }
    @Override
    public Human getFather() {
        return father;
    }
    @Override
    public Human getMother() {
        return mother;
    }
    @Override
    public Human getSpouse() {
        return spouse;
    }
    @Override
    public List<Human> getChildren() {
        return children;
    }
    @Override
    public String getFatherInfo() {
        String str = "Отец: ";
        if (father != null && father != null) {
            str = str + father.name + " " + father.surname + ", "
                    + father.birthday.getDayOfMonth() + " "
                    + father.birthday.getMonth() + " "
                    + father.birthday.getYear() + "\n";
        } else {
            str = str + "информации нет!\n";
        }
        return str;
    }
    @Override
    public String getMotherInfo() {
        String str = "Мать: ";
        if (mother != null && mother != null) {
            str = str + mother.name + " " + mother.surname + ", "
                    + mother.birthday.getDayOfMonth() + " "
                    + mother.birthday.getMonth() + " "
                    + mother.birthday.getYear() + "\n";
        } else {
            str = str + "информации нет!\n";
        }
        return str;
    }
    @Override
    public String getSpouseInfo() {
        String str = "Супруг(-a): ";
        if (spouse != null && spouse != null) {
            str = str + spouse.name + " " + spouse.surname + ", "
                    + spouse.birthday.getDayOfMonth() + " "
                    + spouse.birthday.getMonth() + " "
                    + spouse.birthday.getYear() + "\n";
        } else {
            str = str + "информации нет!\n";
        }
        return str;
    }
    @Override
    public String getChildrenInfo() {
        String str = "Дети: ";
        if (children.size() != 0) {
            for (int i = 0; i < children.size(); i++) {
                str = str + "\n" + children.get(i).name + " " + children.get(i).surname + ", "
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
    public String getInfoHuman() {
        String str = name + " " + surname + ", "
                + birthday.getDayOfMonth() + " " + birthday.getMonth() + " " + birthday.getYear();
        return str;
    }
    @Override
    public String getInfoHumanFull() {
        String str = "==============================================\n";
        str = str + name + " " + surname + ", "
                + birthday.getDayOfMonth() + " " + birthday.getMonth() + " " + birthday.getYear() + ". \n";
        str = str + getFatherInfo();
        str = str + getMotherInfo();
        str = str + getSpouseInfo();
        str = str + getChildrenInfo();

        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getInfoHuman().equals(getInfoHuman());
    }

}
