package view.sellerMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import view.DateLabelFormatter;

public class Templete {
    public static JPanel createInputText(String txt) {
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

    public static JPanel createDateInput(JDatePickerImpl datePickerImpl, String labeltxt) {
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

    public static String getText(JPanel panel) {
        return ((JTextField) panel.getComponent(1)).getText();
    }

    public static Double getPrice(JPanel panel) {
        return Double.parseDouble(((JTextField) panel.getComponent(1)).getText());
    }
}
