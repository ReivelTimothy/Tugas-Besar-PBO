package view.adminMenu;

import javax.swing.*;

import Models.classes.*;
import Models.classes.Event;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Controller.DBController;
import Models.enumaration.statusBlocked;
import view.DateLabelFormatter;

import java.awt.*;
import java.util.Date;
import java.util.Properties;

public class addConcert {

    public static void main(String[] args) {
        DBController dbController = new DBController();

        JFrame frame = new JFrame("ADD A CONCERT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Master panel with BoxLayout (vertical stacking)
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
        masterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding for master panel
        JDatePickerImpl date = createJDatePicker();
        masterPanel.setBackground(Color.lightGray);

        // variabel 
        JButton button = new JButton("Submit");
        JPanel judul = createInputText("Judul");
        JPanel penyanyi = createInputText("Nama Penyanyi ");
        JPanel harga = createInputText("Harga ");
        JPanel lokasi = createInputText("Lokasi ");
        JPanel snk = createInputText("S&K ");
        JPanel vendor = createInputText("Vendor");
        JPanel desc =  createInputText("Descricption");
        JPanel tanggal = createDateInput(date, "Tanggal ");
        JPanel jamMulai = createInputText("Jam Mulai");
        JPanel jamSelesai = createInputText("Jam Selesai");
        JPanel discount = createInputText("Discount 4 member");
        JPanel kapasitas = createInputText("total Kapasitas ");
        JPanel genre = createInputText("genre");

        
        masterPanel.add(judul);
        masterPanel.add(penyanyi);
        masterPanel.add(harga);
        masterPanel.add(discount);
        masterPanel.add(lokasi);
        masterPanel.add(genre);
        masterPanel.add(kapasitas);
        masterPanel.add(snk);
        masterPanel.add(vendor);
        masterPanel.add(desc);
        masterPanel.add(tanggal);
        masterPanel.add(jamMulai);
        masterPanel.add(jamSelesai);
        masterPanel.add(button);

        
        frame.add(masterPanel);

        
        frame.pack();
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);

        button.addActionListener(e -> {
            java.util.Date getDate = (Date) date.getModel().getValue();
            EventConcert event = new EventConcert(
                0, 
                getText(judul), 
                getText(lokasi), 
                getText(snk), 
                getText(vendor), 
                getText(desc), 
                getText(jamMulai), 
                getText(jamSelesai), 
                getPrice(harga), 
                Integer.valueOf(getText(kapasitas)), 
                getDate, 
                getText(genre), 
                getText(penyanyi)
            );
            System.out.println(event);
            System.out.println(
                dbController.addConcert(event));
        });
    }

    public static JPanel createInputText(String txt){
        JPanel panel = new JPanel(new BorderLayout(10, 10)); 
        JLabel title = new JLabel(txt);
        JTextField textFieldTitle = new JTextField();
        textFieldTitle.setPreferredSize(new Dimension(200, 30));
        panel.add(title, BorderLayout.WEST);
        panel.add(textFieldTitle, BorderLayout.EAST);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        return panel;
    }

     public static JDatePickerImpl createJDatePicker() {
        JPanel container = new JPanel();
        JPanel subContainer = new JPanel();
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setPreferredSize(new Dimension(200, 30));
        
        subContainer.setLayout(new BorderLayout());

        container.add(subContainer);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        
        return datePicker;
    }

    public static JPanel createDateInput(JDatePickerImpl datePickerImpl, String labeltxt){
        JPanel container = new JPanel();
        JPanel subContainer = new JPanel();


        subContainer.setLayout(new BorderLayout());
        subContainer.add(new JLabel(labeltxt), BorderLayout.WEST);
        subContainer.add(datePickerImpl, BorderLayout.EAST);

        container.add(subContainer);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        return container;

    }

    public static String getText(JPanel panel){
        return ((JTextField)panel.getComponent(1)).getText();
    }

    public static Double getPrice(JPanel panel){
        return Double.parseDouble(((JTextField)panel.getComponent(1)).getText());
    }
}
