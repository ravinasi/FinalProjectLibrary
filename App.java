import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;

public class App {
    private String[] userData = new String[4];
    public JFrame f = new JFrame("Library Orders");
    private JTextField[] textFields = new JTextField[4];

    public App() {
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.WHITE);

        // Center the JFrame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - f.getWidth()) / 2;
        int y = (screenSize.height - f.getHeight()) / 2;
        f.setLocation(x, y);

        // Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(173, 216, 230));  // Light Blue
        topPanel.add(new JLabel("\uD83D\uDCD6 Order Books:"));
        f.add(topPanel, BorderLayout.NORTH);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        inputPanel.setBackground(Color.WHITE);
        String[] labels = {"Librarian ID:", "Book ID:", "Supplier ID:", "Quantity:"};
        Font labelFont = new Font("Arial", Font.BOLD, 14);

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(labelFont);
            JTextField textField = new JTextField(10);
            inputPanel.add(label);
            inputPanel.add(textField);
            textFields[i] = textField;
        }
        f.add(inputPanel, BorderLayout.CENTER);

        // Send Button
        JButton sendButton = new JButton("\uD83D\uDCE9 Send");
        sendButton.setBackground(new Color(34, 139, 34));  // Green
        sendButton.setForeground(Color.WHITE);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String librarianID = textFields[0].getText();
                String bookID = textFields[1].getText();
                String supplierID = textFields[2].getText();
                String quantity = textFields[3].getText();
                userData = new String[]{librarianID, supplierID, bookID, quantity};
                f.dispose();
            }
        });

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(sendButton);
        f.add(buttonPanel, BorderLayout.SOUTH);

        f.setSize(400, 200);
        f.setVisible(true);
    }

    public void orderGUI(Library library) {
        int[] index = library.findDetails(userData);
        int bookIndex = library.findBook(userData[2]);
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        int quantity = Integer.parseInt(userData[3]);

        if (index[0] >= 0 && index[1] >= 0 && bookIndex >= 0) {
            Order order = new Order(library.librarians.elementAt(index[0]),
                    library.books.elementAt(bookIndex), library.suppliers.elementAt(index[1]), today, quantity);
            library.OrderBook(order);
        }
    }
}
