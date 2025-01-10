package View.CustomerView;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RefundView {
    public static void main(String[] args) {
        new RefundView();
    }

    public RefundView() {
        JFrame frame = new JFrame("REFUND TICKET");
        frame.setTitle("Delete Event");
        frame.setSize(350, 200);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(245, 245, 245));
        frame.setLocationRelativeTo(null);

        JLabel eventNameLabel = new JLabel("Event Name:");
        eventNameLabel.setBounds(20, 20, 80, 25);
        frame.add(eventNameLabel);

        JTextField eventIdField = new JTextField();
        eventIdField.setBounds(120, 20, 180, 25);
        frame.add(eventIdField);

        JButton requestButton = new JButton("Request Refund Ticket");
        requestButton.setBounds(20, 60, 280, 30);
        frame.add(requestButton);

        JLabel statusLabel = new JLabel("Status: ");
        statusLabel.setBounds(20, 100, 280, 25);
        frame.add(statusLabel);

        requestButton.addActionListener(e -> {
        
            if (new Controller.Customer.getRefundData().requestRefund(eventIdField.getText())) {
                statusLabel.setText("Status : Berhasil Refund Ticket");
            }
           else {
            statusLabel.setText("Status : Gagal Refund Ticket");
           }
        });

        requestButton.setBackground(new Color(0x2d5aed));
        requestButton.setForeground(Color.WHITE);
        requestButton.setFocusPainted(false);
        requestButton.setBorderPainted(false);

     

        frame.getContentPane().setBackground(Color.getHSBColor(0.6f, 0.7f, 0.9f));
        frame.setVisible(true);
    }
}
