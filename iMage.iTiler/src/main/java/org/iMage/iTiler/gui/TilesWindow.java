package org.iMage.iTiler.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.image.BufferedImage;

public class TilesWindow extends JFrame {

    private TilesPanel tilesPanel;

    public TilesWindow() {
        super("Thumbnails");

        // configuring closing operation
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        setLocation(350, 500);

        setLayout(new BorderLayout());
        setResizable(false);  // makes the frame no more resizeable
        tilesPanel = new TilesPanel();
        add(tilesPanel);

        //Show window.
        setPreferredSize(new Dimension(535, 535));
        pack();
        setVisible(true);
    }

    /**
     * paints the loaded thumbnail in the tiles window
     * @param thumbnails    the loaded thumbnails
     */
    public void paintThumbnails( List<BufferedImage> thumbnails) {
        tilesPanel.initiateThumbnails(thumbnails);
    }
}
