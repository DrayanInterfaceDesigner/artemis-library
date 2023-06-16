package Examples.simpleGame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileManager {
    protected String path;
    public String content;
    public FileManager(String path) {
        this.path = path;
    }

    public abstract void read();
    public abstract void write();
    public abstract void update();
    public abstract void delete();

    public String getContent() {
        return content;
    }
}
