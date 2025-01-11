package View.AdminView;

import javax.swing.*;

import Controller.Admin.DeleteEvent;
import View.MainMenu;
import View.ViewTicket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;

public class MainMenuAdmin {

    public MainMenuAdmin() {
        initializeGUI();
    }

    private void initializeGUI() {
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        
        JButton viewTicketButton = new JButton("View Ticket");
        viewTicketButton.setBackground(new Color(0x2d5aed));
        viewTicketButton.setForeground(Color.WHITE);
        viewTicketButton.setFocusPainted(false);
        viewTicketButton.setBorderPainted(false);

        JButton deleteEventButton = new JButton("Delete Event ");
        deleteEventButton.setBackground(new Color(0x2d5aed));
        deleteEventButton.setForeground(Color.WHITE);
        deleteEventButton.setFocusPainted(false);
        deleteEventButton.setBorderPainted(false);

        JButton viewSellerIncomeButton = new JButton("View Seller Income");
        viewSellerIncomeButton.setBackground(new Color(0x2d5aed));
        viewSellerIncomeButton.setForeground(Color.WHITE);
        viewSellerIncomeButton.setFocusPainted(false);
        viewSellerIncomeButton.setBorderPainted(false);

        JButton editEventPriceButton = new JButton("Edit Event Price ");
        editEventPriceButton.setBackground(new Color(0x2d5aed));
        editEventPriceButton.setForeground(Color.WHITE);
        editEventPriceButton.setFocusPainted(false);
        editEventPriceButton.setBorderPainted(false);

        JButton adminIncomeAllEventsButton = new JButton("Admin Income All Events ");
        adminIncomeAllEventsButton.setBackground(new Color(0x2d5aed));
        adminIncomeAllEventsButton.setForeground(Color.WHITE);
        adminIncomeAllEventsButton.setFocusPainted(false);
        adminIncomeAllEventsButton.setBorderPainted(false);

        JButton adminEventIncomeButton = new JButton("Admin Event Income ");
        adminEventIncomeButton.setBackground(new Color(0x2d5aed));
        adminEventIncomeButton.setForeground(Color.WHITE);
        adminEventIncomeButton.setFocusPainted(false);
        adminEventIncomeButton.setBorderPainted(false);

        JButton refundFromUserButton = new JButton("Refund From User");
        refundFromUserButton.setBackground(new Color(0x2d5aed));
        refundFromUserButton.setForeground(Color.WHITE);
        refundFromUserButton.setFocusPainted(false);
        refundFromUserButton.setBorderPainted(false);

        JButton blockUnblockSellerCustomerButton = new JButton("Block/Unblock Seller & Customer ");
        blockUnblockSellerCustomerButton.setBackground(new Color(0x2d5aed));
        blockUnblockSellerCustomerButton.setForeground(Color.WHITE);
        blockUnblockSellerCustomerButton.setFocusPainted(false);
        blockUnblockSellerCustomerButton.setBorderPainted(false);

        frame.getContentPane() .setBackground(new Color(0x567af0));
       
        frame.add(viewTicketButton);
        frame.add(deleteEventButton);
        frame.add(viewSellerIncomeButton);
        frame.add(editEventPriceButton);
        frame.add(adminIncomeAllEventsButton);
        frame.add(adminEventIncomeButton);
        frame.add(refundFromUserButton);
        frame.add(blockUnblockSellerCustomerButton);


        viewTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewTicket();
            }
        });

        deleteEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteEventView();
            }
        });

        viewSellerIncomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SellerIncomeView();

            }
        });

        editEventPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditEventPriceView();
            }
        });

        adminIncomeAllEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminEventIncomeView();
            }
        });

        adminEventIncomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminEventIncomeView();
            }
        });

        refundFromUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RefundTicketApproveView();
            }
        });

        blockUnblockSellerCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BlockUserView();
            }
        });
        
        

        frame.setVisible(true);
    }

}
