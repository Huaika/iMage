package org.jis.generator;

import java.io.File;

public class Element {

  /**
   * Encapsulation warning!
   * As the attributes are public they are from outside the class
   * changeable and accessible. This could cause serious
   * malformation of the software.
   * Solution: set all the attributes to private and implement
   * getters and setters
   */
  public final File file;
  public final int index;
  public final int width;
  public final int height;
  public final File outDir;
  
  
  
  public Element(int index, File file, int width, int height, File outDir) {
    super();
    this.file = file;
    this.index = index;
    this.width = width;
    this.height = height;
    this.outDir = outDir;
  }
}
