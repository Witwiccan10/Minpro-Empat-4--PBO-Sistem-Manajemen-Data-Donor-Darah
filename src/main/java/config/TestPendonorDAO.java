
package config;

import dao.PendonorDAO;
import model.Pendonor;

public class TestPendonorDAO {
    public static void main(String[] args) {
        try {
            PendonorDAO dao = new PendonorDAO();

            for (Pendonor p : dao.getAll()) {
                System.out.println(p.getInfo());
            }

        } catch (Exception e) {
            System.out.println("Gagal membaca data pendonor!");
            e.printStackTrace();
        }
    }
}
