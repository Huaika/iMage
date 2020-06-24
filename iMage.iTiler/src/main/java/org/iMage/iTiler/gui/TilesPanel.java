package org.iMage.iTiler.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class TilesPanel extends JPanel {

    private  List<ImageIcon> icons;

    public TilesPanel() {



        //specifying the border
        setBorder(BorderFactory.createEtchedBorder());

         //adding the scrollbar
        add(new JScrollPane(), BorderLayout.CENTER);

        //setting the area
        setPreferredSize(new Dimension(530, 530));

    }

    public void initiateThumbnails(List<BufferedImage> thumbnails) {
        // TODO
    }

}
