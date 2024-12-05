package View;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    Frame frame;
    public MainMenu() {

        showMainMenu();

    }
    public static void main(String[] args) {
        new MainMenu().showMainMenu();
    }
    public void showMainMenu() {

    
        frame = new JFrame("Main Menu");
        frame.setBounds(50, 50, 450, 800); // SET FRAME BOUND
     
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 450, 800);

        JLabel title2 = new JLabel("==TIKETHB==");
        title2.setBounds(105, 50, 100, 50);
        title2.setFont(new Font("SansSerif", Font.BOLD, 24));
        panel.add(title2);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(10, 130, 260, 50);
        panel.add(loginBtn);

        loginBtn.addActionListener(e -> {
            frame.dispose();
            new Login();
        });

        JButton registerBtn = new JButton("REGISTER");
        registerBtn.setBounds(10, 200, 260, 50);
        registerBtn.add(registerBtn);

        JButton exitBtn = new JButton("EXIT");
        exitBtn.setBounds(10, 270, 260, 50);
        panel.add(exitBtn);

        exitBtn.addActionListener(e -> {
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);

    }
}
