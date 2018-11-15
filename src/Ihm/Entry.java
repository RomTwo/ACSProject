package Ihm;

import Classe.Competition;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Entry extends JPanel implements DocumentListener {

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

        this.entry.getDocument().addDocumentListener(this);

        this.centerBox.add(this.entry);
        this.centerBox.add(this.send);

        this.add(this.centerBox, BorderLayout.CENTER);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.send.setEvent(this.entry.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.send.setEvent(this.entry.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.send.setEvent(this.entry.getText());
    }
}
