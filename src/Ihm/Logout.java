package Ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Logout extends JButton implements ActionListener {

    private static final String TITLE = "Logout";
    private Principale parent;

    public Logout(Principale p) {
        this.parent = p;
        this.setText(TITLE);
        this.addActionListener(this);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.parent.getObjDist().close(this.parent.getId());
            System.exit(0);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
}
