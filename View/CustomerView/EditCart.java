package View.CustomerView;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditCart {

    private JTextField cartIdField;
    private JTextField eventIdField;
    private JTextField ticketIdField;
    private JTextField customerIdField;
    private JButton updateButton;
    private JButton cancelButton;

    public EditCart() {
        JFrame frame = new JFrame("Edit Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Cart ID :"));
        cartIdField = new JTextField();
        cartIdField.setEditable(false);
        panel.add(cartIdField);

        panel.add(new JLabel("Event ID :"));
        eventIdField = new JTextField();
        panel.add(eventIdField);

        panel.add(new JLabel("Ticket ID :"));
        ticketIdField = new JTextField();
        panel.add(ticketIdField);

        panel.add(new JLabel("Customer ID :"));
        customerIdField = new JTextField();
        panel.add(customerIdField);

        updateButton = new JButton("Update");
        cancelButton = new JButton("Cancel");
        panel.add(updateButton);
        panel.add(cancelButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cartId = cartIdField.getText();
                String eventId = eventIdField.getText();
                String ticketId = ticketIdField.getText();
                String customerId = customerIdField.getText();
        
                if (cartId.isEmpty() || eventId.isEmpty() || ticketId.isEmpty() || customerId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                boolean success = Controller.Customer.EditedCart.editCart(cartId, eventId, ticketId, customerId);
        
                if (success) {
                    JOptionPane.showMessageDialog(frame, "Cart updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Failed to update cart!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenuCustomer();
            }
        });

        frame.add(panel);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EditCart();
    }
}
