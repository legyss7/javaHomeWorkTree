package model.human;

import java.time.LocalDate;
import java.util.List;

public interface  InterfaceHuman <T> {
    void setFather(T father);
    void setMother(T mother);
    void setSpouse(T spouse);
    boolean addChild(T child);
    String getName();
    String getSurname();
    Gender getGender();
    LocalDate getBirthday();
    LocalDate getDayOfDeath();
    T getFather();
    T getMother();
    T getSpouse();
    List<Human> getChildren();
    String getFatherInfo();
    String getMotherInfo();
    String getSpouseInfo();
    String getChildrenInfo();
    String getInfoHuman();
    String getInfoHumanFull();
}
