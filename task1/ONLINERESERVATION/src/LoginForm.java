import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    final private Font mainFont = new Font("Seorge print", Font.BOLD, 28);
    JTextField tfUserName;
    JPasswordField tfPassword;

    public void initialize() {
        /*********** Form Panel **************/

        JLabel lbUserName = new JLabel("Username");
        lbUserName.setFont(mainFont);

        tfUserName = new JTextField();
        tfUserName.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        tfPassword = new JPasswordField();
        tfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbUserName);
        formPanel.add(tfUserName);
        formPanel.add(lbPassword);
        formPanel.add(tfPassword);

        /* *************** Button Panel ************ */
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(mainFont);
        btnSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = tfUserName.getText();
                String password = new String(tfPassword.getPassword()); // Get the password as a String

                if (userName.isEmpty() || password.isEmpty()) {
                    // Show an error message or handle the validation failure as per your
                    // requirements
                    JOptionPane.showMessageDialog(LoginForm.this, "Please fill in all fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if ((userName.equals("admin") && password.equals("123"))
                        || (userName.equals("user1") && password.equals("123"))) {
                    openReservationChoice();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(btnSubmit);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Welcome");
        setSize(800, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void openReservationChoice() {
        ReservationChoice reservationChoice = new ReservationChoice();
        reservationChoice.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        LoginForm myForm = new LoginForm();
        myForm.initialize();
    }

}
