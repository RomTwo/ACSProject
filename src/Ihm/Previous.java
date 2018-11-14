package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Previous extends JButton implements ActionListener{

    private static final String TITRE = "Previous";
    private SecondFrame parent;

    public Previous(SecondFrame s) {
        super();
        this.parent = s;
        this.setText(TITRE);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.parent.getFen().setVisible(true);
        this.parent.dispose();
    }
}
