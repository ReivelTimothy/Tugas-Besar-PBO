package View;

public class mainMenu {
    public MainMenu() {

        showMainMenu();

    }

    public void showMainMenu() {

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // INIT TOOLKIT
        Dimension screenSize = toolkit.getScreenSize(); // GET MY SCREEN SIZE

        int screenWidth = screenSize.width; // GET PIXELS FOR WIDTH
        int screenHeight = screenSize.height; // GET PIXELS FOR HEIGHT

        final int FRAME_WIDTH = 300; // SET WIDTH
        final int FRAME_HEIGHT = 400; // SET WEIGHT

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // SET START LOCATION FOR X
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // SET START LOCATION FOR Y

        frame = new JFrame("Main Menu");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // SET FRAME BOUND
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        JLabel title2 = new JLabel("==TIKETHB==");
        title2.setBounds(105, 50, 100, 50);
        title2.setFont(new Font("SansSerif", Font.BOLD, 24));
        panel.add(title2);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(10, 130, 260, 50);
        panel.add(loginBtn);

        loginBtn.addActionListener(e -> {
            frame.dispose();
            new Login();
        });

        JButton registerBtn = new JButton("REGISTER");
        registerBtn.setBounds(10, 200, 260, 50);
        registerBtn.add(registerBtn);

        registerBtn.addActionListener(e -> {
            frame.dispose();
            new Register();
        });

        JButton exitBtn = new JButton("EXIT");
        exitBtn.setBounds(10, 270, 260, 50);
        panel.add(exitBtn);

        exitBtn.addActionListener(e -> {
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);

    }
}
