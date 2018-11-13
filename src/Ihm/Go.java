package Ihm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Go extends JButton implements ActionListener {

    private static final String TITLE = "Go";
    private int id;
    private Sport parent;

    public Go(Sport p, int id) {
        super();
        this.id = id;
        this.parent = p;
        this.setText(TITLE);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.parent.getParent().getObjDist().followEvent(this.parent.getParent().getId(), this.id);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
}