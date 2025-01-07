package View.AdminView;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.Admin.ViewSellerIncome;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerIncomeView {
     private JTextField sellerIdField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public SellerIncomeView() {
        initComponent();
    }

    public void initComponent() {
        JFrame frame = new JFrame();
        frame.setTitle("Check Seller Income");
        frame.setSize(300, 200);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel sellerIdLabel = new JLabel("Seller ID:");
        sellerIdLabel.setBounds(20, 20, 80, 25);
        frame.add(sellerIdLabel);

        sellerIdField = new JTextField();
        sellerIdField.setBounds(100, 20, 150, 25);
        frame.add(sellerIdField);

        calculateButton = new JButton("Calculate Income");
        calculateButton.setBounds(20, 60, 230, 25);
        frame.add(calculateButton);

        resultLabel = new JLabel("Income: ");
        resultLabel.setBounds(20, 100, 230, 25);
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sellerId = Integer.parseInt(sellerIdField.getText());
                double income = new ViewSellerIncome().CountSellerIncome(sellerId);
                resultLabel.setText("Income: " + income);
            }
        });
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
