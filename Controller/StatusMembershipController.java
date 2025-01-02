// package Controller;

// import java.sql.ResultSet;
// import java.sql.SQLException;

// import javax.swing.JTable;
// import javax.swing.table.DefaultTableModel;

// public class StatusMembershipController {

//     public static void displayCart(JTable cartTable) {
//         ResultSet resultSet = getCartData();

//         try {
//             String[] columnNames = {"Cart ID", "Event ID", "Ticket ID", "Customer ID"};

//             resultSet.last();
//             int rowCount = resultSet.getRow();
//             resultSet.beforeFirst();

//             Object[][] data = new Object[rowCount][4];
//             int i = 0;
//             while (resultSet.next()) {
//                 data[i][0] = resultSet.getInt("cart_id");
//                 data[i][1] = resultSet.getString("event_id");
//                 data[i][2] = resultSet.getString("ticket_id");
//                 data[i][3] = resultSet.getInt("cust_id");
//                 i++;
//             }

//             cartTable.setModel(new DefaultTableModel(data, columnNames));

//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public static ResultSet getCartData() {
//         DatabaseHandler conn = new DatabaseHandler();
//         ResultSet resultSet = null;
//         String query = "SELECT * FROM cart";
        
//         try {
//             conn.connect();
//             resultSet = conn.con.createStatement().executeQuery(query);
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }

//         return resultSet;
//     }
// }
