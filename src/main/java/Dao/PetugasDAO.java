
package dao;

import config.DatabaseConnection;
import model.Petugas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetugasDAO {

    public List<Petugas> getAll() throws SQLException {
        List<Petugas> daftar = new ArrayList<>();

        String sql = "SELECT id, nama, no_hp, jabatan "
                   + "FROM petugas ORDER BY id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                daftar.add(new Petugas(
                    rs.getString("id"),
                    rs.getString("nama"),
                    rs.getString("no_hp"),
                    rs.getString("jabatan")
                ));
            }
        }

        return daftar;
    }

    public Petugas getById(String id) throws SQLException {
        String sql = "SELECT id, nama, no_hp, jabatan "
                   + "FROM petugas WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Petugas(
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("no_hp"),
                        rs.getString("jabatan")
                    );
                }
            }
        }

        return null;
    }

    public boolean insert(Petugas petugas) throws SQLException {
        String sql = "INSERT INTO petugas "
                   + "(id, nama, no_hp, jabatan) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, petugas.getId());
            ps.setString(2, petugas.getNama());
            ps.setString(3, petugas.getNoHp());
            ps.setString(4, petugas.getJabatan());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean update(Petugas petugas) throws SQLException {
        String sql = "UPDATE petugas "
                   + "SET nama = ?, no_hp = ?, jabatan = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, petugas.getNama());
            ps.setString(2, petugas.getNoHp());
            ps.setString(3, petugas.getJabatan());
            ps.setString(4, petugas.getId());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM petugas WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
