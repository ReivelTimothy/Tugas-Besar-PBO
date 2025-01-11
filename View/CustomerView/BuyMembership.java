package View.CustomerView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.Customer.MembershipController;
import Models.Classess.Memberships;
import Models.Enumeration.Membership;

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
        frame.setBounds(100, 100, 400, 290);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Buy Membership");
        frame.getContentPane().setBackground(Color.getHSBColor(0.6f, 0.7f, 0.9f));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Buy Membership");
        titleLabel.setBounds(140, 20, 200, 30);
        frame.add(titleLabel);

        JButton buyButton = new JButton("Buy Membership");
        buyButton.setBounds(100, 80, 200, 30);
        frame.add(buyButton);
        JButton backButton = new JButton("Back");
        backButton.setBounds(100, 140, 200, 35);
        frame.add(backButton);
        
        frame.setVisible(true);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MembershipController controller = new MembershipController();
                Memberships memberships = new Memberships(Membership.PASSIVE);
        
                boolean isMembershipActive = controller.isMembershipActive();
                if (isMembershipActive) {
                    JOptionPane.showMessageDialog(frame, "You already have an active membership.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean isSuccessful = controller.activateMembership(memberships);
                    if (isSuccessful) {
                        JOptionPane.showMessageDialog(frame, "Membership activated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                        new MainMenuCustomer();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Insufficient balance to activate membership.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenuCustomer();
            }
        });
    }
}
