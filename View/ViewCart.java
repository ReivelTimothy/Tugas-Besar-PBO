import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.LoginCheck;
import Controller.ViewCartController;
import Models.Classess.User;

public class ViewCart {

    private JFrame frame;
    private JLabel labelUsername;
    private JButton viewButton;
    private JTable cartTable;
    private JScrollPane scrollPane;

    public ViewCart() {
        frame = new JFrame("View Cart");
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        LoginCheck loginCheck = LoginCheck.getInstance();
        User user = loginCheck.getUserLogin();

        labelUsername = new JLabel("User: " + user.getName());
        labelUsername.setBounds(10, 10, 200, 30);
        frame.add(labelUsername);

        cartTable = new JTable();
        scrollPane = new JScrollPane(cartTable);
        scrollPane.setBounds(10, 100, 560, 250);
        frame.add(scrollPane);

        viewButton = new JButton("View Cart");
        viewButton.setBounds(10, 60, 100, 30);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCartController.displayCart(cartTable);
            }
        });
        frame.add(viewButton);
    }
}
