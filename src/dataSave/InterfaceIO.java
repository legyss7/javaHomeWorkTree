package dataSave;

import java.io.IOException;
import java.io.Serializable;

public interface InterfaceIO {
    void saveFile(Serializable serializable, String fileName);
    Object readFile(String fileName);
}
