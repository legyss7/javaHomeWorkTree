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

    public String getNote(Map<String, String> infoHuman) {
        return service.getHuman(infoHuman);
    }

    public String getAllNote() {
        return service.getInfoFamilyTree();
    }

    public String loadFile() {
        return service.loadFile();
    }

    public void saveFile() {
        service.saveFile();
    }
}
