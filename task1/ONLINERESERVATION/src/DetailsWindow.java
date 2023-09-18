import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DetailsWindow extends JFrame {
    final private Font mainFont = new Font("Seorge print", Font.BOLD, 23);

    public DetailsWindow(List<Reservation> reservations) {
        setTitle("Reservation Details");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(128, 128, 255));
        contentPanel.setLayout(new BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[] { "Train Number", "Class Type", "Date of Journey", "From", "To", "PNR Number" }, 0);

        for (Reservation reservation : reservations) {
            tableModel.addRow(new Object[] {
                    reservation.getTrainNumber(),
                    reservation.getClassType(),
                    reservation.getDate(),
                    reservation.getFrom(),
                    reservation.getTo(),
                    reservation.getPNR()
            });
        }

        JTable table = new JTable(tableModel);
        table.setOpaque(false);
        // table.setBackground(new Color(128, 128, 255, 128));

        // Create a cell renderer with a custom font size
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setFont(new Font("Seorge print", Font.BOLD, 24));

        // Apply the custom cell renderer to all columns
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        JButton btnBack = new JButton("Back <-");
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(btnBack, BorderLayout.SOUTH);

        getContentPane().add(contentPanel);

        btnBack.addActionListener(e -> openReservationChoice());
        btnBack.setFont(mainFont);
    }

    private void openReservationChoice() {
        ReservationChoice reservationChoice = new ReservationChoice();
        reservationChoice.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<Reservation> reservations = ReservationData.getReservations();
            DetailsWindow detailsWindow = new DetailsWindow(reservations);
            detailsWindow.setVisible(true);
        });
    }
}
