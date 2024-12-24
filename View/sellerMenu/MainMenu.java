package view.sellerMenu;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu {
    public MainMenu() {
        // Create frame for seller menu
        JFrame frame = new JFrame("SELLER MENU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Master panel with vertical layout
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new GridLayout(4, 1, 10, 10)); // Grid layout with 4 rows and 1 column
        masterPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create title label
        JLabel titleLabel = new JLabel("SELLER MENU", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Create buttons
        JButton createEventButton = new JButton("CREATE AN EVENT");
        JButton checkEventButton = new JButton("SEE YOUR EVENT's");
        JButton exitButton = new JButton("Exit");

        // Add action listeners to buttons


        createEventButton.addActionListener(e ->{
            new AddConcert();
            frame.dispose();
        });

        checkEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to check owned events
                System.out.println("Check Event button clicked");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                System.out.println("Exit button clicked");
                frame.dispose();
            }
        });

        // Add components to the master panel
        masterPanel.add(titleLabel);
        masterPanel.add(createEventButton);
        masterPanel.add(checkEventButton);
        masterPanel.add(exitButton);

        // Add master panel to the frame
        frame.add(masterPanel);

        // Display the frame
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
