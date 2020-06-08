package org.iMage.iTiler.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class UpperPanel extends JPanel {


    private ImagePanel leftImagePanel;
    private ImagePanel rightImagePanel;


    public UpperPanel() {
        //setting the width and the height as specified
        Dimension dim = getPreferredSize();
        dim.width = 350;
        dim.height = 300;
        setPreferredSize(dim);

        //specifying the border
        setBorder(BorderFactory.createEtchedBorder());

        //setting out the layout
        setLayout(new BorderLayout());

    }

    /**
     * initiates the left image pane by calling the initiate method
     * @param image  the image from which to initiate the imagePanel
     */
    public void initiateLeftImage(BufferedImage image) {
        leftImagePanel = new ImagePanel(image);
        add(leftImagePanel, BorderLayout.WEST);
        this.getParent().repaint();
        this.getParent().revalidate();
    }

    /**
     * initiates the left image pane by calling the initiate method
     * @param image  the image from which to initiate the imagePanel
     */
    public void initiateRightImage(BufferedImage image) {
        rightImagePanel = new ImagePanel(image);
        add(rightImagePanel, BorderLayout.EAST);
        this.getParent().repaint();
        this.getParent().revalidate();
    }





}
