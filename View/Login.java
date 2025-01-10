package View;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.LoginCheck;
import Controller.LoginSingleton;
import View.AdminView.MainMenuAdmin;
import View.CustomerView.MainMenuCustomer;
import View.SellerView.MainMenuSeller;

public class Login {
    private Frame frame;

    public Login() {
        inputLogin();
    }

    public void inputLogin() {
        frame = new JFrame();
        frame.setBounds(50, 50, 400, 1000);
        frame.setTitle("LOGIN");
        frame.setLayout(null);
        JLabel labelTitleLogin = new JLabel("==LOGIN==");
        labelTitleLogin.setBounds(150, 50, 70, 35);
        frame.add(labelTitleLogin);
        JLabel labelUsername = new JLabel("Email : ");
        labelUsername.setBounds(25, 80, 90, 55);
        frame.add(labelUsername);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(110, 95, 120, 30);
        frame.add(usernameField);
        JLabel labelPassword = new JLabel("Password : ");
        labelPassword.setBounds(25, 110, 90, 55);
        frame.add(labelPassword);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 130, 120, 30);
        frame.add(passwordField);

        JButton submitButton = new JButton("LOGIN");
        submitButton.setBounds(110, 210, 100, 30);
        frame.add(submitButton);

        frame.setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                new Controller.LoginCheck(email,password);
                
                if(LoginSingleton.getInstance().getRole() == 0) {
                    frame.dispose();
                    new MainMenuCustomer();
                }
                else if (LoginSingleton.getInstance().getRole()==1){
                    frame.dispose();
                    new MainMenuSeller();
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