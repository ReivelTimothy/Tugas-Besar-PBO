package View.SellerView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RequestEditPriceEvent {
    public static void main(String[] args) {
        RequestEditPriceEvent editPriceEvent = new RequestEditPriceEvent();

        JFrame frame = editPriceEvent.createJframe("Edit Event Price");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel priceLabel = editPriceEvent.createLabel("New Price:", 0, 0);
        JTextField priceField = editPriceEvent.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(priceLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        frame.add(priceField, gbc);

        JButton submitButton = editPriceEvent.createJButton("Update Price");
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String priceText = priceField.getText();
            double price;

            try {
                price = Double.parseDouble(priceText);
                JOptionPane.showMessageDialog(frame, "Price updated to: " + price, "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid price format! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
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
        JButton jButton = new JButton(txt);
        return jButton;
    }

    public JTextField createJTextField(int marginLeft, int marginTop) {
        JTextField jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(150, 30));
        return jTextField;
    }

    public JLabel createLabel(String txt, int marginLeft, int marginTop) {
        JLabel label = new JLabel(txt);
        label.setFont(new Font(null, Font.PLAIN, 12));
        return label;
    }
}
