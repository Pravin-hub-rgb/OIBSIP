import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SuccessfullyCancelled extends JFrame {
    private Reservation reservation; // Store the reservation object
    final private Font mainFont = new Font("Seorge print", Font.BOLD, 28);

    public SuccessfullyCancelled(Reservation reservation) {
        this.reservation = reservation; // Store the reservation object
        setTitle("Successfully Cancelled Reservation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(128, 128, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create a big label with the specified text
        JLabel titleLabel = new JLabel("Successfully Cancelled Reservation of the following train");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 29));

        // Add the title label to the formPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(titleLabel, gbc);

        // Create a JTextArea to display the train details
        JTextArea detailsTextArea = new JTextArea();
        detailsTextArea.setFont(mainFont);
        detailsTextArea.setEditable(false);

        // Populate the JTextArea with the train details
        if (reservation != null) {
            detailsTextArea.append("Train Number: " + reservation.getTrainNumber() + "\n");
            detailsTextArea.append("Class Type: " + reservation.getClassType() + "\n");
            detailsTextArea.append("Date of Journey: " + reservation.getDate() + "\n");
            detailsTextArea.append("From: " + reservation.getFrom() + "\n");
            detailsTextArea.append("To: " + reservation.getTo() + "\n");
            detailsTextArea.append("PNR Number: " + reservation.getPNR() + "\n");
        } else {
            detailsTextArea.append("Reservation not found.");
        }

        // Add the JTextArea to the formPanel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        formPanel.add(detailsTextArea, gbc);

        JButton btnBack = new JButton("Back <-");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(btnBack, gbc);

        btnBack.setFont(mainFont);
        // Add an ActionListener to the "Back" button
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the back button action here
                // You can navigate to a different window or close this window
                // For example, navigate back to the previous window
                openReservationChoice();
            }
        });

        add(formPanel, BorderLayout.CENTER);
    }

    private void openReservationChoice() {
        ReservationChoice reservationChoice = new ReservationChoice();
        reservationChoice.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SuccessfullyCancelled successfullyCancelled = new SuccessfullyCancelled(null); // Pass the reservation
                                                                                           // object here
            successfullyCancelled.setVisible(true);
        });
    }
}
