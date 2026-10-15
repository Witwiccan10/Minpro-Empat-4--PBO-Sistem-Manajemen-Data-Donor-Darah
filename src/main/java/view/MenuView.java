
package view;

import controller.DonorController;
import controller.PendonorController;
import controller.PetugasController;
import java.util.Scanner;
import model.Donor;
import model.Orang;
import model.Pendonor;
import model.Petugas;

public class MenuView {

    private final Scanner input;
    private final PendonorController pendonorController;
    private final PetugasController petugasController;
    private final DonorController donorController;

    public MenuView() {
        input = new Scanner(System.in);
        pendonorController = new PendonorController();
        petugasController = new PetugasController();
        donorController = new DonorController(
                pendonorController, petugasController
        );
    }

    public void tampilkanMenuUtama() {
        int pilihan;

        do {
            System.out.println("\n==========================================");
            System.out.println("    SISTEM MANAJEMEN DATA DONOR DARAH");
            System.out.println("==========================================");
            System.out.println("1. Kelola Data Pendonor");
            System.out.println("2. Kelola Data Petugas");
            System.out.println("3. Kelola Data Donor");
            System.out.println("4. Tampilkan Data Orang");
            System.out.println("0. Keluar");
            System.out.println("==========================================");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1 -> menuPendonor();
                case 2 -> menuPetugas();
                case 3 -> menuDonor();
                case 4 -> tampilkanDataOrang();
                case 0 -> System.out.println(
                        "\nProgram selesai. Terima kasih!"
                );
                default -> System.out.println(
                        "\nPilihan menu tidak tersedia!"
                );
            }
        } while (pilihan != 0);
    }

    // ==================== MENU PENDONOR ====================

    private void menuPendonor() {
        int pilihan;

        do {
            System.out.println("\n========== KELOLA PENDONOR ==========");
            System.out.println("1. Tambah Pendonor");
            System.out.println("2. Lihat Pendonor");
            System.out.println("3. Update Pendonor");
            System.out.println("4. Hapus Pendonor");
            System.out.println("0. Kembali");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1 -> tambahPendonor();
                case 2 -> tampilkanPendonor();
                case 3 -> updatePendonor();
                case 4 -> hapusPendonor();
                case 0 -> { }
                default -> System.out.println(
                        "Pilihan menu tidak tersedia!"
                );
            }
        } while (pilihan != 0);
    }

    private void tambahPendonor() {
        System.out.println("\n========== TAMBAH PENDONOR ==========");

        String id;

        while (true) {
            id = inputTidakKosong("ID Pendonor: ");

            if (pendonorController.idSudahAda(id)) {
                System.out.println("ID Pendonor sudah digunakan!");
            } else {
                break;
            }
        }

        String nama = inputTidakKosong("Nama: ");
        String noHp = inputNoHp("No. HP: ");
        String golonganDarah = inputGolonganDarah();

        pendonorController.tambahPendonor(
                new Pendonor(id, nama, noHp, golonganDarah)
        );

        Pendonor tersimpan = pendonorController.cariPendonor(id);

        if (tersimpan != null) {
            System.out.println("Pendonor berhasil ditambahkan.");
        } else {
            System.out.println(
                    "Pendonor belum dapat dipastikan tersimpan."
            );
        }
    }

    private void tampilkanPendonor() {
        System.out.println("\n=============== DATA PENDONOR ===============");

        var daftar = pendonorController.getDaftarPendonor();

        if (daftar.isEmpty()) {
            System.out.println("Belum ada data pendonor.");
            return;
        }

        for (Pendonor pendonor : daftar) {
            System.out.println("---------------------------------------------");
            System.out.println(pendonor.getInfo());
            System.out.println(
                    "Jumlah Donor   : "
                    + donorController.hitungJumlahDonorPendonor(
                            pendonor.getId()
                    ) + " kali"
            );
        }

        System.out.println("---------------------------------------------");
    }

    private void updatePendonor() {
        System.out.println("\n========== UPDATE PENDONOR ==========");

        String id = inputTidakKosong("ID Pendonor yang akan diupdate: ");
        Pendonor pendonor = pendonorController.cariPendonor(id);

        if (pendonor == null) {
            System.out.println("Pendonor tidak ditemukan!");
            return;
        }

        System.out.println("Data saat ini:");
        System.out.println(pendonor.getInfo());

        String nama = inputTidakKosong("Nama baru: ");
        String noHp = inputNoHp("No. HP baru: ");
        String golonganDarah = inputGolonganDarah();

        if (pendonorController.updatePendonor(
                id, nama, noHp, golonganDarah)) {
            System.out.println("Data pendonor berhasil diupdate.");
        } else {
            System.out.println("Data pendonor gagal diupdate.");
        }
    }

    private void hapusPendonor() {
        System.out.println("\n========== HAPUS PENDONOR ==========");

        String id = inputTidakKosong("ID Pendonor yang akan dihapus: ");

        if (pendonorController.cariPendonor(id) == null) {
            System.out.println("Pendonor tidak ditemukan!");
            return;
        }

        if (donorController.pendonorMemilikiDataDonor(id)) {
            System.out.println(
                    "Pendonor tidak dapat dihapus karena "
                    + "masih memiliki data donor!"
            );
            return;
        }

        if (pendonorController.hapusPendonor(id)) {
            System.out.println("Pendonor berhasil dihapus.");
        } else {
            System.out.println("Pendonor gagal dihapus.");
        }
    }

    // ==================== MENU PETUGAS ====================

    private void menuPetugas() {
        int pilihan;

        do {
            System.out.println("\n========== KELOLA PETUGAS ==========");
            System.out.println("1. Tambah Petugas");
            System.out.println("2. Lihat Petugas");
            System.out.println("3. Update Petugas");
            System.out.println("4. Hapus Petugas");
            System.out.println("0. Kembali");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1 -> tambahPetugas();
                case 2 -> tampilkanPetugas();
                case 3 -> updatePetugas();
                case 4 -> hapusPetugas();
                case 0 -> { }
                default -> System.out.println(
                        "Pilihan menu tidak tersedia!"
                );
            }
        } while (pilihan != 0);
    }

    private void tambahPetugas() {
        System.out.println("\n========== TAMBAH PETUGAS ==========");

        String id;

        while (true) {
            id = inputTidakKosong("ID Petugas: ");

            if (petugasController.idSudahAda(id)) {
                System.out.println("ID Petugas sudah digunakan!");
            } else {
                break;
            }
        }

        String nama = inputTidakKosong("Nama: ");
        String noHp = inputNoHp("No. HP: ");
        String jabatan = inputTidakKosong("Jabatan: ");

        petugasController.tambahPetugas(
                new Petugas(id, nama, noHp, jabatan)
        );

        if (petugasController.cariPetugas(id) != null) {
            System.out.println("Petugas berhasil ditambahkan.");
        } else {
            System.out.println(
                    "Petugas belum dapat dipastikan tersimpan."
            );
        }
    }

    private void tampilkanPetugas() {
        System.out.println("\n=============== DATA PETUGAS ===============");

        var daftar = petugasController.getDaftarPetugas();

        if (daftar.isEmpty()) {
            System.out.println("Belum ada data petugas.");
            return;
        }

        for (Petugas petugas : daftar) {
            System.out.println("--------------------------------------------");
            System.out.println(petugas.getInfo());
        }

        System.out.println("--------------------------------------------");
    }

    private void updatePetugas() {
        System.out.println("\n========== UPDATE PETUGAS ==========");

        String id = inputTidakKosong("ID Petugas yang akan diupdate: ");
        Petugas petugas = petugasController.cariPetugas(id);

        if (petugas == null) {
            System.out.println("Petugas tidak ditemukan!");
            return;
        }

        System.out.println("Data saat ini:");
        System.out.println(petugas.getInfo());

        String nama = inputTidakKosong("Nama baru: ");
        String noHp = inputNoHp("No. HP baru: ");
        String jabatan = inputTidakKosong("Jabatan baru: ");

        if (petugasController.updatePetugas(
                id, nama, noHp, jabatan)) {
            System.out.println("Data petugas berhasil diupdate.");
        } else {
            System.out.println("Data petugas gagal diupdate.");
        }
    }

    private void hapusPetugas() {
        System.out.println("\n========== HAPUS PETUGAS ==========");

        String id = inputTidakKosong("ID Petugas yang akan dihapus: ");

        if (petugasController.cariPetugas(id) == null) {
            System.out.println("Petugas tidak ditemukan!");
            return;
        }

        if (donorController.petugasMemilikiDataDonor(id)) {
            System.out.println(
                    "Petugas tidak dapat dihapus karena "
                    + "masih digunakan pada data donor!"
            );
            return;
        }

        if (petugasController.hapusPetugas(id)) {
            System.out.println("Petugas berhasil dihapus.");
        } else {
            System.out.println("Petugas gagal dihapus.");
        }
    }

    // ==================== MENU DONOR ====================

    private void menuDonor() {
        int pilihan;

        do {
            System.out.println("\n========== KELOLA DONOR ==========");
            System.out.println("1. Tambah Data Donor");
            System.out.println("2. Lihat Data Donor");
            System.out.println("3. Update Data Donor");
            System.out.println("4. Hapus Data Donor");
            System.out.println("0. Kembali");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1 -> tambahDonor();
                case 2 -> tampilkanDonor();
                case 3 -> updateDonor();
                case 4 -> hapusDonor();
                case 0 -> { }
                default -> System.out.println(
                        "Pilihan menu tidak tersedia!"
                );
            }
        } while (pilihan != 0);
    }

    private void tambahDonor() {
        System.out.println("\n========== TAMBAH DATA DONOR ==========");

        String idDonor;

        while (true) {
            idDonor = inputTidakKosong("ID Donor: ");

            if (donorController.idSudahAda(idDonor)) {
                System.out.println("ID Donor sudah digunakan!");
            } else {
                break;
            }
        }

        Pendonor pendonor = pendonorController.cariPendonor(
                inputTidakKosong("ID Pendonor: ")
        );

        if (pendonor == null) {
            System.out.println("Pendonor tidak ditemukan!");
            return;
        }

        Petugas petugas = petugasController.cariPetugas(
                inputTidakKosong("ID Petugas: ")
        );

        if (petugas == null) {
            System.out.println("Petugas tidak ditemukan!");
            return;
        }

        String tanggal = inputTanggalDonor();
        int jumlahDarah = inputAngkaPositif("Jumlah Darah (ml): ");

        donorController.tambahDonor(
                new Donor(idDonor, pendonor, petugas, tanggal, jumlahDarah)
        );

        if (donorController.cariDonor(idDonor) != null) {
            System.out.println("Data donor berhasil ditambahkan.");
        } else {
            System.out.println(
                    "Data donor belum dapat dipastikan tersimpan."
            );
        }
    }

    private void tampilkanDonor() {
        System.out.println("\n================ DATA DONOR ================");

        var daftar = donorController.getDaftarDonor();

        if (daftar.isEmpty()) {
            System.out.println("Belum ada data donor.");
            return;
        }

        for (Donor donor : daftar) {
            System.out.println("--------------------------------------------");
            System.out.println(donor);
        }

        System.out.println("--------------------------------------------");
    }

    private void updateDonor() {
        System.out.println("\n========== UPDATE DATA DONOR ==========");

        String idDonor = inputTidakKosong("ID Donor yang akan diupdate: ");
        Donor donor = donorController.cariDonor(idDonor);

        if (donor == null) {
            System.out.println("Data donor tidak ditemukan!");
            return;
        }

        System.out.println("Data saat ini:");
        System.out.println(donor);

        Pendonor pendonor = pendonorController.cariPendonor(
                inputTidakKosong("ID Pendonor baru: ")
        );

        if (pendonor == null) {
            System.out.println("Pendonor tidak ditemukan!");
            return;
        }

        Petugas petugas = petugasController.cariPetugas(
                inputTidakKosong("ID Petugas baru: ")
        );

        if (petugas == null) {
            System.out.println("Petugas tidak ditemukan!");
            return;
        }

        String tanggal = inputTanggalDonor();
        int jumlahDarah = inputAngkaPositif("Jumlah Darah baru (ml): ");

        if (donorController.updateDonor(
                idDonor, pendonor, petugas, tanggal, jumlahDarah)) {
            System.out.println("Data donor berhasil diupdate.");
        } else {
            System.out.println("Data donor gagal diupdate.");
        }
    }

    private void hapusDonor() {
        System.out.println("\n========== HAPUS DATA DONOR ==========");

        String idDonor = inputTidakKosong("ID Donor yang akan dihapus: ");

        if (donorController.hapusDonor(idDonor)) {
            System.out.println("Data donor berhasil dihapus.");
        } else {
            System.out.println(
                    "Data donor tidak ditemukan atau gagal dihapus."
            );
        }
    }

    // ==================== POLYMORPHISM ====================

    private void tampilkanDataOrang() {
        System.out.println("\n========== DATA ORANG ==========");

        for (Pendonor pendonor : pendonorController.getDaftarPendonor()) {
            Orang orang = pendonor;
            System.out.println("\n[PENDONOR]");
            System.out.println(orang.getInfo());
        }

        for (Petugas petugas : petugasController.getDaftarPetugas()) {
            Orang orang = petugas;
            System.out.println("\n[PETUGAS]");
            System.out.println(orang.getInfo());
        }
    }

    // ==================== VALIDASI INPUT ====================

    private String inputTidakKosong(String pesan) {
        while (true) {
            System.out.print(pesan);
            String nilai = input.nextLine().trim();

            if (!nilai.isEmpty()) {
                return nilai;
            }

            System.out.println("Input tidak boleh kosong!");
        }
    }

    private int inputAngka(String pesan) {
        while (true) {
            System.out.print(pesan);

            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }

    private int inputAngkaPositif(String pesan) {
        while (true) {
            int nilai = inputAngka(pesan);

            if (nilai > 0) {
                return nilai;
            }

            System.out.println("Angka harus lebih dari 0!");
        }
    }

    private String inputNoHp(String pesan) {
        while (true) {
            String noHp = inputTidakKosong(pesan);

            if (noHp.matches("[0-9]+")) {
                return noHp;
            }

            System.out.println("Nomor HP hanya boleh berisi angka!");
        }
    }

    private String inputGolonganDarah() {
        while (true) {
            String golonganDarah = inputTidakKosong(
                    "Golongan Darah (A/B/AB/O): "
            ).toUpperCase();

            if (golonganDarah.equals("A")
                    || golonganDarah.equals("B")
                    || golonganDarah.equals("AB")
                    || golonganDarah.equals("O")) {
                return golonganDarah;
            }

            System.out.println(
                    "Golongan darah harus A, B, AB, atau O!"
            );
        }
    }

    private String inputTanggalDonor() {
        java.time.format.DateTimeFormatter formatter =
                java.time.format.DateTimeFormatter
                        .ofPattern("uuuu-MM-dd")
                        .withResolverStyle(
                                java.time.format.ResolverStyle.STRICT
                        );

        while (true) {
            String tanggal = inputTidakKosong(
                    "Tanggal Donor (YYYY-MM-DD): "
            );

            try {
                java.time.LocalDate.parse(tanggal, formatter);
                return tanggal;
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println(
                        "Format tanggal tidak valid! "
                        + "Contoh: 2026-10-15"
                );
            }
        }
    }
}
