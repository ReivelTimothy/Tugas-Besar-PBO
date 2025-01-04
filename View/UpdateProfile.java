package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.ControllerUser;
import Controller.UpdateProfileController;

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ControllerUser controller = new ControllerUser();
        
        String name = controller.getName();
        String password = controller.getPassword();
        String notlp = controller.getNoTlp();
        String email = controller.getEmail();


        labelUsername = new JLabel("Username:");
        labelUsername.setBounds(10, 10, 150, 30);
        frame.add(labelUsername);

        fieldUsername = new JTextField(name);
        fieldUsername.setBounds(150, 10, 200, 30);
        frame.add(fieldUsername);

        labelPassword = new JLabel("Password:");
        labelPassword.setBounds(10, 50, 150, 30);
        frame.add(labelPassword);

        fieldPassword = new JPasswordField(password);
        fieldPassword.setBounds(150, 50, 200, 30);
        frame.add(fieldPassword);

        labelNoTlp = new JLabel("Phone Number:");
        labelNoTlp.setBounds(10, 90, 150, 30);
        frame.add(labelNoTlp);

        fieldNoTlp = new JTextField(notlp);
        fieldNoTlp.setBounds(150, 90, 200, 30);
        frame.add(fieldNoTlp);

        labelEmail = new JLabel("Email:");
        labelEmail.setBounds(10, 130, 150, 30);
        frame.add(labelEmail);

        fieldEmail = new JTextField(email);
        fieldEmail.setBounds(150, 130, 200, 30);
        frame.add(fieldEmail);

        updateButton = new JButton("Update Profile");
        updateButton.setBounds(10, 180, 150, 30);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateProfileController controller = new UpdateProfileController();
                String newUsername = fieldUsername.getText();
                String newPassword = new String(fieldPassword.getPassword());
                String newPhone = fieldNoTlp.getText();
                String newEmail = fieldEmail.getText();
                
                controller.updateProfile(newUsername, newPassword, newPhone, newEmail);
            }
        });
        frame.add(updateButton);
    }
}
