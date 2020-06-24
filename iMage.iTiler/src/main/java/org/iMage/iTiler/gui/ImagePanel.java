package org.iMage.iTiler.gui;

import org.iMage.iTiler.utils.Utilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {

    /**
     * the image of the panel
     */
    private BufferedImage image;

    public ImagePanel(BufferedImage bufferedImage) {

        this.image = bufferedImage;

        //setting the width and the height as specified
        Dimension dim = getPreferredSize();
        dim.width = 350;
        dim.height = 250;
        setPreferredSize(dim);

        //specifying the border
        setBorder(BorderFactory.createEtchedBorder());

        //adds a new label component with the input image
        add(new JLabel(new ImageIcon(Utilities.adjustBufferedImage(image, 350, 250))));
    }

    public BufferedImage getImage() {
        return image;
    }
}