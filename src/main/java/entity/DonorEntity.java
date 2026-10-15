package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "donor")
public class DonorEntity {

    @Id
    @Column(name = "id_donor", length = 20)
    private String idDonor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pendonor", nullable = false)
    private PendonorEntity pendonor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_petugas", nullable = false)
    private PetugasEntity petugas;

    @Column(name = "tanggal_donor", nullable = false)
    private LocalDate tanggalDonor;

    @Column(name = "jumlah_darah", nullable = false)
    private int jumlahDarah;

    public DonorEntity() {
    }

    public DonorEntity(String idDonor,
                       PendonorEntity pendonor,
                       PetugasEntity petugas,
                       LocalDate tanggalDonor,
                       int jumlahDarah) {
        this.idDonor = idDonor;
        this.pendonor = pendonor;
        this.petugas = petugas;
        this.tanggalDonor = tanggalDonor;
        this.jumlahDarah = jumlahDarah;
    }

    public String getIdDonor() {
        return idDonor;
    }

    public void setIdDonor(String idDonor) {
        this.idDonor = idDonor;
    }

    public PendonorEntity getPendonor() {
        return pendonor;
    }

    public void setPendonor(PendonorEntity pendonor) {
        this.pendonor = pendonor;
    }

    public PetugasEntity getPetugas() {
        return petugas;
    }

    public void setPetugas(PetugasEntity petugas) {
        this.petugas = petugas;
    }

    public LocalDate getTanggalDonor() {
        return tanggalDonor;
    }

    public void setTanggalDonor(LocalDate tanggalDonor) {
        this.tanggalDonor = tanggalDonor;
    }

    public int getJumlahDarah() {
        return jumlahDarah;
    }

    public void setJumlahDarah(int jumlahDarah) {
        this.jumlahDarah = jumlahDarah;
    }
}