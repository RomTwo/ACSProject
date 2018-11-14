package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.awt.*;

public class SecondFrame extends JFrame {

    private Box left;
    private Box center;
    private Box right;
    private Previous previous;
    private Principale fen;
    private Competition comp;
    private String userId;
    private JLabel title;
    private JLabel versus;

    public SecondFrame(Principale p, Competition c, String id) {
        super();
        this.fen = p;
        this.comp = c;
        this.userId = id;
        this.build();
    }

    private void build() {

        this.left = Box.createVerticalBox();
        this.center = Box.createVerticalBox();
        this.right = Box.createVerticalBox();

        this.previous = new Previous(this, this.userId, this.comp.getId());
        this.title = new JLabel(this.comp.getTitle());
        this.versus = new JLabel(this.comp.getTeam1().getName() + " VS " + this.comp.getTeam2().getName());

        this.left.add(this.previous);
        this.center.add(this.title);
        this.center.add(this.versus);

        this.setTitle("Essais IHM");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.pack();

        this.getContentPane().add(this.left, BorderLayout.WEST);
        this.getContentPane().add(this.center, BorderLayout.CENTER);
        this.getContentPane().add(this.right, BorderLayout.EAST);

        this.setVisible(true);
    }

    public Principale getFen() {
        return fen;
    }

}

