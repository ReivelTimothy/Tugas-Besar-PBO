package View.CustomerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Customer.ControllerUser;
import Controller.Customer.StatusMembershipController;
import Controller.Customer.getRefundData;

public class RefundView {
    private JFrame frame;
    private JButton statusButton;
    private JTable statusTable;

    public static void main(String[] args) {
        new RefundView();
    }

    public RefundView() {
        frame = new JFrame("Refund Ticket");
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel eventLabel = new JLabel("Event : ");
        eventLabel.setBounds(30, 0, 0, 0);

        new getRefundData();
        // getRefundData.displayRefund(statusTable);

        frame.add(statusButton);
    }
}
