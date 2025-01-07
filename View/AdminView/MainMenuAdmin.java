package View.AdminView;

import javax.swing.*;

import Controller.Admin.DeleteEvent;
import View.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class MainMenuAdmin {

    public MainMenuAdmin() {
        initializeGUI();
    }

    private void initializeGUI() {
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JButton viewTicketButton = new JButton("View Ticket");
        JButton deleteEventButton = new JButton("Delete Event ");
        JButton viewSellerIncomeButton = new JButton("View Seller Income");
        JButton editEventPriceButton = new JButton("Edit Event Price ");
        JButton adminIncomeAllEventsButton = new JButton("Admin Income All Events ");
        JButton adminEventIncomeButton = new JButton("Admin Event Income ");
        JButton refundFromUserButton = new JButton("Refund From User");
        JButton blockUnblockSellerCustomerButton = new JButton("Block/Unblock Seller & Customer ");

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
              //new viewTicket();
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
      
            }
        });

        adminEventIncomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });

        refundFromUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
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
