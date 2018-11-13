package Ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Results extends JButton implements ActionListener {

    public Results() {
        super();
        this.build();
    }

    private void build() {
        this.setText("Résultats Votes/Paris");
        this.addActionListener(this);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
