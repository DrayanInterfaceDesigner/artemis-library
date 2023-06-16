package Examples.simpleGame.utils;

import java.io.*;
import java.util.ArrayList;

public class CSVManager extends FileManager{
    public ArrayList<String[]> rows;
    public CSVManager(String path) {
        super(path);
        this.rows = new ArrayList<>();
    }
    @Override
    public void read() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] _row = line.split(";");
                this.rows.add(_row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.path))) {
            for (String[] row : rows) {
                String line = String.join(";", row);
                bw.write(line);
                bw.newLine();
            }
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
