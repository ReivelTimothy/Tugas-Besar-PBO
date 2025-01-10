package View.CustomerView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Customer.ControllerCart;
import Controller.Customer.ControllerUser;
import Controller.Customer.FinishTransactionController;

public class FinishTransaction {

    private JFrame frame;
    private ControllerCart controllerCart;
    private JTable cartTable;
    private JButton finishButton;
    private JButton exitButton;

    public FinishTransaction() {
        transaction();
    }
    public void transaction() {

        FinishTransactionController transaction = new FinishTransactionController();

        controllerCart = new ControllerCart();
        double totalAmount = controllerCart.getTotalAmount();

        ControllerUser user = new ControllerUser();
        double balance = user.getBalance();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        final int FRAME_WIDTH = 600;
        final int FRAME_HEIGHT = 500;

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);

        Font buttonFont = new Font("SansSerif", Font.BOLD, 16);
        Font labelFont = new Font("SansSerif", Font.BOLD, 18);

        frame = new JFrame("Finish Transaction");
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(45, 52, 54));
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        JLabel title = new JLabel("Total Amount: Rp. " + totalAmount);
        title.setBounds(50, 40, 500, 40);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        panel.add(title);

        JLabel balanceLabel = new JLabel("Current Balance: Rp. " + balance);
        balanceLabel.setBounds(50, 100, 500, 30);
        balanceLabel.setFont(labelFont);
        balanceLabel.setForeground(Color.WHITE);
        panel.add(balanceLabel);

        Object[][] data = transaction.getCartItems();
        String[] columnNames = {"Select", "Cart ID", "Event Name", "Price", "Quantity", "Total Price"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        cartTable = new JTable(model);
        cartTable.setBounds(50, 140, 500, 150);
        cartTable.setBackground(new Color(34, 40, 44));
        cartTable.setForeground(Color.WHITE);
        cartTable.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(cartTable);
        scrollPane.setBounds(50, 140, 500, 150);
        panel.add(scrollPane);

        finishButton = new JButton("Finish Transaction");
        finishButton.setBounds(150, 320, 300, 50);
        finishButton.setFont(buttonFont);
        finishButton.setBackground(new Color(0, 184, 148));
        finishButton.setForeground(Color.WHITE);
        finishButton.addActionListener(e -> {
            int[] selectedRows = cartTable.getSelectedRows();
            if (selectedRows.length > 0) {
                List<Integer> selectedCartIds = new ArrayList<>();
                for (int row : selectedRows) {
                    int cartId = (int) cartTable.getValueAt(row, 1);
                    selectedCartIds.add(cartId);
                }

                if (transaction.processTransaction(selectedCartIds, balance)) {
                    JOptionPane.showMessageDialog(frame, "Transaction Successful! New Balance: Rp. " + user.getBalance());
                    frame.dispose();
                    new MainMenuCustomer();
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient Balance.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select at least one item.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
        panel.add(finishButton);

        exitButton = new JButton("Cancel Transaction");
        exitButton.setBounds(150, 380, 300, 50);
        exitButton.setFont(buttonFont);
        exitButton.setBackground(new Color(214, 48, 49));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> {
            frame.dispose();
            new MainMenuCustomer();
        });
        panel.add(exitButton);

        frame.add(panel);
        
    }

    public static void main(String[] args) {
        new FinishTransaction();
    }
}
