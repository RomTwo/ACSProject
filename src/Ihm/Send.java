package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Send extends JButton implements ActionListener {

    private static final String TITLE = "send";
    private Competition comp;
    private String event;
    private Entry parent;

    public Send(Competition c, Entry e) {
        super();
        this.setText(TITLE);
        this.addActionListener(this);
        this.comp = c;
        this.parent = e;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.event);
        this.parent.clearTextField();
    }
}
