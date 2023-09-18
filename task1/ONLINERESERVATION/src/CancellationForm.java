import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancellationForm extends JFrame {
    private JLabel lblPRNumber;
    private JTextField txtPRNumber;
    private JButton btnCancel, btnConfirm;
    final private Font mainFont = new Font("Seorge print", Font.BOLD, 28);

    public CancellationForm() {
        setTitle("Cancellation Form");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        lblPRNumber = new JLabel("PNR Number:");
        lblPRNumber.setFont(mainFont);
        txtPRNumber = new JTextField();
        txtPRNumber.setFont(mainFont);
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(mainFont);
        btnConfirm = new JButton("Confirm");
        btnConfirm.setFont(mainFont);

        // Set preferred sizes for text fields
        txtPRNumber.setPreferredSize(new Dimension(150, 30));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Reset gridwidth
        panel.add(lblPRNumber, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Reset gridwidth
        panel.add(txtPRNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset gridwidth
        panel.add(btnCancel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset gridwidth
        panel.add(btnConfirm, gbc);

        // Add the panel to the frame
        add(panel);
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openReservationChoice();
            }

        });
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int pnrNo = Integer.parseInt(txtPRNumber.getText());
                    Reservation reservation = ReservationData.getReservationByPNR(pnrNo);
                    openSuccessfullyCancelled(reservation);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CancellationForm.this, "Please provide correct PNR number.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    private void openSuccessfullyCancelled(Reservation reservation) {
        SuccessfullyCancelled successfullyCancelled = new SuccessfullyCancelled(reservation);
        successfullyCancelled.setVisible(true);
        dispose();
    }

    private void openReservationChoice() {
        ReservationChoice reservationChoice = new ReservationChoice();
        reservationChoice.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CancellationForm form = new CancellationForm();
            form.setVisible(true);
        });
    }
}
