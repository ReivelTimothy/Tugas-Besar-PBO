package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Controller.Seller.*;
import Models.Classess.*;
import Models.Enumeration.EventCat;

public class AddConcert {
    static EventCat eventCat = EventCat.MUSIC;
    public static void main(String[] args) {
        new AddConcert();
    }

    public AddConcert() {
        InsertConcert concert = new InsertConcert();

        JFrame frame = new JFrame("ADD A CONCERT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Master panel with BoxLayout (vertical stacking)
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
        masterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding for master panel
        JDatePickerImpl date = createJDatePicker();
        JButton concertButton = new JButton("CONCERT");
        JButton sportButton = new JButton("SPORT");
        JButton eduButton = new JButton("EDUCATION");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout());
        buttonPanel.add(concertButton);
        buttonPanel.add(sportButton);
        buttonPanel.add(eduButton);

        // variabel
        JButton button = new JButton("Submit");
        JPanel judul = createInputText("Judul");
        JPanel penyanyi = createInputText("Nama Penyanyi ");
        JPanel pembicara = createInputText("Nama Pembicara");
        JPanel jenisOlahraga = createInputText("Jenis Olahraga");
        JPanel jenisKonser = createInputText("jenis Konser");
        JPanel harga = createInputText("Harga ");
        JPanel lokasi = createInputText("Lokasi ");
        JPanel snk = createInputText("S&K ");
        JPanel vendor = createInputText("Vendor");
        JPanel desc = createInputText("Descricption");
        JPanel tanggal = createDateInput(date, "Tanggal ");
        JPanel jamMulai = createInputText("Jam Mulai");
        JPanel jamSelesai = createInputText("Jam Selesai");
        JPanel discount = createInputText("Discount 4 member");
        JPanel kapasitas = createInputText("total Kapasitas ");
        JPanel genre = createInputText("genre");
        JPanel gambar = createInputFileChooser("Masukan Gambar Anda", frame);

        // variabel hanya ada didalam event tertentu
        penyanyi.setVisible(true);
        jenisKonser.setVisible(true);
        jenisOlahraga.setVisible(false);
        pembicara.setVisible(false);

        masterPanel.add(buttonPanel);
        masterPanel.add(judul);
        masterPanel.add(pembicara);
        masterPanel.add(jenisOlahraga);
        masterPanel.add(penyanyi);
        masterPanel.add(jenisKonser);
        masterPanel.add(harga);
        masterPanel.add(discount);
        masterPanel.add(lokasi);
        masterPanel.add(genre);
        masterPanel.add(kapasitas);
        masterPanel.add(snk);
        masterPanel.add(vendor);
        masterPanel.add(desc);
        masterPanel.add(tanggal);

        masterPanel.add(gambar);
        masterPanel.add(button);

        frame.add(masterPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        button.addActionListener(e -> {
            java.util.Date utilDate = (java.util.Date) date.getModel().getValue();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            String path = ((JTextField)gambar.getComponent(1)).getText();
            if (!cekInput()) {
                JOptionPane.showMessageDialog(null, "Maaf Tolong masukan semua data yang diperlukan");
            } else {
                if (eventCat == EventCat.MUSIC) {
                    EventConcert event = new EventConcert(
                            0,
                            getText(judul),
                            getText(lokasi),
                            getText(snk),
                            getText(vendor),
                            getText(desc),
                            path,
                            getPrice(harga),
                            Integer.parseInt(getText(kapasitas)),
                            sqlDate,
                            getText(jenisKonser),
                            getText(penyanyi));
                    concert.InsertConcertEvent(event, 0, path);
                } else if (eventCat == EventCat.EDUCATION) {
                    EventEducation eventEducation = new EventEducation(
                            0,
                            getText(judul),
                            getText(lokasi),
                            getText(snk),
                            getText(vendor),
                            getText(desc),
                            path,
                            getPrice(harga),
                            Integer.parseInt(getText(kapasitas)),
                            sqlDate,
                            getText(pembicara));
                    concert.InsertEduEvent(eventEducation, 0);
                } else {
                    EventSport eventSport = new EventSport(
                        0,
                        getText(judul),
                        getText(lokasi),
                        getText(snk),
                        getText(vendor),
                        getText(desc),
                        path,
                        getPrice(harga),
                        Integer.parseInt(getText(kapasitas)),
                        sqlDate,
                            getText(jenisOlahraga));
                    concert.InsertSportEvent(eventSport, 0);
                }
            }
        });

        concertButton.addActionListener(e -> {
            eventCat = EventCat.MUSIC;
            penyanyi.setVisible(true);
            jenisKonser.setVisible(true);
            jenisOlahraga.setVisible(false);
            pembicara.setVisible(false);
        });

        sportButton.addActionListener(e -> {
            eventCat = EventCat.SPORT;
            penyanyi.setVisible(false);
            jenisKonser.setVisible(false);
            jenisOlahraga.setVisible(true);
            pembicara.setVisible(false);
        });

        eduButton.addActionListener(e -> {
            eventCat = EventCat.EDUCATION;
            penyanyi.setVisible(false);
            jenisKonser.setVisible(false);
            jenisOlahraga.setVisible(false);
            pembicara.setVisible(true);
        });
    }

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

    public JPanel createInputFileChooser(String labeltxt, JFrame frame) {

        JPanel panel = new JPanel();
        JPanel subContainer = new JPanel();
        JTextField path = new JTextField();
        path.setVisible(false);

        JButton openButton = new JButton("Open File");
        openButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Pilih File Gambar");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                    "Image Files", "jpg", "jpeg", "png", "gif", "bmp"));

            // Tampilkan JFileChooser
            int userSelection = fileChooser.showOpenDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // File yang dipilih oleh pengguna
                File selectedFile = fileChooser.getSelectedFile();

                // Tentukan direktori tujuan
                File destinationFolder = new File("assets"); // Direktori relatif dalam folder proyek

                // Tentukan lokasi file tujuan
                File destinationFile = new File(destinationFolder, selectedFile.getName());

                try {
                    // Pindahkan file ke folder tujuan
                    Files.move(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    String relativePath = "images" + File.separator + selectedFile.getName();
                    path.setText(relativePath);
                    path.setVisible(false);
                    openButton.setEnabled(false);
                    System.out.println("File berhasil dipindahkan ke: " + destinationFile.getPath());
                } catch (IOException re) {
                    System.err.println("Terjadi kesalahan saat memindahkan file: " + re.getMessage());
                }
            } else {
                System.out.println("Tidak ada file yang dipilih.");
            }
        });

        subContainer.setLayout(new BorderLayout());
        subContainer.add(new JLabel(labeltxt), BorderLayout.WEST);
        subContainer.add(openButton, BorderLayout.EAST);

        panel.add(subContainer);
        panel.add(path);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        return panel;
    }

    public static String getText(JPanel panel) {
        return ((JTextField) panel.getComponent(1)).getText();
    }

    public static Double getPrice(JPanel panel) {
        return Double.parseDouble(((JTextField) panel.getComponent(1)).getText());
    }

    public static boolean cekInput() {
        return true;
    }
}