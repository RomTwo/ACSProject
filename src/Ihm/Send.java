package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Send extends JButton implements ActionListener {

    private static final String TITLE = "send";
    private Competition comp;

    public Send(Competition c) {
        super();
        this.setText(TITLE);
        this.addActionListener(this);
        this.comp = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
