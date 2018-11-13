package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Sport extends JPanel {

    private Principale parent;
    private ArrayList<Competition> competitions = new ArrayList<>();

    public Sport(Principale p) {
        super();
        this.parent = p;
        this.build();
    }

    private void build() {
        try {
            this.competitions.addAll(this.parent.getObjDist().getCompetitions());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        for (Competition item : this.competitions) {
            this.add(constructPanel(item));
        }
        this.setVisible(true);
    }

    private JPanel constructPanel(Competition comp) {
        JPanel p = new JPanel();
        Go btn = new Go(this, comp.getId());
        p.add(new JLabel(comp.getType()));
        p.add(new JLabel(comp.getTitle()));
        p.add(new JLabel(comp.getTeam1().getName() + " VS " + comp.getTeam2().getName()));
        p.add(btn);
        p.setVisible(true);

        return p;
    }

    @Override
    public Principale getParent() {
        return parent;
    }
}
