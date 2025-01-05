package View;

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

import Controller.ControllerCart;

public class FinishTransaction {

    private JFrame frame;
    private ControllerCart controllerCart;

    public FinishTransaction(ControllerCart controllerCart) {
        this.controllerCart = controllerCart;
        transaction();
    }

    public void transaction() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 400;

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);

        Font buttonFont = new Font("SansSerif", Font.BOLD, 18);

        frame = new JFrame("Finish Transaction");
        frame.setUndecorated(true);
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT);
        frame.setShape(new RoundRectangle2D.Double(0, 0, FRAME_WIDTH, FRAME_HEIGHT, 30, 30));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0.6f, 0.7f, 0.9f));
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        double totalAmount = controllerCart.getTotalAmount();
        JLabel title = new JLabel("Total Amount: Rp. " + totalAmount);
        title.setBounds(50, 50, 400, 30);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        panel.add(title);

        JLabel paymentLabel = new JLabel("Enter Payment Amount:");
        paymentLabel.setBounds(120, 120, 300, 30);
        paymentLabel.setForeground(Color.WHITE);
        panel.add(paymentLabel);

        JTextField inputPayment = new JTextField(16);
        inputPayment.setHorizontalAlignment(JTextField.CENTER);
        inputPayment.setBorder(BorderFactory.createEmptyBorder());
        inputPayment.setBounds(120, 160, 260, 40);
        panel.add(inputPayment);

        JButton finishButton = new JButton("Finish Transaction");
        finishButton.setBounds(120, 220, 260, 50);
        finishButton.setFont(buttonFont);
        finishButton.setBackground(new Color(3, 123, 252));
        finishButton.setForeground(Color.WHITE);
        finishButton.addActionListener(e -> {
            try {
                String paymentInput = inputPayment.getText();
                double payment = Double.parseDouble(paymentInput);

                if (controllerCart.processTransaction(payment)) {
                    double change = payment - totalAmount;

                    JOptionPane.showMessageDialog(frame, "Transaction Successful! Change: Rp. " + change);

                    // Reset fields
                    inputPayment.setText("");
                    frame.dispose(); // Close frame after successful transaction
                    new MainMenuCustomer(); // Redirect to main menu
                } else {
                    JOptionPane.showMessageDialog(frame, "Payment is insufficient.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(finishButton);

        JButton exitButton = new JButton("Cancel Transaction");
        exitButton.setBounds(120, 290, 260, 50);
        exitButton.setFont(buttonFont);
        exitButton.setBackground(new Color(255, 69, 58));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> {
            frame.dispose();
            new MainMenuCustomer(); // Redirect to main menu
        });
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
