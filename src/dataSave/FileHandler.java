package dataSave;

import java.io.*;

public class FileHandler implements InterfaceIO {
    @Override
    public void saveFile(Serializable serializable, String fileName) {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(serializable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object readFile(String fileName) {
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream(fileName))) {
            return objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
