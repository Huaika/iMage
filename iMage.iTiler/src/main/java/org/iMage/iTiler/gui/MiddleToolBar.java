package org.iMage.iTiler.gui;

import javax.swing.*;
import java.awt.*;

public class MiddleToolBar extends JPanel {

    private JButton saveButton;
    private JButton loadButton;

    public MiddleToolBar() {

        //specifying the border
        setBorder(BorderFactory.createTitledBorder("Configuration"));

        //initiating the Components
        saveButton = new JButton("Save Result");
        loadButton = new JButton("Load Input");

        //setting out the layout
        setLayout(new FlowLayout(FlowLayout.CENTER));

        //adding the components to the toolbar
        add(saveButton);
        add(loadButton);
    }
}
