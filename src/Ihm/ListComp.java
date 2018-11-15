package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ListComp extends JComboBox<String> implements ActionListener{

    private ArrayList<Competition> competitions = new ArrayList<>();
    private Competition choice = null;

    public ListComp(ArrayList<Competition> c) {
        super();
        this.addActionListener(this);
        for (Competition item : c) {
            this.addItem(item.getTeam1().getName() + " VS " + item.getTeam2().getName());
        }
    }

    public Competition getByTitle(String title) {
        for (Competition item : this.competitions) {
            String t = item.getTeam1().getName() + " VS " + item.getTeam2().getName();
            if (Objects.equals(t, title)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String t = (String)comboBox.getSelectedItem();
        System.out.println(t);
    }

}
