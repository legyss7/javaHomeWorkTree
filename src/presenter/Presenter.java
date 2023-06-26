package presenter;

import model.Service;
import model.dataSave.FileHandler;
import model.dataSave.InterfaceIO;

import java.util.Map;

public class Presenter {
    private Service service;

    public Presenter() {
        InterfaceIO interfaceIO = new FileHandler();
        service = new Service(interfaceIO);
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
