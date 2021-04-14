package com.gmail.quabidlord.core.concretes.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.gmail.quabidlord.core.abstracts.frames.CustomFrame;

public class MyFrame extends CustomFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MyFrame(String title) {
        super(title);
        JPanel panel = new JPanel();
        final MyFrame that = this;

        JPanel pnlButton = new JPanel();
        JButton btnClose = new JButton("Close");

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                that.exitProg();
            }
        };

        btnClose.addActionListener(actionListener);

        pnlButton.add(btnClose);
        panel.add(pnlButton);
        this.add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new MyFrame("Test Frame");
            }
        });
    }

}
