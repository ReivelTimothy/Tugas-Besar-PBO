package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class Create {

    public JFrame createJframe(String txt){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(500,500);
        jFrame.setResizable(true);
        jFrame.setLayout(null);
        jFrame.setLayout(new GridBagLayout());
        return jFrame;
    }

    public JButton createJButton(String txt){
        JButton jButton = new JButton();
        jButton.setBounds(20,20,20,20);
        return jButton;
    }

    public JTextField createJTextField (int marginLeft, int marginTop){
        JTextField jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(50, 30));
        return jTextField;
    }

    public JLabel createLabel(String txt, int marginLeft, int marginTop) {
        JLabel label = new JLabel();
        label.setBounds(marginLeft, marginTop, 150, 30);
        label.setFont(new Font(null, Font.PLAIN, 10));
        label.setText(txt);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.LEFT); 
        return label;
    }

     public static JDatePickerImpl createJDatePicker() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setPreferredSize(new Dimension(200, 30));
        return datePicker;
    }

    public static void main(String[] args) {
        Create create = new Create();

        JFrame frame = create.createJframe("Create Event");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = create.createLabel("Event Name:", 0, 0);
        JTextField nameField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(nameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        frame.add(nameField, gbc);

        JLabel locationLabel = create.createLabel("Location:", 0, 0);
        JTextField locationField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(locationLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        frame.add(locationField, gbc);

        JLabel snkLabel = create.createLabel("Terms & Conditions (SNK):", 0, 0);
        JTextField snkField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(snkLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        frame.add(snkField, gbc);

        JLabel vendorLabel = create.createLabel("Vendor:", 0, 0);
        JTextField vendorField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(vendorLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        frame.add(vendorField, gbc);

        JLabel descLabel = create.createLabel("Description:", 0, 0);
        JTextField descField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 4;
        frame.add(descLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        frame.add(descField, gbc);

        JLabel feedbackLabel = create.createLabel("Feedback:", 0, 0);
        JTextField feedbackField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 5;
        frame.add(feedbackLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        frame.add(feedbackField, gbc);

        JLabel dateLabel = create.createLabel("Date & Time:", 0, 0);
        JDatePickerImpl datePicker = Create.createJDatePicker();
        gbc.gridx = 0; gbc.gridy = 6;
        frame.add(dateLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 6;
        frame.add(datePicker, gbc);

        JLabel priceLabel = create.createLabel("Price:", 0, 0);
        JTextField priceField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 7;
        frame.add(priceLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 7;
        frame.add(priceField, gbc);

        JLabel ticketsLabel = create.createLabel("Tickets (comma-separated):", 0, 0);
        JTextField ticketsField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 8;
        frame.add(ticketsLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 8;
        frame.add(ticketsField, gbc);

        JButton submitButton = create.createJButton("Submit");
        submitButton.setText("Submit");
        gbc.gridx = 0; gbc.gridy = 9;
        gbc.gridwidth = 2;
        frame.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String location = locationField.getText();
            String snk = snkField.getText();
            String vendor = vendorField.getText();
            String desc = descField.getText();
            String feedback = feedbackField.getText();
            String date = datePicker.getJFormattedTextField().getText();
            String priceText = priceField.getText();
            String ticketsText = ticketsField.getText();

            ArrayList<String> tickets = new ArrayList<>();
            for (String ticket : ticketsText.split(",")) {
                tickets.add(ticket.trim());
            }

            double price = 0.0;
            try {
                price = Double.parseDouble(priceText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid price format!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String message = "Event Created:\n" +
                    "Name: " + name + "\n" +
                    "Location: " + location + "\n" +
                    "SNK: " + snk + "\n" +
                    "Vendor: " + vendor + "\n" +
                    "Description: " + desc + "\n" +
                    "Feedback: " + feedback + "\n" +
                    "Date: " + date + "\n" +
                    "Price: " + price + "\n" +
                    "Tickets: " + tickets;

            JOptionPane.showMessageDialog(frame, message, "Event Created", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.pack();
        frame.setVisible(true);
    }

}
