package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.DBController;

public class Register {
    private JFrame frame;

    public Register() {
        inputRegister();
    }
    public static void main(String[] args) {
        new Register().inputRegister();
    }

    public void inputRegister() {
        frame = new JFrame();
        frame.setBounds(50, 50, 400, 1000);
        frame.setTitle("Register");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelTitleLogin = new JLabel("==Register==");
        labelTitleLogin.setBounds(150, 50, 80, 35);
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

        JLabel labelRole = new JLabel("Registered as: ");
        labelRole.setBounds(25, 160, 90, 25);
        frame.add(labelRole);

        String[] roles = {"SELLER", "Customer"};
        JComboBox<String> roleBox = new JComboBox<>(roles);
        roleBox.setBounds(110, 160, 200, 25);
        frame.add(roleBox);

        JButton submitButton = new JButton("Register");
        submitButton.setBounds(110, 210, 100, 30);
        frame.add(submitButton);
        
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String role = (String) roleBox.getSelectedItem();
        
                boolean isSaved = DBController.addUser(role, username, password);
        
                if (isSaved) {
                    JOptionPane.showMessageDialog(null, "Selamat, Account Anda sudah didaftarkan!");
                } else {
                    JOptionPane.showMessageDialog(null, "Account Anda gagal didaftarkan!", "Coba lagi", JOptionPane.ERROR_MESSAGE);
                }
                frame.dispose();
            }
        });
        
    }
}
