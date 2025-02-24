import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JLabel titleLabel;
    private JTextArea fortuneTextArea;
    private JButton readFortuneButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;
    private Random random;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load image
        java.net.URL imgUrl = getClass().getResource("CrystalBall.png");
        ImageIcon fortuneImage = new ImageIcon(imgUrl);

        // Fonts
        Font titleFont = new Font("Arial", Font.BOLD, 48);
        Font buttonFont = new Font("Arial", Font.PLAIN, 20);
        Font fortuneFont = new Font("Courier New", Font.PLAIN, 18);

        // Top Panel
        JPanel topPanel = new JPanel();
        titleLabel = new JLabel("  Fortune Teller  ", fortuneImage, SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        topPanel.add(titleLabel);

        // Middle Panel
        JPanel middlePanel = new JPanel(new BorderLayout());
        fortuneTextArea = new JTextArea();
        fortuneTextArea.setFont(fortuneFont);
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        middlePanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(buttonFont);
        quitButton = new JButton("Quit");
        quitButton.setFont(buttonFont);
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);

        // Layout
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Fortunes
        fortunes = new ArrayList<>();
        fortunes.add("You will find a lost treasure... in your laundry.");
        fortunes.add("A pleasant surprise is waiting for you... at the dentist.");
        fortunes.add("Your lucky number is... the number of times you hit snooze.");
        fortunes.add("You will meet a tall, dark stranger... who wants to borrow your phone charger.");
        fortunes.add("An unexpected journey awaits you... to the grocery store.");
        fortunes.add("You will soon receive a gift... a coupon for 10% off.");
        fortunes.add("Your future is bright... you will need sunglasses.");
        fortunes.add("A new opportunity will present itself... to take a nap.");
        fortunes.add("You will have a great day... if you stay in bed.");
        fortunes.add("Your spirit animal is... a sleepy panda.");
        fortunes.add("You will become rich... in memes.");
        fortunes.add("The stars say... you should order pizza.");

        random = new Random();

        // Action Listeners
        readFortuneButton.addActionListener(e -> displayFortune());
        quitButton.addActionListener(e -> System.exit(0));

        // Frame Size and Location
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocation(screenSize.width / 8, screenSize.height / 8);
    }

    private void displayFortune() {
        int newIndex;
        do {
            newIndex = random.nextInt(fortunes.size());
        } while (newIndex == lastFortuneIndex);
        lastFortuneIndex = newIndex;
        fortuneTextArea.append(fortunes.get(newIndex) + "\n");
    }
}