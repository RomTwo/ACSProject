package Ihm;

import javax.swing.*;
import java.awt.*;

import Contrat.Contrat;


public class Principale extends JFrame {
    private static final String TITLE = "Compétitions";

    private JLabel title;
    private Logout logout;
    private Results res;
    private Sport sport;
    private Box left;
    private Box center;
    private Box right;
    private Contrat objDist;
    private String id;

    public Principale(String id, Contrat obj) {
        super();
        this.objDist = obj;
        this.id = id;
        this.build();
    }

    private void build() {
        this.title = new JLabel(TITLE);
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.logout = new Logout(this);
        this.res = new Results();
        this.sport = new Sport(this);

        this.left = Box.createVerticalBox();
        this.center = Box.createVerticalBox();
        this.right = Box.createVerticalBox();

        this.left.add(this.res);
        this.right.add(this.logout);

        this.setTitle("Essais IHM");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.pack();

        this.getContentPane().add(this.left, BorderLayout.WEST);
        this.getContentPane().add(this.sport, BorderLayout.CENTER);
        this.getContentPane().add(this.right, BorderLayout.EAST);

        this.setVisible(true);
    }

    public String getId() {
        return id;
    }

    public Contrat getObjDist() {
        return objDist;
    }
}
