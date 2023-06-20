package human;

import human.Human;

import java.util.Comparator;

public class HumanComparatorName<T extends InterfaceHuman> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
