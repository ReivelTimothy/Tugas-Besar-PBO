package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.CheckBalanceController;
import Controller.LoginCheck;
import Models.Classess.User;

public class CheckBalance {

    private JFrame frame;
    private JLabel labelBalance;
    private JLabel labelUsername;
    private JButton checkBalanceButton;

    public CheckBalance() {
        frame = new JFrame("Check Balance");
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        LoginCheck loginCheck = LoginCheck.getInstance();
        User user = loginCheck.getUserLogin();

        labelUsername = new JLabel("User: " + user.getName());
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
                CheckBalanceController controller = new CheckBalanceController();
                double balance = controller.getBalance();
                labelBalance.setText("Balance: $" + balance);
            }
        });
        frame.add(checkBalanceButton);
    }


}
