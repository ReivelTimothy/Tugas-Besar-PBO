package View.CustomerView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Customer.ControllerUser;
import Controller.Customer.TransactionHistoryController;

public class ViewTransactionHistory {
    private JFrame frame;
    private JLabel labelUsername;
    private JButton statusButton;
    private JTable statusTable;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        new ViewTransactionHistory();
    }

    public ViewTransactionHistory() {
        frame = new JFrame("View Transaction History");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.getHSBColor(0.6f, 0.7f, 0.9f));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        ControllerUser user = new ControllerUser();

        // Label Username
        labelUsername = new JLabel("User: " + user.getName());
        labelUsername.setBounds(10, 10, 200, 30);
        frame.add(labelUsername);

        // Tabel dan ScrollPane
        statusTable = new JTable();
        scrollPane = new JScrollPane(statusTable);
        scrollPane.setBounds(10, 50, 560, 350);
        frame.add(scrollPane);

        statusButton = new JButton("View Transaction History");
        statusButton.setBounds(10, 420, 200, 35);
        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransactionHistoryController.displayMembership(statusTable);
            }
        });
        frame.add(statusButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 470, 200, 35);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenuCustomer();
            }
        });
        frame.add(backButton);
    }
}
