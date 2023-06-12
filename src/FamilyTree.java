import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;
    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }
    public boolean add(Human human){
        if (!humanList.contains(human)) {
            humanList.add(human);
            if(human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }
    public Human getByHuman(String name, String surname){
        for(Human human: humanList){
            if(human.getName().equals(name)
                    && human.getSurname().equals(surname)){
                return human;
            }
        }
        return null;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for(Human human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
}
