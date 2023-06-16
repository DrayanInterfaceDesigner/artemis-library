package Examples.simpleGame.utils;

import java.io.*;

public class DATManager extends FileManager {
    public DATManager(String path) {
        super(path);
    }

    @Override
    public void read() {

    }
    @Override
    public void write() {

    }

    public Serializable read(String path) {
        Object restoredObject = null;
        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            restoredObject = (Object) in.readObject();
            System.out.println("Restored object: " + restoredObject);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (Serializable) restoredObject;
    }

    public void write(Serializable obj, String path) {
        try (FileOutputStream fileOut = new FileOutputStream(path+".dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(obj);
            System.out.println("Object persisted successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
