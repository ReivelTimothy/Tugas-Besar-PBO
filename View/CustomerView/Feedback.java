package View.CustomerView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.Customer.FeedbackController;

public class Feedback {
    private JFrame frame;
    private JTextArea feedbackText;
    private JTextField eventIdField;

    public Feedback() {

        FeedbackController check = new FeedbackController();

        frame = new JFrame("Customer Feedback");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.getHSBColor(0.6f, 0.7f, 0.9f));
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel eventLabel = new JLabel("Event ID:");
        eventPanel.add(eventLabel);
        eventIdField = new JTextField(20);
        eventIdField.setBounds(100, 10, 200, 30);
        eventPanel.add(eventIdField);

        JLabel feedbackLabel = new JLabel("Your Feedback:");
        feedbackLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(feedbackLabel, BorderLayout.NORTH);

        feedbackText = new JTextArea();
        feedbackText.setLineWrap(true);
        feedbackText.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(feedbackText);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(eventPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String feedback = feedbackText.getText();
                int eventId = Integer.parseInt(eventIdField.getText());

                if (eventId == 0) {
                    JOptionPane.showMessageDialog(frame, "Event ID cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (check.insertFeedback(feedback, eventId)) {
                    JOptionPane.showMessageDialog(frame, "Thank you for your feedback!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new MainMenuCustomer();
                } else {
                    JOptionPane.showMessageDialog(frame, "Feedback cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    feedbackText.setText("");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenuCustomer();
            }
        });

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new Feedback();
    }
}
