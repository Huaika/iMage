package org.iMage.plugins.crashCourse;

import org.jis.Main;
import org.kohsuke.MetaInfServices;
import plugins.PluginForJmjrst;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class serves as a prototype for a sample plugin.
 *
 * @author alejandrovillagómez
 * @version 1.0
 */
@MetaInfServices(PluginForJmjrst.class)
public class JavaCrashCourse extends PluginForJmjrst {

    /**
     * the main class in which the plugin will operate
     */
    private Main main;

    /**
     * the java final released versions
     */
    private final String JAVA_SE_9 =  "Java SE 9";
    private final String JAVA_SE_10 =  "Java SE 10";
    private final String JAVA_SE_11 =  "Java SE 11";
    private final String JAVA_SE_12 =  "Java SE 12";
    private final String JAVA_SE_13 =  "Java SE 13";
    private final String JAVA_SE_14 =  "Java SE 14";


    /**
     * a list of all java releases to this date
     */
    private List javaReleases;

    public String getName() {
        return this.getClass().getName();
    }

    public int getNumberOfParameters() {
        return javaReleases.size();
    }

    public void init(Main main) {
        this.main = main;
        javaReleases = List.of(
                JAVA_SE_9, JAVA_SE_10, JAVA_SE_11,
                JAVA_SE_12, JAVA_SE_13, JAVA_SE_14
        );
        System.out.println("Found " + getNumberOfParameters() + " Java versions since Java 8");
    }

    public void run() {
        if (javaReleases.isEmpty()) {
            System.out.println(this.getName() + "(" + this.getNumberOfParameters() + ")");
        } else {
            int length = javaReleases.size();
            double random = Math.random() * 100;
            random = random % length;
            String taken = (String) javaReleases.get((int) random);
            System.out.println(
                    switch (taken) {
                        case JAVA_SE_14 -> "Keeping updated";
                        case JAVA_SE_9, JAVA_SE_10, JAVA_SE_11, JAVA_SE_12, JAVA_SE_13
                                -> "Running late";
                        default -> throw new IllegalStateException("Unexpected value: " + taken);
                    }
            );
        }
    }

    public boolean isConfigurable() {
        return true;
    }

    public void configure() {
        JOptionPane.showMessageDialog(
                this.main,javaReleases.stream().collect(Collectors.joining("\n"))
        );
    }
}
