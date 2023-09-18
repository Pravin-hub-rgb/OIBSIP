import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReservationChoice extends JFrame {
    final private Font mainFont = new Font("Seorge print", Font.BOLD, 28);

    public ReservationChoice() {
        setTitle("Reservation System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(128, 128, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JButton btnMakeReservation = new JButton("Make Reservation");
        btnMakeReservation.setFont(mainFont);
        JButton btnCancelReservation = new JButton("Cancel Reservation");
        btnCancelReservation.setFont(mainFont);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(btnCancelReservation, gbc);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        formPanel.add(btnMakeReservation, gbc);

        add(formPanel, BorderLayout.CENTER);

        btnMakeReservation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openReservationSystem();
            }
        });
        btnCancelReservation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                openReservationCancelForm();
            }

        });

    }

    private void openReservationSystem() {
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.setVisible(true);
        dispose();
    }

    private void openReservationCancelForm() {
        CancellationForm cancellationForm = new CancellationForm();
        cancellationForm.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReservationChoice reservationChoice = new ReservationChoice();
            reservationChoice.setVisible(true);
        });
    }
}
