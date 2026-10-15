
package dao;

import config.DatabaseConnection;
import model.Pendonor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PendonorDAO {

    public List<Pendonor> getAll() throws SQLException {
        List<Pendonor> daftarPendonor = new ArrayList<>();

        String sql = "SELECT id, nama, no_hp, golongan_darah "
                   + "FROM pendonor ORDER BY id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pendonor pendonor = new Pendonor(
                    rs.getString("id"),
                    rs.getString("nama"),
                    rs.getString("no_hp"),
                    rs.getString("golongan_darah")
                );

                daftarPendonor.add(pendonor);
            }
        }

        return daftarPendonor;
    }

    public Pendonor getById(String id) throws SQLException {
        String sql = "SELECT id, nama, no_hp, golongan_darah "
                   + "FROM pendonor WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Pendonor(
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("no_hp"),
                        rs.getString("golongan_darah")
                    );
                }
            }
        }

        return null;
    }

    public boolean insert(Pendonor pendonor) throws SQLException {
        String sql = "INSERT INTO pendonor "
                   + "(id, nama, no_hp, golongan_darah) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pendonor.getId());
            ps.setString(2, pendonor.getNama());
            ps.setString(3, pendonor.getNoHp());
            ps.setString(4, pendonor.getGolonganDarah());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean update(Pendonor pendonor) throws SQLException {
        String sql = "UPDATE pendonor "
                   + "SET nama = ?, no_hp = ?, golongan_darah = ? "
                   + "WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pendonor.getNama());
            ps.setString(2, pendonor.getNoHp());
            ps.setString(3, pendonor.getGolonganDarah());
            ps.setString(4, pendonor.getId());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM pendonor WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
