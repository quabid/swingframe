package com.gmail.quabidlord.core.concretes.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class MyPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = -8818750024704453910L;

    public MyPanel() {
        super();
        JFormattedTextField username = new JFormattedTextField();
        JPasswordField password = new JPasswordField();
        JPanel panel = new JPanel(new FlowLayout());

        username.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        username.setHorizontalAlignment(JTextField.HORIZONTAL);
        username.setPreferredSize(new Dimension(300, 35));

        password.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        password.setHorizontalAlignment(JTextField.HORIZONTAL);
        password.setPreferredSize(new Dimension(300, 35));

        panel.setVisible(true);
        panel.add(username);
        panel.add(password);

        add(panel, BorderLayout.CENTER);
        setBorder(BorderFactory.createTitledBorder("Authenticate"));
    }
}
