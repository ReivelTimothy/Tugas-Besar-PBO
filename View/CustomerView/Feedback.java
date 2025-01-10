package View.CustomerView;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;

import Controller.Customer.FeedbackController;

public class Feedback {
    private JFrame frame;
    private JTextArea feedbackText;

    public Feedback() {

        FeedbackController check = new FeedbackController();

        frame = new JFrame("Customer Feedback");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel feedbackLabel = new JLabel("Your Feedback:");
        feedbackLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(feedbackLabel, BorderLayout.NORTH);

        feedbackText = new JTextArea();
        feedbackText.setLineWrap(true);
        feedbackText.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(feedbackText);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String feedback = feedbackText.getText();
                if (check.insertFeedback(feedback)) {
                    JOptionPane.showMessageDialog(frame, "Thank you for your feedback!", "Success", JOptionPane.INFORMATION_MESSAGE);
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