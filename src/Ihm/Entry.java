package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.awt.*;

public class Entry extends JPanel {

    private JTextField entry;
    private Send send;
    private Box centerBox;

    public Entry(Competition c) {
        super();
        this.setLayout(new BorderLayout());
        this.build(c);
    }

    private void build(Competition c) {
        this.centerBox = Box.createVerticalBox();
        this.entry = new JTextField();
        this.send = new Send(c);

        this.centerBox.add(this.entry);
        this.centerBox.add(this.send);

        this.add(this.centerBox, BorderLayout.CENTER);
    }
}
