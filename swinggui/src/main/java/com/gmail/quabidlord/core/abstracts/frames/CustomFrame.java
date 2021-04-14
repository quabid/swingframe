package com.gmail.quabidlord.core.abstracts.frames;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;

import javax.swing.JFrame;

import com.gmail.quabidlord.core.utils.WindowCoordinates;
import com.gmail.quabidlord.objectserializer.Deserializer;
import com.gmail.quabidlord.objectserializer.MyConstants;
import com.gmail.quabidlord.objectserializer.PathValidator;
import com.gmail.quabidlord.objectserializer.core.Serializer;

public abstract class CustomFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = -5922283730888839018L;
    private final PrintStream printer = new PrintStream(System.out);
    private final PathValidator pathValidator = new PathValidator();
    private final MyConstants constants = new MyConstants();
    private final Serializer serializer = new Serializer();
    private final Deserializer deserializer = new Deserializer();
    private String coordinates = constants.USRDIR + "coordinates.ser";

    /**
     * 
     * @param title
     */
    public CustomFrame(final String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title == null || title.isEmpty() || title.isBlank() ? "Custom Frame" : title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent we) {
                saveLocation();
            }

            @Override
            public void windowOpened(final WindowEvent we) {
                restoreLocation();
            }
        });
        setPreferredSize(new Dimension(660, 460));
        pack();
        setVisible(true);
    }

    private final void saveLocation() {
        printer.println("Window is closing");
        final WindowCoordinates wc = new WindowCoordinates(getX(), getY());
        serializer.serialize(wc, coordinates);
    }

    private final void restoreLocation() {
        printer.println("Window has opened");
        if (!pathValidator.pathExists(coordinates)) {
            printer.println("Window coordinates not found!");
            saveLocation();
        } else {
            final WindowCoordinates wc = (WindowCoordinates) deserializer
                    .deserialize(coordinates);
            setLocation(wc.getLocation());
        }
    }

    public final void exitProg() {
        saveLocation();
        this.dispose();
    }

    public final static long uid() {
        return serialVersionUID;
    }
}
