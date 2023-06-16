package Examples.simpleGame.utils;

import java.io.*;

public class TxtManager extends FileManager{
    public TxtManager(String path) {
        super(path);
    }

    @Override
    public void read() {
        String fileName = this.path;
        this.content = "";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.content += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.path))) {
            bw.write(content);
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
