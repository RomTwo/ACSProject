package Ihm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Previous extends JButton implements ActionListener{

    private static final String TITRE = "Previous";

    public Previous() {
        super();
        this.setText(TITRE);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
