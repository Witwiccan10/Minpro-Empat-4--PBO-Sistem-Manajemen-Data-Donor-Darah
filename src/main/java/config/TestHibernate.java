package config;

import entity.PendonorEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TestHibernate {

    public static void main(String[] args) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            List<PendonorEntity> daftarPendonor =
                    session.createQuery(
                            "FROM PendonorEntity",
                            PendonorEntity.class
                    ).getResultList();

            transaction.commit();

            System.out.println("=== DATA PENDONOR DARI HIBERNATE ===");

            for (PendonorEntity pendonor : daftarPendonor) {
                System.out.println("ID             : " + pendonor.getId());
                System.out.println("Nama           : " + pendonor.getNama());
                System.out.println("No. HP         : " + pendonor.getNoHp());
                System.out.println(
                        "Golongan Darah : " + pendonor.getGolonganDarah()
                );
                System.out.println("-------------------------------");
            }

            System.out.println(
                    "Jumlah pendonor: " + daftarPendonor.size()
            );

        } catch (Exception e) {
            System.err.println("Tes Hibernate gagal:");
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}