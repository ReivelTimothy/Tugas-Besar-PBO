package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.Properties;

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

}
