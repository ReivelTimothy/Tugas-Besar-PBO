package View;

import javax.swing.*;

import Controller.LoginSingleton;
import Controller.Seller.GetEventData;
import Controller.Seller.GetEventId;
import Controller.Seller.GetEventWithIncome;

import java.awt.*;
import Models.Classess.Event;
import View.CustomerView.MainMenuCustomer;
import View.SellerView.AddConcert;
import View.SellerView.EventTableView;
import View.SellerView.RequestEditPriceEvent;

import java.io.File;
import java.util.ArrayList;

public class ViewTicket {
    public ViewTicket() {
        // Membuat frame utama
        JFrame frame = new JFrame("VIEW EVENT TICKET");
        frame.setSize(800, 600);
  
        frame.setLayout(new BorderLayout());

        // Membuat panel untuk header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title pada header
        JLabel titleLabel = new JLabel("Welcome to Event Ticketing System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Tombol menu di kanan atas
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton logout = new JButton("Logout");
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton addConcertButton = new JButton("Add Concert");
        JButton viewIncomeButtonSeller = new JButton("View Income");
        JButton viewIncomeButtonAdmin = new JButton("View Income");
        JButton reqEditPrice = new JButton("change Event Price");
        JButton mainMenuCustomer = new JButton("Main Menu");

        if (LoginSingleton.getInstance().getID() == 0) {
            loginButton.setVisible(true);
            registerButton.setVisible(true);
            addConcertButton.setVisible(false);
            viewIncomeButtonSeller.setVisible(false);
            viewIncomeButtonAdmin.setVisible(false);
            logout.setVisible(false);
            reqEditPrice.setVisible(false);
            mainMenuCustomer.setVisible(false);
        } else {
            logout.setVisible(true);
            loginButton.setVisible(false);
            registerButton.setVisible(false);
            if (LoginSingleton.getInstance().getRole() == 0) { // customer
                addConcertButton.setVisible(false);
                viewIncomeButtonSeller.setVisible(false);
                viewIncomeButtonAdmin.setVisible(false);
                reqEditPrice.setVisible(false);
                mainMenuCustomer.setVisible(true);
            } else if (LoginSingleton.getInstance().getRole() == 1) { // seller
                addConcertButton.setVisible(true);
                viewIncomeButtonSeller.setVisible(true);
                viewIncomeButtonAdmin.setVisible(false);
                reqEditPrice.setVisible(true);
                mainMenuCustomer.setVisible(false);
            } else { // admin
                addConcertButton.setVisible(false);
                viewIncomeButtonSeller.setVisible(false);
                viewIncomeButtonAdmin.setVisible(true);
                reqEditPrice.setVisible(false);
                mainMenuCustomer.setVisible(false);
            }
        }
        viewIncomeButtonSeller.addActionListener(e -> {
            frame.dispose();
            int [] arr = GetEventId.getEventIdsBySeller();
            ArrayList<Event> events = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                events.add(GetEventWithIncome.getEventBySeller(arr[i]));
            }
            new EventTableView(events);
        });
        logout.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Terima Kasih Selamat Tinggal ");
            LoginSingleton.getInstance().setNullInstance();
            new ViewTicket();
            frame.dispose();
        });
        loginButton.addActionListener(e -> {
            new Login();
            frame.dispose();
        });
        reqEditPrice.addActionListener(e->{
            new RequestEditPriceEvent();
            frame.dispose();
        });
        registerButton.addActionListener(e -> {
            new Register();
            frame.dispose();
        });
        addConcertButton.addActionListener(e -> {
            new AddConcert();
            frame.dispose();
        });
        mainMenuCustomer.addActionListener(e -> {
            new MainMenuCustomer();
            frame.dispose();
        });

        menuPanel.add(logout);
        menuPanel.add(loginButton);
        menuPanel.add(registerButton);
        menuPanel.add(addConcertButton);
        menuPanel.add(viewIncomeButtonSeller);
        menuPanel.add(viewIncomeButtonAdmin);
        menuPanel.add(reqEditPrice);
        menuPanel.add(mainMenuCustomer);

        headerPanel.add(menuPanel, BorderLayout.EAST);

        frame.add(headerPanel, BorderLayout.NORTH);

        // Panel konten utama
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 2, 10, 10));
        frame.add(new JScrollPane(contentPanel), BorderLayout.CENTER);

        File imageFolder = new File("assets");
        if (imageFolder.exists() && imageFolder.isDirectory()) {
            // Ambil semua file gambar di folder
            File[] imageFiles = imageFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));

            if (imageFiles != null) {
                for (File imageFile : imageFiles) {
                    String fileName = imageFile.getName();

                    JPanel itemPanel = new JPanel();
                    itemPanel.setLayout(new BorderLayout());
                    itemPanel.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.GRAY, 1),
                            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                    ImageIcon originalIcon = new ImageIcon(imageFile.getPath());
                    Image scaledImage = originalIcon.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    JLabel imageLabel = new JLabel(scaledIcon);
                    imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    itemPanel.add(imageLabel, BorderLayout.CENTER);

                    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                    JButton buyNowButton = new JButton("Buy Now");

                    buyNowButton.setFont(new Font("Arial", Font.BOLD, 14));
                    buyNowButton.setPreferredSize(new Dimension(100, 30));
                    buyNowButton.addActionListener(e -> {
                        Event event = GetEventData.getData("assets\\" + fileName);
                        new ViewDetailTicket(event);
                    });
                    buttonPanel.add(buyNowButton);

                    itemPanel.add(buttonPanel, BorderLayout.SOUTH);

                    contentPanel.add(itemPanel);
                }
            } else {
                JLabel errorLabel = new JLabel("No images found in the folder.");
                errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                contentPanel.add(errorLabel);
            }
        } else {
            JLabel errorLabel = new JLabel("The folder 'assets' does not exist.");
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(errorLabel);
        }

        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel footerLabel = new JLabel("Thank you for choosing our service!");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        footerPanel.add(footerLabel);
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
