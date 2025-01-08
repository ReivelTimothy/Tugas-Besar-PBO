package View.AdminView;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.Admin.EditBlock;
import Models.Enumeration.statusBlocked;

public class BlockUserView {
    private JTextField userIdField;
    private JTextField reasonField;
    private JRadioButton customerButton;
    private JRadioButton sellerButton;
    private JRadioButton blockButton;
    private JRadioButton unblockButton;
    private JButton executeButton;
    private JLabel statusLabel;

    public BlockUserView() {
        initComponent();
    }

    public void initComponent() {
        JFrame frame = new JFrame();
        frame.setTitle("Block/Unblock User");
        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(245, 245, 245));

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(20, 20, 80, 25);
        frame.add(userIdLabel);

        userIdField = new JTextField();
        userIdField.setBounds(120, 20, 200, 25);
        frame.add(userIdField);

        JLabel reasonLabel = new JLabel("Reason:");
        reasonLabel.setBounds(20, 60, 80, 25);
        frame.add(reasonLabel);

        reasonField = new JTextField();
        reasonField.setBounds(120, 60, 200, 25);
        frame.add(reasonField);

        customerButton = new JRadioButton("Customer");
        customerButton.setBounds(120, 100, 100, 25);
        customerButton.setBackground(new Color(245, 245, 245));
        frame.add(customerButton);

        sellerButton = new JRadioButton("Seller");
        sellerButton.setBounds(220, 100, 100, 25);
        sellerButton.setBackground(new Color(245, 245, 245));
        frame.add(sellerButton);

        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(customerButton);
        roleGroup.add(sellerButton);

        blockButton = new JRadioButton("Block");
        blockButton.setBounds(120, 140, 100, 25);
        blockButton.setBackground(new Color(245, 245, 245));
        frame.add(blockButton);

        unblockButton = new JRadioButton("Unblock");
        unblockButton.setBounds(220, 140, 100, 25);
        unblockButton.setBackground(new Color(245, 245, 245));
        frame.add(unblockButton);

        ButtonGroup actionGroup = new ButtonGroup();
        actionGroup.add(blockButton);
        actionGroup.add(unblockButton);

        executeButton = new JButton("Execute");
        executeButton.setBounds(120, 180, 200, 30);
        frame.add(executeButton);

        statusLabel = new JLabel("Status: ");
        statusLabel.setBounds(20, 220, 340, 25);
        frame.add(statusLabel);

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int userId = Integer.parseInt(userIdField.getText());
                    int role = customerButton.isSelected() ? 0 : 1;
                    statusBlocked status = blockButton.isSelected() ? statusBlocked.BLOCKED : statusBlocked.UNBLOCK;
                    String reason = blockButton.isSelected() ? reasonField.getText() : null;

                    if (status.equals(statusBlocked.BLOCKED)) {
                        if (new EditBlock().checkBlock(userId, role)) {
                            new EditBlock().Block(userId, reason, role);
                            statusLabel.setText("Status: User berhasil di" + status.toString().toLowerCase());
                        } else {
                            statusLabel.setText("Status: User sudah ada di list block");
                        }
                    } else {
                        new EditBlock().Unblock(userId, role);
                        statusLabel.setText("Status: User berhasil " + status.toString().toLowerCase());
                    }

                } catch (NumberFormatException ex) {
                    statusLabel.setText("Status: Invalid input.");
                } catch (Exception ex) {
                    statusLabel.setText("Status: Error executing action.");
                    ex.printStackTrace();
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
