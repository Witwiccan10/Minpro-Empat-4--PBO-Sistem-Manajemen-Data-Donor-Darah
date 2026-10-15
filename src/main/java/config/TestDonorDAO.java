
package config;

import dao.DonorDAO;
import model.Donor;

public class TestDonorDAO {
    public static void main(String[] args) {
        try {
            DonorDAO dao = new DonorDAO();

            for (Donor d : dao.getAll()) {
                System.out.println(d);
            }

        } catch (Exception e) {
            System.out.println("Gagal membaca data donor!");
            e.printStackTrace();
        }
    }
}
