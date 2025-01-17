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
import Controller.Customer.ViewCartController;

public class ViewCart {

    private JFrame frame;
    private JLabel labelUsername;
    private JButton viewButton;
    private JTable cartTable;
    private JScrollPane scrollPane;

    public ViewCart() {
        frame = new JFrame("View Cart");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(Color.getHSBColor(0.6f, 0.7f, 0.9f));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        ControllerUser controller = new ControllerUser();
        
        String name = controller.getName();

        labelUsername = new JLabel("User: " + name);
        labelUsername.setBounds(10, 10, 200, 30);
        frame.add(labelUsername);

        cartTable = new JTable();
        scrollPane = new JScrollPane(cartTable);
        scrollPane.setBounds(10, 100, 560, 250);
        frame.add(scrollPane);

        viewButton = new JButton("View Cart");
        viewButton.setBounds(10, 60, 100, 30);

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 360, 100, 30);
        frame.add(backButton);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCartController.displayCart(cartTable);
            }
        });
        frame.add(viewButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenuCustomer();
            }
        });

        frame.add(backButton);
    }
    public static void main(String[] args) {
        new ViewCart();
    }
}
