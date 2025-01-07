package View.AdminView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Controller.Admin.EditEventPrice;

public class EditEventPriceView {

    private JTextField eventIdField;
    private JTextField priceField;
    private JButton updateButton;
    private JLabel statusLabel;

    public EditEventPriceView() {
        initComponent();
    }

    public void initComponent() {
        JFrame frame = new JFrame();
        frame.setTitle("Edit Event Price");
        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(245, 245, 245));

        JLabel eventIdLabel = new JLabel("Event ID:");
        eventIdLabel.setBounds(20, 20, 80, 25);
        frame.add(eventIdLabel);

        eventIdField = new JTextField();
        eventIdField.setBounds(120, 20, 180, 25);
        frame.add(eventIdField);

        JLabel priceLabel = new JLabel("New Price:");
        priceLabel.setBounds(20, 60, 80, 25);
        frame.add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(120, 60, 180, 25);
        frame.add(priceField);

        updateButton = new JButton("Update Price");
        updateButton.setBounds(20, 100, 280, 30);
        frame.add(updateButton);

        statusLabel = new JLabel("Status: ");
        statusLabel.setBounds(20, 140, 280, 25);
        frame.add(statusLabel);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int eventId = Integer.parseInt(eventIdField.getText());
                    double price = Double.parseDouble(priceField.getText());
                    new EditEventPrice(eventId, price);
                    statusLabel.setText("Status: Berhasil update event price.");
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Status: Input Salah, gagal update");
                } catch (Exception ex) {
                    statusLabel.setText("Status: gagal update price.");
                    ex.printStackTrace();
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
