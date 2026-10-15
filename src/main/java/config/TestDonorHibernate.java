package config;

import entity.DonorEntity;
import org.hibernate.Session;
import java.util.List;

public class TestDonorHibernate {

    public static void main(String[] args) {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            List<DonorEntity> daftarDonor =
                    session.createQuery(
                            "FROM DonorEntity",
                            DonorEntity.class
                    ).getResultList();

            System.out.println("=== DATA DONOR DARI HIBERNATE ===");

            for (DonorEntity donor : daftarDonor) {
                System.out.println("ID Donor      : "
                        + donor.getIdDonor());

                System.out.println("Nama Pendonor : "
                        + donor.getPendonor().getNama());

                System.out.println("Golongan Darah: "
                        + donor.getPendonor().getGolonganDarah());

                System.out.println("Nama Petugas  : "
                        + donor.getPetugas().getNama());

                System.out.println("Tanggal Donor : "
                        + donor.getTanggalDonor());

                System.out.println("Jumlah Darah  : "
                        + donor.getJumlahDarah() + " ml");

                System.out.println("------------------------------");
            }

            System.out.println("Jumlah data donor: "
                    + daftarDonor.size());

        } catch (Exception e) {
            System.err.println("Tes Hibernate gagal:");
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}