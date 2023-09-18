import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ReservationSystem extends JFrame {
    JTextField tfTrainNumber, tfClassType, tfDate, tfFrom, tfTo;
    final private Font mainFont = new Font("Seorge print", Font.BOLD, 28);

    public ReservationSystem() {
        setTitle("Reservation System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(128, 128, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lbTrainNumber = new JLabel("Train Number");
        lbTrainNumber.setFont(mainFont);
        tfTrainNumber = new JTextField(20);
        tfTrainNumber.setFont(mainFont);

        JLabel lbClassType = new JLabel("Class Type");
        lbClassType.setFont(mainFont);
        tfClassType = new JTextField(20);
        tfClassType.setFont(mainFont);

        JLabel lbDate = new JLabel("Date of Journey");
        lbDate.setFont(mainFont);
        tfDate = new JTextField(20);
        tfDate.setFont(mainFont);

        JLabel lbFrom = new JLabel("From");
        lbFrom.setFont(mainFont);
        tfFrom = new JTextField(20);
        tfFrom.setFont(mainFont);

        JLabel lbTo = new JLabel("To");
        lbTo.setFont(mainFont);
        tfTo = new JTextField(20);
        tfTo.setFont(mainFont);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setFont(mainFont);

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lbTrainNumber, gbc);
        gbc.gridx = 1;
        formPanel.add(tfTrainNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lbClassType, gbc);
        gbc.gridx = 1;
        formPanel.add(tfClassType, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(lbDate, gbc);
        gbc.gridx = 1;
        formPanel.add(tfDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(lbFrom, gbc);
        gbc.gridx = 1;
        formPanel.add(tfFrom, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(lbTo, gbc);
        gbc.gridx = 1;
        formPanel.add(tfTo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(btnInsert, gbc);

        add(formPanel, BorderLayout.CENTER);
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainNumber = tfTrainNumber.getText();
                String classType = tfClassType.getText();
                String date = tfDate.getText();
                String from = tfFrom.getText();
                String to = tfTo.getText();
                int pnrNo = ReservationData.getNextAvailablePNR();
                // Create a new reservation and add it to the data
                Reservation reservation = new Reservation(trainNumber, classType, date, from, to, pnrNo);
                ReservationData.addReservation(reservation);

                // Open the DetailsWindow with the inserted data
                openTrainDetailsPage(ReservationData.getReservations());

                // Clear the text fields
                tfTrainNumber.setText("");
                tfClassType.setText("");
                tfDate.setText("");
                tfFrom.setText("");
                tfTo.setText("");
            }
        });

    }

    private void openTrainDetailsPage(List<Reservation> reservations) {
        // Create and display the DetailsWindow with the reservation details
        DetailsWindow detailsWindow = new DetailsWindow(reservations);
        detailsWindow.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReservationSystem reservationSystem = new ReservationSystem();
            reservationSystem.setVisible(true);
        });
    }
}
