package model;

import model.human.Human;
import model.human.HumanComparatorBirthday;
import model.human.HumanComparatorName;
import model.human.InterfaceHuman;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;


public class FamilyTree<T extends InterfaceHuman<T>> implements Serializable, Iterable<T> {
    private List<T> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }


    public boolean add(T human) {
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

    public T getByHuman(String name, String surname) {
        for (T human : humanList) {
            if (human.getName().equals(name)
                    && human.getSurname().equals(surname)) {
                return human;
            }
        }
        return null;
    }

    public String getInfoFamilyTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("Количество записей: ");
        sb.append(humanList.size());
        sb.append("\n");
        for (T human : humanList) {
            sb.append(human.getInfoHumanFull());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorName<>());
    }
    public void sortByBirthday(){
        humanList.sort(new HumanComparatorBirthday<>());
    }
    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }


}
