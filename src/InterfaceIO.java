import java.io.IOException;
import java.io.Serializable;

public interface InterfaceIO {
    void save(Serializable serializable, String fileName) throws IOException;
    Object read(String fileName);
}
