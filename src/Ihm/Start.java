package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JButton implements ActionListener {

    private static final String TITLE = "Start";
    private Competition comp;
    private ListComp listComp;
    private Admin parent;


    public Start(Admin p, ListComp l) {
        super();
        this.comp = null;
        this.listComp = l;
        this.parent = p;
        this.setText(TITLE);
        this.addActionListener(this);
    }

    private void setComp(Competition comp) {
        this.comp = comp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setComp(this.listComp.getChoice());
        System.out.println(this.comp.getId() + " " + this.comp.getTitle());
        this.listComp.setVisible(false);
        this.setVisible(false);
        Entry entry = new Entry(this.comp);
        this.parent.getContentPane().add(entry, BorderLayout.SOUTH);
    }
}
