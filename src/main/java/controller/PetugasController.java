
package controller;

import dao.PetugasDAO;
import model.Petugas;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetugasController {

    private final PetugasDAO petugasDAO;

    public PetugasController() {
        petugasDAO = new PetugasDAO();
    }

    public ArrayList<Petugas> getDaftarPetugas() {
        try {
            return new ArrayList<>(petugasDAO.getAll());
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data petugas: "
                    + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void tambahPetugas(Petugas petugas) {
        try {
            if (!petugasDAO.insert(petugas)) {
                System.out.println("Petugas gagal ditambahkan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan petugas: "
                    + e.getMessage());
        }
    }

    public Petugas cariPetugas(String id) {
        try {
            return petugasDAO.getById(id);
        } catch (SQLException e) {
            System.out.println("Gagal mencari petugas: "
                    + e.getMessage());
            return null;
        }
    }

    public boolean idSudahAda(String id) {
        return cariPetugas(id) != null;
    }

    public boolean updatePetugas(
            String id,
            String nama,
            String noHp,
            String jabatan) {

        Petugas petugas = cariPetugas(id);

        if (petugas == null) {
            return false;
        }

        petugas.setNama(nama);
        petugas.setNoHp(noHp);
        petugas.setJabatan(jabatan);

        try {
            return petugasDAO.update(petugas);
        } catch (SQLException e) {
            System.out.println("Gagal memperbarui petugas: "
                    + e.getMessage());
            return false;
        }
    }

    public boolean hapusPetugas(String id) {
        try {
            return petugasDAO.delete(id);
        } catch (SQLException e) {
            System.out.println("Gagal menghapus petugas: "
                    + e.getMessage());
            return false;
        }
    }
}
