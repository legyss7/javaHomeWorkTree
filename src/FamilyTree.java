import human.Human;
import human.HumanComparatorBirthday;
import human.HumanComparatorName;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;


public class FamilyTree implements Serializable, Iterable<Human> {
    private int index;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public Human getByHuman(String name, String surname) {
        for (Human human : humanList) {
            if (human.getName().equals(name)
                    && human.getSurname().equals(surname)) {
                return human;
            }
        }
        return null;
    }

    public String getInfoFamilyTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human : humanList) {
            sb.append(human.getInfoHumanFull());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorName());
    }
    public void sortByBirthday(){
        humanList.sort(new HumanComparatorBirthday());
    }
    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }


}
