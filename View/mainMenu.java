package View;

import java.awt.Font;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainMenu {
    Frame frame;
    public mainMenu() {
        showMainMenu();
    }

    public static void main(String[] args) {
        new mainMenu(); // 
        new mainMenu().showMainMenu();
    }

    public void showMainMenu() {
        frame = new JFrame("Main Menu");
        frame.setBounds(50, 50, 450, 800); // Tambahkan ini agar frame bisa ditutup

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 450, 800);

        JLabel title2 = new JLabel("==TIKETHB==");
        title2.setBounds(105, 50, 200, 50); // Sesuaikan ukuran label
        title2.setFont(new Font("SansSerif", Font.BOLD, 24));
        panel.add(title2);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(10, 130, 260, 50);
        panel.add(loginBtn);

        loginBtn.addActionListener(e -> {
            frame.dispose();
            new Login(); // Pastikan kelas Login ada
        });

        JButton registerBtn = new JButton("REGISTER");
        registerBtn.setBounds(10, 200, 260, 50);
        panel.add(registerBtn); // Perbaiki kesalahan pada add registerBtn

        JButton exitBtn = new JButton("EXIT");
        exitBtn.setBounds(10, 270, 260, 50);
        panel.add(exitBtn);

        exitBtn.addActionListener(e -> frame.dispose());

        frame.add(panel);
        frame.setVisible(true);
    }
}
