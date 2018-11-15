package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JButton implements ActionListener {

    private static final String TITLE = "Start";
    private Entry entry;
    private Competition comp;
    private ListComp listComp;


    public Start(Entry e, Competition c, ListComp l) {
        super();
        this.entry = e;
        this.comp = c;
        this.listComp = l;
        this.setText(TITLE);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.entry.setVisible(true);
        //System.out.println(this.comp.getId() + " " + this.comp.getTitle());
        this.listComp.setVisible(false);
        this.setVisible(false);
    }
}
