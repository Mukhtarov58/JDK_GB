package hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class СlientWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_POSX = 200;
    private static final int WINDOW_POSY = 150;

    JButton btnLogin = new JButton("login");
    JButton btnSend = new JButton("send");

    JTextField textField = new JTextField();
    JPanel headerPanel;

    СlientWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat client");
        setResizable(true);

        JPanel enterText = enterText();
        JPanel fakeInfo = fakeInfo();
        JPanel loginPanel = loginPanel();

        headerPanel = new JPanel(new GridLayout(2, 1));
        headerPanel.add(fakeInfo);
        headerPanel.add(loginPanel);


        add(headerPanel, BorderLayout.NORTH);
        add(enterText, BorderLayout.SOUTH);


        setVisible(true);
    }


    private JPanel enterText() {
        JPanel panelEnterText = new JPanel(new GridLayout(1, 2));
        panelEnterText.add(textField);
        panelEnterText.add(btnSend);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textField.getText();
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        return panelEnterText;

    }

    private JPanel fakeInfo() {
        JPanel panelEnterText = new JPanel(new GridLayout(1, 3));
        JTextField fakeText1 = new JTextField("127.0.0.1");
        JTextField fakeText2 = new JTextField("8189");

        panelEnterText.add(fakeText1);
        panelEnterText.add(fakeText2);
        panelEnterText.add(new JPanel());

        return panelEnterText;
    }


    private JPanel loginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(1, 3));
        JTextField name = createTextFieldWithPlaceholder("Enter your name");
        JTextField password = createTextFieldWithPlaceholder("Enter your password");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                headerPanel.setVisible(false);
            }
        });

        loginPanel.add(name);
        loginPanel.add(password);
        loginPanel.add(btnLogin);

        return loginPanel;
    }

    private JTextField createTextFieldWithPlaceholder(String placeholder) {
        JTextField textField = new JTextField(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });

        return textField;
    }
}
