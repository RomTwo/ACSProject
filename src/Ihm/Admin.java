package Ihm;

import Contrat.Contrat;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class Admin extends JFrame {

    private static final String TITLE = "Administration";

    private JLabel title;
    private Logout logout;
    private ListComp listComp;
    private Start start;
    private Box northBox;
    private Contrat objDist;
    private String id;

    public Admin(String id, Contrat obj) throws RemoteException {
        super();
        this.objDist = obj;
        this.id = id;
        this.build();
    }

    private void build() throws RemoteException {
        this.northBox = Box.createVerticalBox();

        this.logout = new Logout(objDist, id);
        this.title = new JLabel(TITLE);
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.listComp = new ListComp(this.objDist.getCompetitions());
        this.listComp.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.start = new Start(this, null, this.listComp);
        this.start.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.northBox.add(this.title);
        this.northBox.add(this.listComp);
        this.northBox.add(this.start);

        this.setTitle("Administration");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.pack();

        this.getContentPane().add(this.northBox, BorderLayout.NORTH);
        this.getContentPane().add(this.logout, BorderLayout.EAST);

        this.setVisible(true);
    }
}
