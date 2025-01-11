package View.CustomerView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.Customer.ControllerUser;
import Controller.Customer.UpdateProfileController;

public class UpdateProfile {

    private JFrame frame;
    private JLabel labelUsername, labelPassword, labelNoTlp, labelEmail;
    private JTextField fieldUsername, fieldNoTlp, fieldEmail;
    private JPasswordField fieldPassword;
    private JButton updateButton;

    public UpdateProfile() {
        frame = new JFrame("Update Profile");
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.getContentPane().setBackground(Color.getHSBColor(0.6f, 0.7f, 0.9f));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        ControllerUser controller = new ControllerUser();
        
        String name = controller.getName();
        String password = controller.getPassword();
        String notlp = controller.getNoTlp();
        String email = controller.getEmail();

        // Username
        labelUsername = new JLabel("Username:");
        labelUsername.setBounds(10, 10, 150, 30);
        frame.add(labelUsername);

        fieldUsername = new JTextField(name);
        fieldUsername.setBounds(150, 10, 200, 30);
        frame.add(fieldUsername);

        // Password
        labelPassword = new JLabel("Password:");
        labelPassword.setBounds(10, 50, 150, 30);
        frame.add(labelPassword);

        fieldPassword = new JPasswordField(password);
        fieldPassword.setBounds(150, 50, 200, 30);
        frame.add(fieldPassword);

        // Phone Number
        labelNoTlp = new JLabel("Phone Number:");
        labelNoTlp.setBounds(10, 90, 150, 30);
        frame.add(labelNoTlp);

        fieldNoTlp = new JTextField(notlp);
        fieldNoTlp.setBounds(150, 90, 200, 30);
        frame.add(fieldNoTlp);

        // Email
        labelEmail = new JLabel("Email:");
        labelEmail.setBounds(10, 130, 150, 30);
        frame.add(labelEmail);

        fieldEmail = new JTextField(email);
        fieldEmail.setBounds(150, 130, 200, 30);
        frame.add(fieldEmail);

        // Update Button
        updateButton = new JButton("Update Profile");
        updateButton.setBounds(150, 180, 200, 35);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateProfileController profileController = new UpdateProfileController();
                String newUsername = fieldUsername.getText();
                String newPassword = new String(fieldPassword.getPassword());
                String newPhone = fieldNoTlp.getText();
                String newEmail = fieldEmail.getText();
                
                if (profileController.updateUserInDatabase(newUsername, newPassword, newPhone, newEmail)) {
                    JOptionPane.showMessageDialog(frame, "Update Profile berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new MainMenuCustomer();
                } else {
                    JOptionPane.showMessageDialog(frame, "Update gagal.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(updateButton);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 180, 120, 35);
        frame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenuCustomer();
            }
        });
    }

    public static void main(String[] args) {
        new UpdateProfile();
    }
}
