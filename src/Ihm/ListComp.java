package Ihm;

import Classe.Competition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ListComp extends JComboBox<String> implements ActionListener {

	private static final long serialVersionUID = 1L;
	
    private ArrayList<Competition> competitions = new ArrayList<>();
    private Competition choice = null;

    public ListComp(ArrayList<Competition> c) {
        super();
        this.addActionListener(this);

        this.competitions.addAll(c);
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

    public Competition getChoice() {
        return choice;
    }

    private void setChoice(Competition choice) {
        this.choice = choice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String t = (String) comboBox.getSelectedItem();
        setChoice(getByTitle(t));
    }

}
