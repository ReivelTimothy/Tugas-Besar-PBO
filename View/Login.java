import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JLabel labelUsername = new JLabel("Username : ");
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

        frame.setVisible(true);

        JButton submitButton = new JButton("LOGIN");
        submitButton.setBounds(60, 180, 150, 30);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // cek login
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

            }
        });
    }
}
