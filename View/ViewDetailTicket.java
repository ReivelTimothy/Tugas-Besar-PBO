package View;

import Models.Classess.*;
import Models.Classess.Event;
import Models.Enumeration.EventCat;

import javax.swing.*;

import java.awt.*;

public class ViewDetailTicket extends JFrame {

    public ViewDetailTicket(Event event) {
        // Set frame properties
        setTitle("Event Details - " + event.getTitle());
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel with back button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        JButton backButton = new JButton("<- Back");
        backButton.addActionListener(e -> {
            dispose();
        });
        topPanel.add(backButton);
        add(topPanel, BorderLayout.NORTH);

        // Main content panel with image and details
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add image on the left with decorative border
        if (event.getPath() != null && !event.getPath().isEmpty()) {
            ImageIcon imageIcon = new ImageIcon(event.getPath());
            Image scaledImage = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            contentPanel.add(imageLabel, BorderLayout.WEST);
        }

        // Add details on the right
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        JLabel titleLabel = new JLabel(event.getTitle());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        detailsPanel.add(titleLabel);
        detailsPanel.add(Box.createVerticalStrut(10)); // Spacer

        JLabel descLabel = new JLabel("Description: " + event.getDesc());
        descLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel priceLabel = new JLabel("Price: $" + event.getPrice());
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel capacityLabel = new JLabel("Capacity: " + event.getCapacity());
        capacityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        capacityLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel dateLabel = new JLabel("Date: " + event.getTanggal());
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);



        detailsPanel.add(descLabel);
        detailsPanel.add(priceLabel);
        detailsPanel.add(capacityLabel);
        detailsPanel.add(dateLabel);

        detailsPanel.add(Box.createVerticalStrut(10)); 

        if (event.getCategory() == EventCat.MUSIC) {
            EventConcert concert = (EventConcert) event;
            JLabel concertTypeLabel = new JLabel("Concert Type: " + concert.getJenisKonser());
            concertTypeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            JLabel singerLabel = new JLabel("Singer: " + concert.getSinger());
            singerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            detailsPanel.add(concertTypeLabel);
            detailsPanel.add(singerLabel);
        } else if (event.getCategory() == EventCat.EDUCATION) {
            EventEducation education = (EventEducation) event;
            JLabel speakerLabel = new JLabel("Speaker: " + education.getNamaPembicara());
            speakerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            detailsPanel.add(speakerLabel);
        } else if (event.getCategory() == EventCat.SPORT) {
            EventSport sport = (EventSport) event;
            JLabel sportTypeLabel = new JLabel("Sport Type: " + sport.getJenisSport());
            sportTypeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            detailsPanel.add(sportTypeLabel);
        }

        contentPanel.add(detailsPanel, BorderLayout.CENTER);

        // Add footer panel for spacing and balance
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel footerLabel = new JLabel("Thank you for using our service!");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        footerPanel.add(footerLabel);
        add(footerPanel, BorderLayout.SOUTH);

        // Add content panel to frame
        add(contentPanel, BorderLayout.CENTER);

        // Display the frame
        setVisible(true);
    }

    // Test the ViewDetailTicket class
}
