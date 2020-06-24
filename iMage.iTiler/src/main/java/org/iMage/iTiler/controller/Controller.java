package org.iMage.iTiler.controller;

import org.iMage.iTiler.dataBase.Database;
import org.iMage.mosaique.MosaiqueEasel;
import org.iMage.mosaique.base.IMosaiqueArtist;

import java.awt.image.BufferedImage;

public class Controller {

    /**
     * the data base where the relevant data gets stored for later analysis
     */
    private Database db;

    /**
     * the image to output
     */
    private BufferedImage outPutImage;

    public Controller() {
        db = new Database();
    }

    /**
     * gets the database
     * @return the db
     */
    public Database getDb() {
        return db;
    }

    /**
     * generates the output image using the mosaique easel
     * @return  the outputImage
     */
    public BufferedImage generateOutputImage() {
        MosaiqueEasel mosaiqueEasel = new MosaiqueEasel();
        BufferedImage input = db.getInputImage().toBufferedImage();
        IMosaiqueArtist artist = db.getArtist();
        this.outPutImage = mosaiqueEasel.createMosaique(input, artist);
        return outPutImage;
    }

    /**
     * gets the output image if not null
     * @return  the output image
     */
    public BufferedImage getOutPutImage() {
        if (outPutImage == null) {
            System.err.println("no output image created");
        }
        return outPutImage;
    }
}
