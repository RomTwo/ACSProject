package Ihm;

import javax.swing.*;
import java.awt.*;

public class SecondFrame extends JFrame {

    private Box left;
    private Box center;
    private Box right;
    private Previous previous;

    public SecondFrame() {
        super();
        this.build();
    }

    private void build() {

        this.left = Box.createHorizontalBox();
        this.center = Box.createHorizontalBox();
        this.right = Box.createHorizontalBox();

        this.previous = new Previous();

        this.setTitle("Essais IHM");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.pack();

        this.getContentPane().add(this.left);
        this.getContentPane().add(this.center);
        this.getContentPane().add(this.right);

        this.setVisible(true);
    }
}

