package human;

import human.Gender;
import human.Human;

import java.time.LocalDate;
import java.util.List;

public interface InterfaceHuman {
    void setFather(Human father);
    void setMother(Human mother);
    void setSpouse(Human spouse);
    boolean addChild(Human child);
    String getName();
    String getSurname();
    Gender getGender();
    LocalDate getBirthday();
    LocalDate getDayOfDeath();
    Human getFather();
    Human getMother();
    Human getSpouse();
    List<Human> getChildren();
    String getFatherInfo();
    String getMotherInfo();
    String getSpouseInfo();
    String getChildrenInfo();
    String getInfoHuman();
    String getInfoHumanFull();
}
