package View;
  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.CartControllerAdd;

public class Addtocart {

    private JTextField eventIdField;
    private JTextField ticketIdField;
    private JTextField custIdField;
    private JButton addButton;
    private JButton cancelButton;

    public Addtocart() {
        JFrame frame = new JFrame("Add to Cart");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel eventIdLabel = new JLabel("Event ID:");
        eventIdLabel.setBounds(50, 60, 100, 25);
        frame.add(eventIdLabel);

        eventIdField = new JTextField();
        eventIdField.setBounds(150, 60, 200, 25);
        frame.add(eventIdField);

        JLabel ticketIdLabel = new JLabel("Ticket ID:");
        ticketIdLabel.setBounds(50, 100, 100, 25);
        frame.add(ticketIdLabel);

        ticketIdField = new JTextField();
        ticketIdField.setBounds(150, 100, 200, 25);
        frame.add(ticketIdField);

        JLabel custIdLabel = new JLabel("Customer ID:");
        custIdLabel.setBounds(50, 140, 100, 25);
        frame.add(custIdLabel);

        custIdField = new JTextField();
        custIdField.setBounds(150, 140, 200, 25);
        frame.add(custIdField);

        addButton = new JButton("Add to Cart");
        addButton.setBounds(50, 200, 120, 30);
        frame.add(addButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(230, 200, 120, 30);
        frame.add(cancelButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eventId = eventIdField.getText();
                String ticketId = ticketIdField.getText();
                String custId = custIdField.getText();
        
                if (eventId.isEmpty() || ticketId.isEmpty() || custId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                try {
                    int eventid = Integer.parseInt(eventId);
        
                    boolean success = CartControllerAdd.addToCart(eventid, ticketId, custId);
                    if (success) {
                        JOptionPane.showMessageDialog(frame, "Item added to cart successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Failed to add item to cart!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Event ID must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
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

        frame.setVisible(true);
    }
}
