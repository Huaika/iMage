package org.iMage.iTiler.utils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ImageFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        String name = f.getName();
        String extension = Utilities.getFileExtensions(name);

        if (f.isDirectory()) {
            return true;
        }

        if (extension == null) {
            return false;
        }
        if (extension.equals("jpg")) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Image Database Files";
    }
}
