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


    public Start(Admin p, Competition c, ListComp l) {
        super();
        this.comp = c;
        this.listComp = l;
        this.parent = p;
        this.setText(TITLE);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(this.comp.getId() + " " + this.comp.getTitle());
        this.listComp.setVisible(false);
        this.setVisible(false);
        Entry entry = new Entry();
        this.parent.getContentPane().add(entry, BorderLayout.SOUTH);
    }
}
