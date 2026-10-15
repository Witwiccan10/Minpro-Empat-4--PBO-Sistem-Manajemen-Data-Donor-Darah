
package dao;

import config.DatabaseConnection;
import model.Donor;
import model.Pendonor;
import model.Petugas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DonorDAO {

    private static final String SELECT_JOIN =
        "SELECT d.id_donor, d.tanggal_donor, d.jumlah_darah, "
        + "p.id AS id_pendonor, p.nama AS nama_pendonor, "
        + "p.no_hp AS hp_pendonor, "
        + "p.golongan_darah, "
        + "t.id AS id_petugas, t.nama AS nama_petugas, "
        + "t.no_hp AS hp_petugas, t.jabatan "
        + "FROM donor d "
        + "JOIN pendonor p ON d.id_pendonor = p.id "
        + "JOIN petugas t ON d.id_petugas = t.id ";

    private Donor buatDonor(ResultSet rs) throws SQLException {
        Pendonor pendonor = new Pendonor(
            rs.getString("id_pendonor"),
            rs.getString("nama_pendonor"),
            rs.getString("hp_pendonor"),
            rs.getString("golongan_darah")
        );

        Petugas petugas = new Petugas(
            rs.getString("id_petugas"),
            rs.getString("nama_petugas"),
            rs.getString("hp_petugas"),
            rs.getString("jabatan")
        );

        return new Donor(
            rs.getString("id_donor"),
            pendonor,
            petugas,
            rs.getDate("tanggal_donor").toString(),
            rs.getInt("jumlah_darah")
        );
    }

    public List<Donor> getAll() throws SQLException {
        List<Donor> daftar = new ArrayList<>();
        String sql = SELECT_JOIN + "ORDER BY d.id_donor";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                daftar.add(buatDonor(rs));
            }
        }

        return daftar;
    }

    public Donor getById(String idDonor) throws SQLException {
        String sql = SELECT_JOIN + "WHERE d.id_donor = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idDonor);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buatDonor(rs);
                }
            }
        }

        return null;
    }

    public boolean insert(Donor donor) throws SQLException {
        String sql = "INSERT INTO donor "
            + "(id_donor, id_pendonor, id_petugas, "
            + "tanggal_donor, jumlah_darah) "
            + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, donor.getIdDonor());
            ps.setString(2, donor.getPendonor().getId());
            ps.setString(3, donor.getPetugas().getId());
            ps.setDate(4, Date.valueOf(donor.getTanggalDonor()));
            ps.setInt(5, donor.getJumlahDarah());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean update(Donor donor) throws SQLException {
        String sql = "UPDATE donor SET "
            + "id_pendonor = ?, id_petugas = ?, "
            + "tanggal_donor = ?, jumlah_darah = ? "
            + "WHERE id_donor = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, donor.getPendonor().getId());
            ps.setString(2, donor.getPetugas().getId());
            ps.setDate(3, Date.valueOf(donor.getTanggalDonor()));
            ps.setInt(4, donor.getJumlahDarah());
            ps.setString(5, donor.getIdDonor());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(String idDonor) throws SQLException {
        String sql = "DELETE FROM donor WHERE id_donor = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idDonor);
            return ps.executeUpdate() > 0;
        }
    }
}
