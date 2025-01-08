package View.CustomerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.Customer.MembershipController;

public class BuyMembership {
    private JFrame frame;

    public BuyMembership() {
        membershipBuy();
    }

    public static void main(String[] args) {
        new BuyMembership();
    }

    private void membershipBuy() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 200);
        frame.setTitle("Buy Membership");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Buy Membership");
        titleLabel.setBounds(140, 20, 200, 30);
        frame.add(titleLabel);

        JButton buyButton = new JButton("Buy Membership");
        buyButton.setBounds(100, 80, 200, 30);
        frame.add(buyButton);

        frame.setVisible(true);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isSuccessful = MembershipController.activateMembership();
                if (isSuccessful) {
                    JOptionPane.showMessageDialog(frame, "Membership activated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient balance to activate membership.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
