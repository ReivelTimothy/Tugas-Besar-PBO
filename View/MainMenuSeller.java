package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuSeller {
    private JFrame frame;

    public static void main(String[] args) {
        new MainMenuSeller().showMainMenu();
    }

    public void showMainMenu() {
        frame = new JFrame("Main Menu");
        frame.setBounds(50, 50, 450, 800); // SET FRAME BOUND
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 450, 800);

        JLabel title2 = new JLabel("==TIKETHB==");
        title2.setBounds(125, 50, 200, 50);
        title2.setFont(new Font("SansSerif", Font.BOLD, 24));
        panel.add(title2);



        JButton createBtn = new JButton("Create Event");
        createBtn.setBounds(95, 150, 260, 50);
        panel.add(createBtn);

        createBtn.addActionListener(e -> {
            new Create();
        });



        JButton reqEditBtn = new JButton("Request Edit Price Event");
        reqEditBtn.setBounds(95, 230, 260, 50);
        panel.add(reqEditBtn);

        reqEditBtn.addActionListener(e -> {
            new RequestEditPriceEvent();
        });





        JButton exitBtn = new JButton("EXIT");
        exitBtn.setBounds(95, 310, 260, 50);
        panel.add(exitBtn);

        exitBtn.addActionListener(e -> {
            frame.dispose();
        });




        
        frame.add(panel);
        frame.setVisible(true);
    }
}
