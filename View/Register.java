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

import Controller.Customer.AddUserController;
import View.CustomerView.BuyMembership;

public class Register {
    private JFrame frame;

    public Register() {
        inputRegister();
    }
    public static void main(String[] args) {
        new Register();
    }

    public void inputRegister() {
        frame = new JFrame();
        frame.setBounds(50, 50, 400, 350);
        frame.setTitle("Register");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelTitleLogin = new JLabel("==Register==");
        labelTitleLogin.setBounds(150, 20, 100, 35);
        frame.add(labelTitleLogin);

        JLabel labelUsername = new JLabel("Username : ");
        labelUsername.setBounds(25, 70, 90, 25);
        frame.add(labelUsername);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(110, 70, 200, 25);
        frame.add(usernameField);

        JLabel labelPassword = new JLabel("Password : ");
        labelPassword.setBounds(25, 110, 90, 25);
        frame.add(labelPassword);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 110, 200, 25);
        frame.add(passwordField);

        JLabel labelEmail = new JLabel("Email : ");
        labelEmail.setBounds(25, 150, 90, 25);
        frame.add(labelEmail);

        JTextField emailField = new JTextField();
        emailField.setBounds(110, 150, 200, 25);
        frame.add(emailField);

        JLabel labelPhoneNum = new JLabel("PhoneNum : ");
        labelPhoneNum.setBounds(25, 190, 90, 25);
        frame.add(labelPhoneNum);

        JTextField phoneNumField = new JTextField();
        phoneNumField.setBounds(110, 190, 200, 25);
        frame.add(phoneNumField);

        JLabel labelRole = new JLabel("Registered as: ");
        labelRole.setBounds(25, 230, 90, 25);
        frame.add(labelRole);

        String[] roles = {"Seller", "Customer"};
        JComboBox<String> roleBox = new JComboBox<>(roles);
        roleBox.setBounds(110, 230, 200, 25);
        frame.add(roleBox);

        JButton submitButton = new JButton("Register");
        submitButton.setBounds(150, 270, 100, 30);
        frame.add(submitButton);

        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String email = emailField.getText();
                String phoneNum = phoneNumField.getText();
                String role = (String) roleBox.getSelectedItem();

                boolean isSaved = AddUserController.addUser(role, username, password, email, phoneNum);

                if (isSaved) {
                    JOptionPane.showMessageDialog(null, "Selamat, Anda sudah selesai melakukan pendaftaran dan akan melanjutkan ke menu " + role);
                    frame.dispose();
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(null, "Account Anda gagal didaftarkan!", "Coba lagi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
