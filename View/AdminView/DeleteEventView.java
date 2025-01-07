package View.AdminView;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.Admin.DeleteEvent;

public class DeleteEventView {
    private JTextField eventIdField;
    private JButton deleteButton;
    private JLabel statusLabel;

    public DeleteEventView() {
        initComponent();
    }

    public void initComponent() {
        JFrame frame = new JFrame();
        frame.setTitle("Delete Event");
        frame.setSize(350, 200);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(245, 245, 245));

        JLabel eventIdLabel = new JLabel("Event ID:");
        eventIdLabel.setBounds(20, 20, 80, 25);
        frame.add(eventIdLabel);

        eventIdField = new JTextField();
        eventIdField.setBounds(120, 20, 180, 25);
        frame.add(eventIdField);

        deleteButton = new JButton("Delete Event");
        deleteButton.setBounds(20, 60, 280, 30);
        frame.add(deleteButton);

        statusLabel = new JLabel("Status: ");
        statusLabel.setBounds(20, 100, 280, 25);
        frame.add(statusLabel);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int eventId = Integer.parseInt(eventIdField.getText());
                    new DeleteEvent(eventId);
                    statusLabel.setText("Status: Event berhasil dihapus.");
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Status: Input Salah");
                } catch (Exception ex) {
                    statusLabel.setText("Status: Error deleting event.");
                    ex.printStackTrace();
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
