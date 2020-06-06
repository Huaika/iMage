package org.iMage.iTiler.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    /**
     * the toolbar which contains the run and rectangle Button
     */
    private ToolBar toolBar;

    public MainFrame() {
        super("iTiler");

        //setup the Layout-Manager
        setLayout(new BorderLayout());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(850, 450));
        setResizable(false);  // makes the frame no more resizeable

        //initiating the components
        toolBar = new ToolBar();

        //adding the components into the frame
        add(toolBar, BorderLayout.SOUTH);


        //Display the window
        pack();
        setVisible(true);

    }



}
