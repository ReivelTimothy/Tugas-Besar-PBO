package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        jTextField.setPreferredSize(new Dimension(150, 30));
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

        JLabel eventStartLabel = create.createLabel("Event Start:", 0, 0);
        JDatePickerImpl eventStartPicker = Create.createJDatePicker();
        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(eventStartLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        frame.add(eventStartPicker, gbc);

        JLabel eventEndLabel = create.createLabel("Event End:", 0, 0);
        JDatePickerImpl eventEndPicker = Create.createJDatePicker();
        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(eventEndLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        frame.add(eventEndPicker, gbc);

        JLabel kategoriLabel = create.createLabel("Category:", 0, 0);
        String[] categories = {"Music", "Sports", "Education", "Others"};
        JComboBox<String> kategoriComboBox = new JComboBox<>(categories);
        gbc.gridx = 0; gbc.gridy = 4;
        frame.add(kategoriLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        frame.add(kategoriComboBox, gbc);

        JLabel capacityLabel = create.createLabel("Capacity:", 0, 0);
        JTextField capacityField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 5;
        frame.add(capacityLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        frame.add(capacityField, gbc);

        JLabel descLabel = create.createLabel("Description:", 0, 0);
        JTextField descField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 6;
        frame.add(descLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 6;
        frame.add(descField, gbc);

        JLabel priceLabel = create.createLabel("Price:", 0, 0);
        JTextField priceField = create.createJTextField(0, 0);
        gbc.gridx = 0; gbc.gridy = 7;
        frame.add(priceLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 7;
        frame.add(priceField, gbc);

        JButton submitButton = create.createJButton("Submit");
        submitButton.setText("Submit");
        gbc.gridx = 0; gbc.gridy = 8;
        gbc.gridwidth = 2;
        frame.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String eventStart = eventStartPicker.getJFormattedTextField().getText();
            String eventEnd = eventEndPicker.getJFormattedTextField().getText();
            String kategori = (String) kategoriComboBox.getSelectedItem();
            String capacityText = capacityField.getText();
            String priceText = priceField.getText();
            String desc = descField.getText();
        
            Controller.CreateEvent.EventCreate(name, eventStart, eventEnd, desc, kategori, capacityText, priceText);
            frame.dispose();
            new MainMenuSeller();
        });
        

        frame.pack();
        frame.setVisible(true);
    }
}
