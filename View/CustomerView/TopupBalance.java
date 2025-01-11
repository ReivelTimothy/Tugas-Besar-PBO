package View.CustomerView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Customer.ControllerUser;

public class TopupBalance {

    private JFrame frame;

    public TopupBalance() {
        showTopUpBalance();
    }

    public void showTopUpBalance() {

        ControllerUser controller = new ControllerUser();
        Double currentBalance = controller.getBalance();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 400;

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);

        frame = new JFrame("Top-Up Balance");
        frame.setUndecorated(true);
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT);
        frame.getContentPane().setBackground(Color.getHSBColor(0.6f, 0.7f, 0.9f));
        frame.setShape(new RoundRectangle2D.Double(0, 0, FRAME_WIDTH, FRAME_HEIGHT, 30, 30));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0.6f, 0.7f, 0.9f));
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        JLabel title = new JLabel("Your Current Balance: Rp. " + currentBalance);
        title.setBounds(50, 50, 400, 30);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setForeground(Color.BLACK);
        panel.add(title);

        JLabel saldoLabel = new JLabel("Enter Amount to Top-Up: ");
        saldoLabel.setBounds(120, 120, 300, 30);
        saldoLabel.setForeground(Color.BLACK); // Black text
        panel.add(saldoLabel);

        JTextField inputSaldo = new JTextField(16);
        inputSaldo.setHorizontalAlignment(JTextField.CENTER);
        inputSaldo.setBorder(BorderFactory.createEmptyBorder());
        inputSaldo.setBounds(120, 160, 260, 40);
        panel.add(inputSaldo);

        JButton topUpButton = new JButton("TOP UP!");
        topUpButton.setBounds(120, 220, 260, 50);
        topUpButton.addActionListener(e -> {
            try {
                String saldoInput = inputSaldo.getText();
                double amount = Double.parseDouble(saldoInput);

                if (amount <= 0) {
                    JOptionPane.showMessageDialog(frame, "Amount must be positive.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double newBalance = currentBalance + amount;
                controller.setBalance(newBalance);

                JOptionPane.showMessageDialog(frame, "Top-Up Successful! Balance: Rp. " + newBalance);

                title.setText("Balance: Rp. " + newBalance);
                inputSaldo.setText("");
                frame.dispose();
                new MainMenuCustomer();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(topUpButton);

        JButton exitButton = new JButton("Back");
        exitButton.setBounds(120, 290, 260, 50);
        exitButton.addActionListener(e -> {
            frame.dispose();
            new MainMenuCustomer();
        });
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TopupBalance();
    }
}
