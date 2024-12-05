package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class Create {

    JFrame createJframe(){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(500,500);
        jFrame.setResizable(true);
        jFrame.setLayout(null);
        jFrame.setLayout(new FlowLayout());
        return jFrame;
    }

    JButton createJButton(){
        JButton jButton = new JButton();
        jButton.setBounds(20,20,20,20);
        return jButton;
    }

    JTextField createJTextField (int marginLeft, int marginTop){
        JTextField jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(50, 30));
        return jTextField;
    }

    JLabel creatLabel(String txt, int marginLeft, int marginTop) {
        JLabel label = new JLabel();
        label.setBounds(marginLeft, marginTop, 150, 30);
        label.setFont(new Font(null, Font.PLAIN, 10));
        label.setText(txt);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.LEFT); 
        return label;
    }

}
