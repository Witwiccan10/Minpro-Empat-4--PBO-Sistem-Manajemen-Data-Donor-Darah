package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pendonor")
public class PendonorEntity {

    @Id
    @Column(name = "id", length = 20)
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @Column(name = "no_hp", nullable = false, length = 20)
    private String noHp;

    @Column(name = "golongan_darah", nullable = false, length = 3)
    private String golonganDarah;

    public PendonorEntity() {
    }

    public PendonorEntity(String id, String nama,
                          String noHp, String golonganDarah) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
        this.golonganDarah = golonganDarah;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }
}