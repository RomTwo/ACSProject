package Ihm;

import javax.swing.*;
import java.awt.*;

public class Entry extends JPanel {

    private JTextField entry;
    private Send send;
    private Box centerBox;

    public Entry() {
        super();
        this.setLayout(new BorderLayout());
        this.setVisible(false);
        this.build();
    }

    private void build() {
        this.centerBox = Box.createVerticalBox();
        this.entry = new JTextField();
        this.send = new Send();

        this.centerBox.add(this.entry);
        this.centerBox.add(this.send);

        this.add(this.centerBox, BorderLayout.CENTER);
    }
}
