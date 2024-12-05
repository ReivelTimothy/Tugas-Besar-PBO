package view.adminMenu;

import javax.swing.*;
import org.jdatepicker.impl.JDatePickerImpl;

import models.classes.EventEducation;
import view.Create;

import java.awt.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddConcert {

    public static void main(String[] args) throws ParseException {
        Create create = new Create();
        Date datee = new Date(0);
        // Membuat JFrame
        JFrame frame = create.createJframe("Add Concert");

        // Layout dan Constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Komponen Form
        JLabel labelConcertName = create.createLabel("Nama Konser:");
        JTextField textConcertName = create.createJTextField(200, 30);

        JLabel labelLocation = create.createLabel("Lokasi:");
        JTextField textLocation = create.createJTextField(200, 30);

        JLabel labelSNK = create.createLabel("Syarat & Ketentuan:");
        JTextField textSNK = create.createJTextField(200, 30);

        JLabel labelVendor = create.createLabel("Vendor:");
        JTextField textVendor = create.createJTextField(200, 30);

        JLabel labelDateTime = create.createLabel("Tanggal & Waktu:");
        JDatePickerImpl datePicker = create.createJDatePicker();

        JLabel label = new JLabel();
        label.setText("01-05-2004");
        gbc.gridx = 2;
        gbc.gridy = 4;
        frame.add(label, gbc);

        datePicker.addActionListener(e -> {
            Object selectedDate = datePicker.getModel().getValue();
            if (selectedDate != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = sdf.format(selectedDate);
                label.setText(formattedDate);  // Display the formatted date in the label
            } else {
                label.setText("No date selected");
            }
        });

        JLabel labelInfo = create.createLabel("Informasi Tambahan:");
        JTextField textInfo = create.createJTextField(200, 30);

        JLabel labelPrice = create.createLabel("Harga:");
        JTextField textPrice = create.createJTextField(200, 30);

        JLabel labelDiscount = create.createLabel("Diskon:");
        JTextField textDiscount = create.createJTextField(200, 30);

        // Menambahkan Komponen ke JFrame
        int row = 0;

        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(labelConcertName, gbc);

        gbc.gridx = 1;
        gbc.gridy = row++;
        frame.add(textConcertName, gbc);

        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(labelLocation, gbc);
        gbc.gridx = 1;
        gbc.gridy = row++;
        frame.add(textLocation, gbc);

        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(labelSNK, gbc);

        gbc.gridx = 1;
        gbc.gridy = row++;
        frame.add(textSNK, gbc);

        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(labelVendor, gbc);

        gbc.gridx = 1;
        gbc.gridy = row++;
        frame.add(textVendor, gbc);

        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(labelDateTime, gbc);

        gbc.gridx = 1;
        gbc.gridy = row++;
        frame.add(datePicker, gbc);

        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(labelInfo, gbc);
        gbc.gridx = 1;
        gbc.gridy = row++;
        frame.add(textInfo, gbc);

        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(labelPrice, gbc);
        gbc.gridx = 1;
        gbc.gridy = row++;
        frame.add(textPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(labelDiscount, gbc);
        gbc.gridx = 1;
        gbc.gridy = row++;
        frame.add(textDiscount, gbc);

        // Menampilkan JFrame
        frame.pack();
        frame.setVisible(true);

        JButton button = create.createJButton("submit");
        gbc.gridy = row++;
        gbc.gridx = 0;
        frame.add(button, gbc);


        // Convert java.util.Date to java.sql.Date

        button.addActionListener(e -> {
            EventEducation event = new EventEducation(
                    labelConcertName.getText(),
                    textLocation.getText(),
                    textSNK.getText(),
                    textVendor.getText(),
                    textInfo.getText(),
                    textInfo.getText(),
                    Double.parseDouble(textPrice.getText()),
                    Double.parseDouble(textDiscount.getText()),
                    0,
                    "Samuel Tarigant",
                    (Date) datePicker.getModel().getValue());
            System.out.println(event.toString());
        });
    }
}
