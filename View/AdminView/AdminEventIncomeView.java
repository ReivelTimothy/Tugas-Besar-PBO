package View.AdminView;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.Admin.AdminEventIncome;

public class AdminEventIncomeView {

    public AdminEventIncomeView() {
        init();
    }

    public void init() {

        JFrame frame = new JFrame("Income Admin per Event");
        frame.setSize(400, 250);
        frame.setLayout(null); // Menggunakan null layout untuk setBounds

        // Tombol untuk "Semua Event"
        JButton allEventsButton = new JButton("Semua Event");
        allEventsButton.setBounds(30, 30, 150, 30);
        frame.add(allEventsButton);

        // Tombol untuk "Event Tertentu"
        JButton specificEventButton = new JButton("Event Tertentu");
        specificEventButton.setBounds(200, 30, 150, 30);
        frame.add(specificEventButton);

        specificEventButton.setBackground(new Color(0x2d5aed));
        specificEventButton.setForeground(Color.WHITE);
        specificEventButton.setFocusPainted(false);
        specificEventButton.setBorderPainted(false);
        // Membuat label dan text field untuk input event ID
        JLabel eventIdLabel = new JLabel("Event ID:");
        eventIdLabel.setBounds(30, 80, 80, 30);
        frame.add(eventIdLabel);
      
        JTextField eventIdField = new JTextField();
        eventIdField.setBounds(120, 80, 230, 30);
        frame.add(eventIdField);

        // Tombol hitung
        JButton calculateButton = new JButton("Hitung");
        calculateButton.setBounds(150, 130, 100, 30);
        frame.add(calculateButton);
        calculateButton.setVisible(false);

        calculateButton.setBackground(new Color(0x2d5aed));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setBorderPainted(false);
        // Label untuk menampilkan hasil
        JLabel resultLabel = new JLabel("Hasil akan ditampilkan di sini.");
        resultLabel.setBounds(30, 180, 300, 30);
        frame.add(resultLabel);

        allEventsButton.setBackground(new Color(0x2d5aed));
        allEventsButton.setForeground(Color.WHITE);
        allEventsButton.setFocusPainted(false);
        allEventsButton.setBorderPainted(false);

        allEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventIdLabel.setVisible(false);
                eventIdField.setVisible(false);
                calculateButton.setVisible(false);
        
                double totalIncome = new AdminEventIncome().AllEventAdminIncome();
                resultLabel.setText("Pendapatan dari semua event: Rp " + totalIncome);
            }
        });

        specificEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventIdLabel.setVisible(true);
                eventIdField.setVisible(true);
                calculateButton.setVisible(true);
        
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eventIdText = eventIdField.getText();
                try {
                    int eventId = Integer.parseInt(eventIdText);
                    double income = new AdminEventIncome().IncomeAdminPerEvent(eventId);
                    resultLabel.setText("Pendapatan untuk event ID " + eventId + ": Rp " + income);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Harap masukkan ID event yang valid.");
                }
            }
        });

        // Menyembunyikan input event ID secara default
        eventIdLabel.setVisible(false);
        eventIdField.setVisible(false);
        frame.getContentPane() .setBackground(new Color(0x567af0));
       
        // Menampilkan frame di tengah layar
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
