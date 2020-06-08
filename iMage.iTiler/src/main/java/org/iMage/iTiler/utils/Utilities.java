package org.iMage.iTiler.utils;

import org.iMage.mosaique.base.BufferedArtImage;
import org.iMage.mosaique.rectangle.RectangleShape;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Utilities {

    /**
     * adjusted a buffered image to the specified size
     * @param image  the image to adjust
     * @param height the height to proportion to the new image
     * @param width the width to proportion to the new image
     * @return  the adjusted image
     */
    public static BufferedImage adjustBufferedImage(BufferedImage image, int width, int height) {
        BufferedArtImage bf = new BufferedArtImage(image);
        RectangleShape rectangleShape = new RectangleShape(bf, width, height);
        return rectangleShape.getThumbnail();
    }

    /**
     * gets file extensions
     * @param name  the name of the extensions to get
     * @return  the file extension
     */
    public static String getFileExtensions(String name) {

        int pointIndex = name.lastIndexOf(".");

        if (pointIndex == -1) {
            return null;
        }
        if (pointIndex == name.length() -1) {
            return null;
        }
        return name.substring(pointIndex + 1);
    }

    /**
     * assembles a List of buffered images parting from a directory
     * @param directory the directory from which to create the images
     * @return  a list with all the images.
     */
    public static List<BufferedImage> bufferDirectory(File directory) {
        assert directory.isDirectory();
        List<BufferedImage> images = new ArrayList<>();
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            try {
                images.add(ImageIO.read(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return images;
    }

    /**
     * converts a file into a buffered image
     * @param imageFile the file to convert
     * @return  the file converted to an image
     */
    public static BufferedImage bufferFile(File imageFile) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }


    /**
     * migrates a buffered image list to a buffered art image one
     * @param bufferedImages    the images to migrate
     * @return  the migrated images
     */
    public static List<BufferedArtImage> convertToBufferedArt(List<BufferedImage> bufferedImages) {
        List<BufferedArtImage> artImages = new ArrayList<>();
        for (BufferedImage image:
             bufferedImages) {
            artImages.add(new BufferedArtImage(image));
        }
        return artImages;
    }

    /**
     * migrates a buffered image  to a buffered art image one
     * @param bufferedImage    the image to migrate
     * @return  the migrated image
     */
    public static BufferedArtImage convertToBufferedArtSingle(BufferedImage bufferedImage) {
       BufferedArtImage artImage;
       artImage = new BufferedArtImage(bufferedImage);
       return artImage;
    }
}











