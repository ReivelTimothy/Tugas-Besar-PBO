package View.CustomerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.Customer.CheckBalanceController;

public class CheckBalance {

    private JFrame frame;
    private JLabel labelBalance;
    private JLabel labelUsername;
    private JButton checkBalanceButton;

    public static void main(String[] args) {
        new CheckBalance();
    }
    
    public CheckBalance() {
        frame = new JFrame("Check Balance");
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        CheckBalanceController controller = new CheckBalanceController();
        String name = controller.getName();

        labelUsername = new JLabel("User: " + name);
        labelUsername.setBounds(10, 10, 200, 30);
        frame.add(labelUsername);

        labelBalance = new JLabel("Balance: $0.00");
        labelBalance.setBounds(10, 50, 200, 30);
        frame.add(labelBalance);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(10, 90, 150, 30);
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double balance = controller.getBalance();
                labelBalance.setText("Balance: $" + balance);
            }
        });
        frame.add(checkBalanceButton);
    }


}
