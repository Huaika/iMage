package org.iMage.iTiler.gui;

import javax.swing.*;

public class Main {

    /**
     * Create the GUI and show it.
     */
    private static void createAndShowGUI() {
        //setting the lookAndFeel
        JFrame.setDefaultLookAndFeelDecorated(true);
        //create and set up the window
        new MainFrame();
    }

    public static void main(String[] args) {
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}


//TODO show tile implementation
//TODO accept only ints as input
//TODO display warning images
//TODO practices
//TODO javadocs
//TODO how to getThumbnails from the artist before run command
// how to make the image pannel correctly
