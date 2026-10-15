
package config;

import dao.PetugasDAO;
import model.Petugas;

public class TestPetugasDAO {
    public static void main(String[] args) {
        try {
            PetugasDAO dao = new PetugasDAO();

            for (Petugas p : dao.getAll()) {
                System.out.println(p.getInfo());
            }

        } catch (Exception e) {
            System.out.println("Gagal membaca data petugas!");
            e.printStackTrace();
        }
    }
}
