package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.LoginSingleton;
import View.AdminView.MainMenuAdmin;

public class Login {
   
    public Login() {
        inputLogin();
    }

    public void inputLogin() {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 350, 350);
        frame.setTitle("LOGIN");
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel labelTitleLogin = new JLabel("==LOGIN==");
        labelTitleLogin.setBounds(130, 30, 70, 35);
        frame.add(labelTitleLogin);
        labelTitleLogin.setForeground(Color.WHITE);
        
        JLabel labelUsername = new JLabel("Email : ");
        labelUsername.setBounds(25, 80, 90, 55);
        frame.add(labelUsername);
        labelUsername.setForeground(Color.WHITE);
        
        JTextField usernameField = new JTextField();
        usernameField.setBounds(110, 95, 120, 30);
        frame.add(usernameField);

        JLabel labelPassword = new JLabel("Password : ");
        labelPassword.setBounds(25, 110, 90, 55);
        frame.add(labelPassword);
        labelPassword.setForeground(Color.WHITE);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 130, 120, 30);
        frame.add(passwordField);

        JButton submitButton = new JButton("LOGIN");
        submitButton.setBounds(110, 210, 100, 30);
        frame.add(submitButton);

        submitButton.setBackground(new Color(0x2d5aed));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBorderPainted(false);
        frame.getContentPane().setBackground(new Color(0x567af0));
       
        frame.setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                new Controller.LoginCheck(email,password);  
                if(LoginSingleton.getInstance().getRole() == 0) {
                    frame.dispose();
                    new ViewTicket();
                }
                else if (LoginSingleton.getInstance().getRole()==1){
                    frame.dispose();
                    new ViewTicket();
                }
                else if (LoginSingleton.getInstance().getRole()==2){
                    frame.dispose();
                    new MainMenuAdmin();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Email atau password salah !");
                }
            }
        });
     
    }
}