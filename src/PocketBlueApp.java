import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PocketBlueApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PocketBlueApp::new);
    }

    // Program Login
    public PocketBlueApp() {
        // Membuat frame login
        JFrame frame = new JFrame("Pocket Blue - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());

        // Panel untuk menampung elemen-elemen
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label untuk judul aplikasi
        JLabel titleLabel = new JLabel("Pocket Blue", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(titleLabel, gbc);

        // Label untuk login
        JLabel loginLabel = new JLabel("Login", SwingConstants.CENTER);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy = 1;
        panel.add(loginLabel, gbc);

        // TextField untuk email
        JTextField emailField = new JTextField();
        emailField.setBorder(BorderFactory.createTitledBorder("Username"));
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 10, 5, 10);
        panel.add(emailField, gbc);

        // PasswordField untuk password
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        gbc.gridy = 3;
        panel.add(passwordField, gbc);

        // Tombol login
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(loginButton, gbc);

        // Action Listener untuk tombol login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("password")) { // Validasi sederhana
                    JOptionPane.showMessageDialog(frame, "Login Berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new MenuGUI(); // Membuka MenuGUI
                } else {
                    JOptionPane.showMessageDialog(frame, "Username atau Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Menambahkan panel ke frame
        frame.add(panel);
        frame.setVisible(true);
    }
}

// Program Menu
class MenuGUI {
    public MenuGUI() {
        // Membuat frame
        JFrame frame = new JFrame("Pocket Blue");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridBagLayout());

        // Panel utama untuk tata letak
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Label untuk judul aplikasi
        JLabel titleLabel = new JLabel("Pocket Blue", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        panel.add(titleLabel, gbc);

        // Tombol untuk "Catatan Pemasukan"
        JButton pemasukanButton = new JButton("Catatan Pemasukan");
        pemasukanButton.setBackground(new Color(0, 70, 200));
        pemasukanButton.setForeground(Color.WHITE);
        pemasukanButton.setFocusPainted(false);
        pemasukanButton.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 20, 10, 10);
        gbc.ipadx = 50;
        gbc.ipady = 20;
        panel.add(pemasukanButton, gbc);

        // Tombol untuk "Catatan Pengeluaran"
        JButton pengeluaranButton = new JButton("Catatan Pengeluaran");
        pengeluaranButton.setBackground(new Color(0, 70, 200));
        pengeluaranButton.setForeground(Color.WHITE);
        pengeluaranButton.setFocusPainted(false);
        pengeluaranButton.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 20);
        panel.add(pengeluaranButton, gbc);

        // Action Listener untuk tombol Catatan Pemasukan
        pemasukanButton.addActionListener(e -> new PocketBlueAppPemasukan()); // Membuka Catatan Pemasukan

        // Action Listener untuk tombol pengeluaran
        pengeluaranButton.addActionListener(e -> new PocketBlueAppPengeluaran());

        // Menambahkan panel ke frame
        frame.add(panel);
        frame.setVisible(true);
    }
}

// Program Catatan Pemasukan
class PocketBlueAppPemasukan {
    private JFrame frame;
    private DefaultListModel<Transaction> transactionListModel;
    private JList<Transaction> transactionList;
    private JTextField descriptionField;
    private JTextField amountField;
    private List<Transaction> transactions;

    public PocketBlueAppPemasukan() {
        transactions = new ArrayList<>();
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Pocket Blue - Catatan Pemasukan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Main panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(230, 240, 255));

        // Title label
        JLabel titleLabel = new JLabel("Pocket Blue - Catatan Pemasukan", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Transaction list area
        transactionListModel = new DefaultListModel<>();
        transactionList = new JList<>(transactionListModel);
        JScrollPane scrollPane = new JScrollPane(transactionList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Daftar Pemasukan :"));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(new Color(40, 90, 190));

        JLabel descriptionLabel = new JLabel("Rincian pemasukan :");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionField = new JTextField();

        JLabel amountLabel = new JLabel("Nominal :");
        amountLabel.setForeground(Color.WHITE);
        amountField = new JTextField();

        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionField);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setOpaque(false);

        JButton exitButton = new JButton("Keluar");
        exitButton.setBackground(new Color(200, 50, 50));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(frame, "Ingin keluar ke menu login?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                frame.dispose(); // Menutup frame saat keluar
                new PocketBlueApp(); // Kembali ke tampilan login
            }
        });
        buttonPanel.add(exitButton);

        JButton saveButton = new JButton("Simpan");
        saveButton.setBackground(new Color(50, 150, 50));
        saveButton.setForeground(Color.WHITE);
        saveButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Data berhasil disimpan!"));
        buttonPanel.add(saveButton);

        JButton addButton = new JButton("Tambahkan");
        addButton.setPreferredSize(new Dimension(100, 30));
        addButton.addActionListener(new AddTransactionListener());
        buttonPanel.add(addButton);

        mainPanel.add(buttonPanel, BorderLayout.EAST);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private class AddTransactionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String description = descriptionField.getText();
                double amount = Double.parseDouble(amountField.getText());

                Transaction transaction = new Transaction(description, amount);
                transactions.add(transaction);
                transactionListModel.addElement(transaction);
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Masukkan nominal yang valid.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void clearFields() {
        descriptionField.setText("");
        amountField.setText("");
    }
}

// Program Catatan Pengeluaran
class PocketBlueAppPengeluaran {
    private JFrame frame;
    private DefaultListModel<Transaction> transactionListModel;
    private JList<Transaction> transactionList;
    private JTextField descriptionField;
    private JTextField amountField;
    private List<Transaction> transactions;

    public PocketBlueAppPengeluaran() {
        transactions = new ArrayList<>();
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Pocket Blue - Catatan Pengeluaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Main panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(230, 240, 255));

        // Title label
        JLabel titleLabel = new JLabel("Pocket Blue - Catatan Pengeluaran", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Transaction list area
        transactionListModel = new DefaultListModel<>();
        transactionList = new JList<>(transactionListModel);
        JScrollPane scrollPane = new JScrollPane(transactionList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Daftar Pengeluaran :"));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(new Color(40, 90, 190));

        JLabel descriptionLabel = new JLabel("Rincian pengeluaran :");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionField = new JTextField();

        JLabel amountLabel = new JLabel("Nominal :");
        amountLabel.setForeground(Color.WHITE);
        amountField = new JTextField();

        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionField);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setOpaque(false);

        JButton exitButton = new JButton("Keluar");
        exitButton.setBackground(new Color(200, 50, 50));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(frame, "Ingin keluar ke menu login?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                frame.dispose(); // Menutup frame saat keluar
                new PocketBlueApp(); // Kembali ke tampilan login
            }
        });
        buttonPanel.add(exitButton);

        JButton saveButton = new JButton("Simpan");
        saveButton.setBackground(new Color(50, 150, 50));
        saveButton.setForeground(Color.WHITE);
        saveButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Data berhasil disimpan!"));
        buttonPanel.add(saveButton);

        JButton addButton = new JButton("Tambahkan");
        addButton.setPreferredSize(new Dimension(100, 30));
        addButton.addActionListener(new AddTransactionListener());
        buttonPanel.add(addButton);

        mainPanel.add(buttonPanel, BorderLayout.EAST);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private class AddTransactionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String description = descriptionField.getText();
                double amount = Double.parseDouble(amountField.getText());

                Transaction transaction = new Transaction(description, amount);
                transactions.add(transaction);
                transactionListModel.addElement(transaction);
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Masukkan nominal yang valid.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void clearFields() {
        descriptionField.setText("");
        amountField.setText("");
    }
}

// Kelas Transaction untuk menyimpan deskripsi dan jumlah transaksi
class Transaction {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return description + " = " + amount;
    }
}