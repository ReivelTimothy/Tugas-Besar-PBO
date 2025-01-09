package View;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ViewTicket {
    public static void main(String[] args) {
        // Membuat frame utama
        JFrame frame = new JFrame("Concert Showcase");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Membuat panel untuk tombol menu di kanan atas
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton addConcertButton = new JButton("Add Concert");
        JButton viewIncomeButton = new JButton("View Income");

        topPanel.add(loginButton);
        topPanel.add(registerButton);
        topPanel.add(addConcertButton);
        topPanel.add(viewIncomeButton);

        frame.add(topPanel, BorderLayout.NORTH);

        // Membuat panel untuk konten
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Grid dengan 2 kolom dan jarak antar item
        frame.add(new JScrollPane(contentPanel), BorderLayout.CENTER);

        // Folder gambar
        File imageFolder = new File("assets");
        if (imageFolder.exists() && imageFolder.isDirectory()) {
            // Ambil semua file gambar di folder
            File[] imageFiles = imageFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));

            if (imageFiles != null) {
                for (File imageFile : imageFiles) {
                    String fileName = imageFile.getName();
                    String title = fileName.substring(0, fileName.lastIndexOf('.')); // Menghapus ekstensi file

                    // Panel untuk setiap item
                    JPanel itemPanel = new JPanel();
                    itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
                    itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    // Menambahkan judul
                    JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
                    titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    itemPanel.add(titleLabel);

                    // Menambahkan gambar dengan ukuran tetap
                    ImageIcon originalIcon = new ImageIcon(imageFile.getPath());
                    Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    JLabel imageLabel = new JLabel(scaledIcon);
                    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    itemPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
                    itemPanel.add(imageLabel);

                    // Menambahkan tombol "Buy Now"
                    JButton buyNowButton = new JButton("Buy Now");
                    buyNowButton.setFont(new Font("Arial", Font.PLAIN, 14));
                    buyNowButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "You clicked Buy Now for " + title));
                    itemPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
                    itemPanel.add(buyNowButton);

                    contentPanel.add(itemPanel);
                }
            } else {
                JLabel errorLabel = new JLabel("No images found in the folder.");
                errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                contentPanel.add(errorLabel);
            }
        } else {
            JLabel errorLabel = new JLabel("The folder 'assets' does not exist.");
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(errorLabel);
        }

        // Menampilkan frame
        frame.setVisible(true);
    }
}

