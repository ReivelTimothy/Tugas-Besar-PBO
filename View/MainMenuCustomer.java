package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ViewCart;
import Controller.ViewStatusMembership;
import Controller.ViewTransactionHistory;

public class MainMenuCustomer {

    private JFrame frame;

    public MainMenuCustomer() {
        showMainMenuCustomer();
    }

    public void showMainMenuCustomer() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        final int FRAME_WIDTH = 600;
        final int FRAME_HEIGHT = 800;

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);

        Font titleFont = new Font("SansSerif", Font.BOLD, 22);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 18);

        frame = new JFrame("Main Menu - Customer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0x567af0));
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        JLabel title = new JLabel("Customer Main Menu");
        title.setBounds(180, 30, 300, 30);
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        panel.add(title);

        JButton addToCartButton = createButton("Add to Cart", 120, 100, buttonFont);
        addToCartButton.addActionListener(e -> {
            frame.dispose();
            new Addtocart();
        });
        panel.add(addToCartButton);

        JButton viewCartButton = createButton("View Cart", 120, 160, buttonFont);
        viewCartButton.addActionListener(e -> {
            frame.dispose();
            new ViewCart();
        });
        panel.add(viewCartButton);

        JButton editCartButton = createButton("Edit Cart", 120, 220, buttonFont);
        editCartButton.addActionListener(e -> {
            frame.dispose();
            new EditCart();
        });
        panel.add(editCartButton);

        JButton finishTransactionButton = createButton("Finish Transaction", 120, 280, buttonFont);
        finishTransactionButton.addActionListener(e -> {
            frame.dispose();
            new FinishTransaction();
        });
        panel.add(finishTransactionButton);

        JButton checkBalanceButton = createButton("Check Balance", 120, 340, buttonFont);
        checkBalanceButton.addActionListener(e -> {
            frame.dispose();
            new CheckBalance();
        });
        panel.add(checkBalanceButton);

        JButton updateProfileButton = createButton("Update Profile", 120, 400, buttonFont);
        updateProfileButton.addActionListener(e -> {
            frame.dispose();
            new UpdateProfile();
        });
        panel.add(updateProfileButton);

        JButton viewMembershipButton = createButton("View Membership Status", 120, 460, buttonFont);
        viewMembershipButton.addActionListener(e -> {
            frame.dispose();
            new ViewStatusMembership();
        });
        panel.add(viewMembershipButton);

        JButton transactionHistoryButton = createButton("View Transaction History", 120, 520, buttonFont);
        transactionHistoryButton.addActionListener(e -> {
            frame.dispose();
            new ViewTransactionHistory();
        });
        panel.add(transactionHistoryButton);

        JButton topUpBalanceButton = createButton("Top-Up Balance", 120, 580, buttonFont);
        topUpBalanceButton.addActionListener(e -> {
            frame.dispose();
            new TopupBalance();
        });
        panel.add(topUpBalanceButton);

        JButton buyMembershipButton = createButton("Buy Membership", 120, 640, buttonFont);
        buyMembershipButton.addActionListener(e -> {
            frame.dispose();
            new BuyMembership();
        });
        panel.add(buyMembershipButton);

        JButton feedbackButton = createButton("Feedback", 120, 700, buttonFont);
        feedbackButton.addActionListener(e -> {
            frame.dispose();
            new Feedback();
        });
        panel.add(feedbackButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private JButton createButton(String text, int x, int y, Font font) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 360, 50);
        button.setFont(font);
        button.setBackground(new Color(0x2d5aed));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        return button;
    }
}
