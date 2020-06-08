package org.iMage.iTiler.gui;

import org.iMage.iTiler.utils.ImageFileFilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiddleToolBar extends JPanel implements ActionListener {

    private JButton saveButton;
    private JButton loadButton;
    private JFileChooser fileChooser;
    private ImageFlowListener imageFlowListener;

    public MiddleToolBar() {

        //specifying the border
        setBorder(BorderFactory.createTitledBorder("Configuration"));

        //initiating the Components
        saveButton = new JButton("Save Result");
        loadButton = new JButton("Load Input");
        fileChooser = new JFileChooser();

        //setting the file filter to accept only image Files
        fileChooser.addChoosableFileFilter(new ImageFileFilter());

        //adding the action listeners
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);

        //setting out the layout
        setLayout(new FlowLayout(FlowLayout.CENTER));

        //adding the components to the toolbar
        add(loadButton);
        add(saveButton);

        //setup save Button
        saveButton.setEnabled(false);

    }

    /**
     * sets the listener of the class
     * @param imageFlowListener the listener
     */
    public void setImageFlowListener(ImageFlowListener imageFlowListener) {
        this.imageFlowListener = imageFlowListener;
    }

    /**
     * enables the save button when output image is loaded
     */
    public void enableSaveButton() {
        saveButton.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == saveButton) {
            fileChooser.showSaveDialog(MiddleToolBar.this);
            imageFlowListener.saveResultImage(fileChooser.getSelectedFile());
        }
        else if (clicked == loadButton) {
            if (imageFlowListener != null) {
                fileChooser.showOpenDialog(MiddleToolBar.this);
                imageFlowListener.emitImage(fileChooser.getSelectedFile());
            }
        }
    }
}
