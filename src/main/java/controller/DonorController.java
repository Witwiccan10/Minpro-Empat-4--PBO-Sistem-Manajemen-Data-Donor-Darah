
package controller;

import dao.DonorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Donor;
import model.Pendonor;
import model.Petugas;

public class DonorController {

    private final DonorDAO donorDAO;

    public DonorController(
            PendonorController pendonorController,
            PetugasController petugasController) {

        donorDAO = new DonorDAO();
    }

    public ArrayList<Donor> getDaftarDonor() {
        try {
            return new ArrayList<>(donorDAO.getAll());
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data donor: "
                    + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void tambahDonor(Donor donor) {
        try {
            if (!donorDAO.insert(donor)) {
                System.out.println("Donor gagal ditambahkan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan donor: "
                    + e.getMessage());
        }
    }

    // Overloading 1: mencari donor berdasarkan ID
    public Donor cariDonor(String idDonor) {
        try {
            return donorDAO.getById(idDonor);
        } catch (SQLException e) {
            System.out.println("Gagal mencari donor: "
                    + e.getMessage());
            return null;
        }
    }

    // Overloading 2: mencari donor berdasarkan ID dan tanggal
    public Donor cariDonor(
            String idDonor,
            String tanggalDonor) {

        Donor donor = cariDonor(idDonor);

        if (donor != null
                && donor.getTanggalDonor().equals(tanggalDonor)) {
            return donor;
        }

        return null;
    }

    public boolean idSudahAda(String idDonor) {
        return cariDonor(idDonor) != null;
    }

    public boolean updateDonor(
            String idDonor,
            Pendonor pendonor,
            Petugas petugas,
            String tanggalDonor,
            int jumlahDarah) {

        Donor donor = cariDonor(idDonor);

        if (donor == null) {
            return false;
        }

        donor.setPendonor(pendonor);
        donor.setPetugas(petugas);
        donor.setTanggalDonor(tanggalDonor);
        donor.setJumlahDarah(jumlahDarah);

        try {
            return donorDAO.update(donor);
        } catch (SQLException e) {
            System.out.println("Gagal memperbarui donor: "
                    + e.getMessage());
            return false;
        }
    }

    public boolean hapusDonor(String idDonor) {
        try {
            return donorDAO.delete(idDonor);
        } catch (SQLException e) {
            System.out.println("Gagal menghapus donor: "
                    + e.getMessage());
            return false;
        }
    }

    public boolean pendonorMemilikiDataDonor(String idPendonor) {
        for (Donor donor : getDaftarDonor()) {
            if (donor.getPendonor().getId()
                    .equalsIgnoreCase(idPendonor)) {
                return true;
            }
        }

        return false;
    }

    public boolean petugasMemilikiDataDonor(String idPetugas) {
        for (Donor donor : getDaftarDonor()) {
            if (donor.getPetugas().getId()
                    .equalsIgnoreCase(idPetugas)) {
                return true;
            }
        }

        return false;
    }

    public int hitungJumlahDonorPendonor(String idPendonor) {
        int jumlah = 0;

        for (Donor donor : getDaftarDonor()) {
            if (donor.getPendonor().getId()
                    .equalsIgnoreCase(idPendonor)) {
                jumlah++;
            }
        }

        return jumlah;
    }
}
