
package controller;

import dao.PendonorDAO;
import model.Pendonor;
import java.sql.SQLException;
import java.util.ArrayList;

public class PendonorController {

    private final PendonorDAO pendonorDAO;

    public PendonorController() {
        pendonorDAO = new PendonorDAO();
    }

    public ArrayList<Pendonor> getDaftarPendonor() {
        try {
            return new ArrayList<>(pendonorDAO.getAll());
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data pendonor: "
                    + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void tambahPendonor(Pendonor pendonor) {
        try {
            if (!pendonorDAO.insert(pendonor)) {
                System.out.println("Pendonor gagal ditambahkan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan pendonor: "
                    + e.getMessage());
        }
    }

    public Pendonor cariPendonor(String id) {
        try {
            return pendonorDAO.getById(id);
        } catch (SQLException e) {
            System.out.println("Gagal mencari pendonor: "
                    + e.getMessage());
            return null;
        }
    }

    public boolean idSudahAda(String id) {
        return cariPendonor(id) != null;
    }

    public boolean updatePendonor(
            String id,
            String nama,
            String noHp,
            String golonganDarah) {

        Pendonor pendonor = cariPendonor(id);

        if (pendonor == null) {
            return false;
        }

        pendonor.setNama(nama);
        pendonor.setNoHp(noHp);
        pendonor.setGolonganDarah(golonganDarah);

        try {
            return pendonorDAO.update(pendonor);
        } catch (SQLException e) {
            System.out.println("Gagal memperbarui pendonor: "
                    + e.getMessage());
            return false;
        }
    }

    public boolean hapusPendonor(String id) {
        try {
            return pendonorDAO.delete(id);
        } catch (SQLException e) {
            System.out.println("Gagal menghapus pendonor: "
                    + e.getMessage());
            return false;
        }
    }
}
