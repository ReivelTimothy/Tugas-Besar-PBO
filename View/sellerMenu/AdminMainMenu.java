package view.sellerMenu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminMainMenu {
    public static void main(String[] args) {
        new AdminMainMenu().showMenu();
    }

    public AdminMainMenu() {
        showMenu();
    }

    void showMenu() {
        JFrame frame = new JFrame("Admin Menu");
        frame.setBounds(50, 50, 450, 800); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 450, 800);

        JLabel title2 = new JLabel("==TIKETHB==");
        title2.setBounds(125, 50, 200, 50);
        panel.add(title2);

        JButton addConcertBtn = new JButton("Add Concert");
        addConcertBtn.setBounds(95, 150, 260, 50);
        panel.add(addConcertBtn);

        addConcertBtn.addActionListener(e -> {
            frame.dispose();
            new AddConcert();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
