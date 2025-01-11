package View.AdminView;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.Admin.RefundTicketUser;
import Models.Enumeration.RefundStatus;
import Models.Enumeration.statusBlocked;

public class RefundTicketApproveView {
    public RefundTicketApproveView() {
        init();
    }

    public void init() {
        JFrame frame = new JFrame("Refund Ticket User");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel eventIDLabel = new JLabel("Event ID:");
        eventIDLabel.setBounds(30, 30, 100, 30);
        frame.add(eventIDLabel);

        JTextField eventIDField = new JTextField();
        eventIDField.setBounds(140, 30, 200, 30);
        frame.add(eventIDField);

        JLabel custIdLabel = new JLabel("Customer ID:");
        custIdLabel.setBounds(30, 70, 100, 30);
        frame.add(custIdLabel);

        JTextField custIdField = new JTextField();
        custIdField.setBounds(140, 70, 200, 30);
        frame.add(custIdField);

        JRadioButton approveButton = new JRadioButton("Approve");
        approveButton.setBounds(80, 110, 100, 30);
        frame.add(approveButton);
        approveButton.setBackground(new Color(0x2d5aed));
        approveButton.setForeground(Color.WHITE);
        approveButton.setFocusPainted(false);
        approveButton.setBorderPainted(false);

        JRadioButton rejectButton = new JRadioButton("Reject");
        rejectButton.setBounds(180, 110, 100, 30);
        frame.add(rejectButton);
        rejectButton.setBackground(new Color(0x2d5aed));
        rejectButton.setForeground(Color.WHITE);
        rejectButton.setFocusPainted(false);
        rejectButton.setBorderPainted(false);

        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(approveButton);
        statusGroup.add(rejectButton);

        JButton refundButton = new JButton("Proceed");
        refundButton.setBounds(140, 180, 100, 30);
        frame.add(refundButton);
        refundButton.setBackground(new Color(0x2d5aed));
        refundButton.setForeground(Color.WHITE);
        refundButton.setFocusPainted(false);
        refundButton.setBorderPainted(false);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(120, 230, 300, 30);
        resultLabel.setVisible(false);
        frame.add(resultLabel);

        refundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RefundStatus status = approveButton.isSelected() ? RefundStatus.APPROVED : RefundStatus.REJECTED;
                int eventId = Integer.parseInt(eventIDField.getText());
                int custId = Integer.parseInt(custIdField.getText());
                
                new RefundTicketUser().Refund(custId, eventId, status);
                resultLabel.setText("Refund ticket user status : " + status);
                resultLabel.setVisible(true);
                // if (success) {
                // resultLabel.setText("Refund approved successfully.");
                // } else {
                // resultLabel.setText("Refund approval failed.");
                // }
            }
        });
        frame.getContentPane() .setBackground(new Color(0x567af0));
       
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
