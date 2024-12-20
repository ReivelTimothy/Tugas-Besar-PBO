package view.adminMenu;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import view.DateLabelFormatter;

import java.awt.*;
import java.util.Properties;

public class addConcert {

    public static void main(String[] args) {
        // Frame setup
        JFrame frame = new JFrame("ADD A CONCERT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Master panel with BoxLayout (vertical stacking)
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
        masterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding for master panel
        JDatePickerImpl datePanelImpl = createJDatePicker();


        // Add panels to master panel
        masterPanel.add(createInputText("Judul "));
        masterPanel.add(createInputText("Lokasi "));
        masterPanel.add(createInputText("S&K "));
        masterPanel.add(createInputText("Vendor"));
        masterPanel.add(createInputText("desc"));
        masterPanel.add(createDateInput(datePanelImpl, "tanggal Event"));


        // Add master panel to frame
        frame.add(masterPanel);

        // Adjust frame size and make it visible
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    public static JPanel createInputText(String txt){
        JPanel panel = new JPanel(new BorderLayout(10, 10)); // BorderLayout with hgap and vgap
        JLabel Title = new JLabel(txt);
        JTextField textFieldTitle = new JTextField();
        textFieldTitle.setPreferredSize(new Dimension(250, 50)); // Fixed size for text field
        panel.add(Title, BorderLayout.WEST);
        panel.add(textFieldTitle, BorderLayout.EAST);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Padding for panel

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
}
