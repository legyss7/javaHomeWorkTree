package presenter;

import model.Service;
import java.util.Map;

public class Presenter {
    Service service;

    public Presenter() {
        service = new Service();
    }

    public void addHuman(Map<String, String> infoHuman) {
        service.addHuman(infoHuman);
    }

    public void getNote(Map<String, String> infoHuman) {
        System.out.println(service.getHuman(infoHuman));
    }

    public void getAllNote() {
        System.out.println(service.getInfoFamilyTree());
    }

    public void loadFile(){
        service.loadFile();
    }

    public void saveFile(){
        service.saveFile();
    }
}
