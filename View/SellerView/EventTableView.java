package View.SellerView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.LoginSingleton;
import Controller.Seller.GetEventId;
import Controller.Seller.GetEventWithIncome;
import Models.Classess.EventEducation;
import Models.Classess.EventSport;
import View.ViewTicket;
import Models.Classess.Event;
import Models.Classess.EventConcert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EventTableView {

    private JFrame frame;
    private JTable eventTable;

    public EventTableView(List<Event> events) {
        frame = new JFrame("Event Table View");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose();
            new ViewTicket();
        });
        topPanel.add(backButton, BorderLayout.WEST);

        // Label judul di tengah atas
        JLabel titleLabel = new JLabel("Event List", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Membuat model tabel
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("EVENT ID");
        tableModel.addColumn("Title");
        tableModel.addColumn("Category");
        tableModel.addColumn("Description");
        tableModel.addColumn("Price");
        tableModel.addColumn("Capacity");
        tableModel.addColumn("Date");
        tableModel.addColumn("Specific Info");
        tableModel.addColumn("Income");

        // Menambahkan data ke tabel
        for (Event event : events) {
            Object[] rowData = new Object[9];

            rowData[0] = event.getEventId();
            rowData[1] = event.getTitle();
            rowData[2] = event.getCategory();
            rowData[3] = event.getDesc();
            rowData[4] = event.getPrice();
            rowData[5] = event.getCapacity();
            rowData[6] = event.getTanggal();
            rowData[8] = event.getIncome();

            // Menentukan info spesifik berdasarkan tipe event
            if (event instanceof EventConcert) {
                rowData[7] = "Concert: " + ((EventConcert) event).getJenisKonser() + ", Singer: " + ((EventConcert) event).getSinger();
            } else if (event instanceof EventEducation) {
                rowData[7] = "Speaker: " + ((EventEducation) event).getNamaPembicara();
            } else if (event instanceof EventSport) {
                rowData[7] = "Sport: " + ((EventSport) event).getJenisSport();
            } else {
                rowData[7] = "-";
            }

            tableModel.addRow(rowData);
        }

        eventTable = new JTable(tableModel);
        eventTable.setRowHeight(25);
        eventTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(eventTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
