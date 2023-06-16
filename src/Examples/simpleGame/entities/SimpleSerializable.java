package Examples.simpleGame.entities;

import javax.swing.*;
import java.io.Serializable;

public class SimpleSerializable extends JMenuItem implements Serializable {
    public String label;
    public JMenuItem item;
    public int ressurected;
    public SimpleSerializable(String label) {
        //        error = 0;
        this.ressurected = 0;
        this.label = label + "ressurected_" + this.ressurected;
        item = new JMenuItem(this.label);
    }

    public JMenuItem getItem() {
        return this.item;
    }
}
