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

import Controller.AddUserController;

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
        frame.setBounds(100, 100, 450, 550);
        frame.setTitle("Register");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelTitleLogin = new JLabel("== Register ==");
        labelTitleLogin.setBounds(175, 20, 100, 35);
        frame.add(labelTitleLogin);

        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(50, 70, 100, 25);
        frame.add(labelUsername);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 70, 200, 25);
        frame.add(usernameField);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(50, 110, 100, 25);
        frame.add(labelPassword);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 110, 200, 25);
        frame.add(passwordField);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(50, 150, 100, 25);
        frame.add(labelEmail);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 150, 200, 25);
        frame.add(emailField);

        JLabel labelPhoneNum = new JLabel("Phone Number:");
        labelPhoneNum.setBounds(50, 190, 100, 25);
        frame.add(labelPhoneNum);

        JTextField phoneNumField = new JTextField();
        phoneNumField.setBounds(150, 190, 200, 25);
        frame.add(phoneNumField);

        JLabel labelCardNum = new JLabel("Card Number:");
        labelCardNum.setBounds(50, 230, 100, 25);
        frame.add(labelCardNum);

        JTextField cardNumField = new JTextField();
        cardNumField.setBounds(150, 230, 200, 25);
        frame.add(cardNumField);

        JLabel labelMembership = new JLabel("Buy Membership:");
        labelMembership.setBounds(50, 270, 120, 25);
        frame.add(labelMembership);

        JButton membershipButton = new JButton("Buy Membership");
        membershipButton.setBounds(150, 270, 200, 25);
        frame.add(membershipButton);

        JLabel labelRole = new JLabel("Registered as:");
        labelRole.setBounds(50, 310, 100, 25);
        frame.add(labelRole);

        String[] roles = { "Seller", "Customer" };
        JComboBox<String> roleBox = new JComboBox<>(roles);
        roleBox.setBounds(150, 310, 200, 25);
        frame.add(roleBox);

        JButton submitButton = new JButton("Register");
        submitButton.setBounds(150, 360, 100, 30);
        frame.add(submitButton);

        frame.setVisible(true);

        membershipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new BuyMembership();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String email = emailField.getText();
                String phoneNum = phoneNumField.getText();
                String cardNum = cardNumField.getText();
                String role = (String) roleBox.getSelectedItem();

                boolean isSaved = AddUserController.addUser(role, username, password, email, phoneNum, cardNum);

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
