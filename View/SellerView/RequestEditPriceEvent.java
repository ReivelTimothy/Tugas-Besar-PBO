package View.SellerView;

import java.awt.*;
import javax.swing.*;

import Controller.Seller.UpdateEventPrice;
import View.ViewTicket;

public class RequestEditPriceEvent {
    public RequestEditPriceEvent() {
        JFrame frame = createJframe("Edit Event Price");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label and TextField for Event ID
        JLabel eventIdLabel = createLabel("Event ID:");
        JTextField eventIdField = createJTextField();
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(eventIdLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(eventIdField, gbc);

        // Label and TextField for New Price
        JLabel priceLabel = createLabel("New Price:");
        JTextField priceField = createJTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(priceLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(priceField, gbc);

        // Submit Button
        JButton submitButton = createJButton("Update Price");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(submitButton, gbc);

        // Action Listener for Submit Button
        submitButton.addActionListener(e -> {
            String priceText = priceField.getText();
            String eventIdText = eventIdField.getText();
            try {
                int eventId = Integer.parseInt(eventIdText);
                double price = Double.parseDouble(priceText);
                UpdateEventPrice.updateEventPrice(eventId, price);
                frame.dispose();
                new ViewTicket();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input! Please enter numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public JFrame createJframe(String txt) {
        JFrame jFrame = new JFrame(txt);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 200);
        jFrame.setResizable(false);
        return jFrame;
    }

    public JButton createJButton(String txt) {
        return new JButton(txt);
    }

    public JTextField createJTextField() {
        JTextField jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(150, 30));
        return jTextField;
    }

    public JLabel createLabel(String txt) {
        JLabel label = new JLabel(txt);
        label.setFont(new Font(null, Font.PLAIN, 12));
        return label;
    }
}
