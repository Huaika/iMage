package org.iMage.iTiler.gui;

import javax.swing.*;
import java.awt.*;

public class LowerToolBar extends JPanel {


    private JButton runButton;
    private JComboBox figureBox;
    private JButton showTilesButton;
    private JButton loadTilesButton;
    private JTextField widthField;
    private JTextField heightField;
    private JLabel tileSizeLabel;
    private JLabel artistLabel;


    public LowerToolBar() {

        //specifying the border
        setBorder(BorderFactory.createTitledBorder("Artistic"));

        //initiating the Components
        runButton = new JButton("run");
        figureBox = new JComboBox();
        showTilesButton = new JButton("Show Tiles");
        loadTilesButton = new JButton("Load Tiles");
        widthField = new JTextField(4);
        heightField = new JTextField(4);
        tileSizeLabel = new JLabel("Tile Size");
        artistLabel = new JLabel("Artist");

        //setting out the layout
        setLayout(new FlowLayout(FlowLayout.CENTER));

        //Setup Combo Box
        DefaultComboBoxModel figureModel = new DefaultComboBoxModel();
        figureModel.addElement("rectangle");
        figureModel.addElement("triangle");
        figureBox.setModel(figureModel);
        figureBox.setSelectedIndex(0);

        //adding the components to the toolbar
        add(tileSizeLabel);
        add(widthField);
        add(new JLabel("X"));
        add(heightField);
        add(loadTilesButton);
        add(showTilesButton);
        add(artistLabel);
        add(figureBox);
        add(runButton);



    }

}
