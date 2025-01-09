package View.CustomerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Customer.ControllerUser;
import Controller.Customer.StatusMembershipController;

public class ViewStatusMembership {

    private JFrame frame;
    private JLabel labelUsername;
    private JButton statusButton;
    private JTable statusTable;
    private JScrollPane scrollPane;

    public ViewStatusMembership() {
        frame = new JFrame("View Status Membership");
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        ControllerUser user = new ControllerUser();

        labelUsername = new JLabel("User: " + user.getName());
        labelUsername.setBounds(10, 10, 200, 30);
        frame.add(labelUsername);

        statusTable = new JTable();
        scrollPane = new JScrollPane(statusTable);
        scrollPane.setBounds(10, 100, 560, 250);
        frame.add(scrollPane);

        statusButton = new JButton("View Status Membership");
        statusButton.setBounds(10, 60, 200, 30);
        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusMembershipController.displayMembership(statusTable);
            }
        });
        frame.add(statusButton);
    }
}