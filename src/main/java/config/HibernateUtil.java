package config;

import entity.PendonorEntity;
import entity.PetugasEntity;
import entity.DonorEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY =
            buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            configuration.setProperty(
                    "hibernate.connection.driver_class",
                    "com.mysql.cj.jdbc.Driver"
            );

            configuration.setProperty(
                    "hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/minpro4_donor_darah"
            );

            configuration.setProperty(
                    "hibernate.connection.username",
                    "root"
            );

            configuration.setProperty(
                    "hibernate.connection.password",
                    ""
            );

            configuration.setProperty(
                    "hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect"
            );

            configuration.setProperty(
                    "hibernate.show_sql",
                    "true"
            );

            configuration.setProperty(
                    "hibernate.hbm2ddl.auto",
                    "validate"
            );

            configuration.addAnnotatedClass(PendonorEntity.class);
            configuration.addAnnotatedClass(PetugasEntity.class);
            configuration.addAnnotatedClass(DonorEntity.class);

            return configuration.buildSessionFactory();

        } catch (Exception e) {
            System.err.println(
                    "Gagal membuat SessionFactory: " + e.getMessage()
            );
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        if (SESSION_FACTORY != null) {
            SESSION_FACTORY.close();
        }
    }
}