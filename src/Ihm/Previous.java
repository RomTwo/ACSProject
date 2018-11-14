package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Previous extends JButton implements ActionListener {

    private static final String TITRE = "Previous";
    private SecondFrame parent;
    private String userId;
    private int compId;

    public Previous(SecondFrame s, String userId, int compId) {
        super();
        this.parent = s;
        this.setText(TITRE);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.parent.getFen().getObjDist().unfollowEvent(this.userId, this.compId);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
        this.parent.getFen().setVisible(true);
        this.parent.dispose();
    }
}
