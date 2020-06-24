package org.iMage.iTiler.gui;

import org.iMage.iTiler.controller.Controller;
import org.iMage.iTiler.utils.Utilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {


    /**
     * the toolbar which is at the lower part of the frame
     */
    private LowerToolBar lowerToolBar;

    /**
     * the toolbar at the middle of the frame
     */
    private MiddleToolBar middleToolBar;

    /**
     * the upper left panel which contains the input image
     */
    private UpperPanel upperPanel;

    /**
     * the window displayed when showing the tiles
     */
    private TilesWindow tilesWindow;

    /**
     * the frames controller
     */
    private Controller controller;

    public MainFrame() {
        super("iTiler");

        //setup the Layout-Manager
        setLayout(new BorderLayout());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(850, 450));
        setResizable(false);  // makes the frame no more resizeable

        //initiating the components
        controller = new Controller();
        lowerToolBar = new LowerToolBar();
        middleToolBar = new MiddleToolBar();
        upperPanel = new UpperPanel();

        //setup the Middle toolbar
        middleToolBar.setImageFlowListener(new ImageFlowListener() {
            @Override
            public void emitImage(File imageFile) {
                BufferedImage input = Utilities.bufferFile(imageFile);
                upperPanel.initiateLeftImage(input);
                controller.getDb().submitInputImage(input);
            }

            @Override
            public void saveResultImage(File saveFolder) {
                String path = saveFolder.getPath();
                File outPutFile = new File(path);
                try {
                    ImageIO.write(controller.getOutPutImage(), "png", outPutFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //setup the Lower tool bar

        lowerToolBar.setDirectoryListener(new DirectoryLoadListener() {
            @Override
            public void emitDirectory(File directoryFile) {
                controller.getDb().submitImages(Utilities.bufferDirectory(directoryFile));
            }
        });

        lowerToolBar.setDataBaseListener(new DatabaseListener() {
            @Override
            public void addAnalysisInfoTo_DB(String[] info) {
                    controller.getDb().submitTileWidth(info[0]);
                    controller.getDb().submitTileHeight(info[1]);
                    controller.getDb().submitArtist(info[2]);
                    if (controller.getDb().isReadyToExecute()) {
                        upperPanel.initiateRightImage(controller.generateOutputImage());
                        middleToolBar.enableSaveButton();
                    }
            }
        });


        lowerToolBar.setWindowListener(new WindowListener() {
            @Override
            public void displayWindow() {
                tilesWindow = new TilesWindow();
                tilesWindow.paintThumbnails(
                        Utilities.convertArtListToBuffer(controller.getDb().getArtist().getThumbnails())
                );
            }
        });

        //adding the components into the frame
        add(lowerToolBar, BorderLayout.PAGE_END);
        add(middleToolBar, BorderLayout.CENTER);
        add(upperPanel, BorderLayout.NORTH);

        //Display the window
        pack();
        setVisible(true);
    }
}
