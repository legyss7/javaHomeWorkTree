package model.dataSave;

import java.io.Serializable;

public interface InterfaceIO {
    void saveFile(Serializable serializable, String fileName);
    Object readFile(String fileName);
}
