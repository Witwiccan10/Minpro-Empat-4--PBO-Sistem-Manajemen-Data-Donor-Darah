package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "petugas")
public class PetugasEntity {

    @Id
    @Column(name = "id", length = 20)
    private String id;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @Column(name = "no_hp", nullable = false, length = 20)
    private String noHp;

    @Column(name = "jabatan", nullable = false, length = 50)
    private String jabatan;

    public PetugasEntity() {
    }

    public PetugasEntity(String id, String nama,
                         String noHp, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
        this.jabatan = jabatan;
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

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}