
CREATE DATABASE IF NOT EXISTS minpro4_donor_darah;
USE minpro4_donor_darah;

-- Tabel pendonor
CREATE TABLE IF NOT EXISTS pendonor (
    id VARCHAR(20) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    no_hp VARCHAR(20) NOT NULL,
    golongan_darah VARCHAR(3) NOT NULL
);

-- Tabel petugas
CREATE TABLE IF NOT EXISTS petugas (
    id VARCHAR(20) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    no_hp VARCHAR(20) NOT NULL,
    jabatan VARCHAR(50) NOT NULL
);

-- Tabel donor
CREATE TABLE IF NOT EXISTS donor (
    id_donor VARCHAR(20) PRIMARY KEY,
    id_pendonor VARCHAR(20) NOT NULL,
    id_petugas VARCHAR(20) NOT NULL,
    tanggal_donor DATE NOT NULL,
    jumlah_darah INT NOT NULL,
    CONSTRAINT fk_donor_pendonor
        FOREIGN KEY (id_pendonor) REFERENCES pendonor(id),
    CONSTRAINT fk_donor_petugas
        FOREIGN KEY (id_petugas) REFERENCES petugas(id)
);

-- Dummy data awal pendonor
INSERT INTO pendonor (id, nama, no_hp, golongan_darah)
VALUES
    ('P001', 'Andi Saputra', '081234567801', 'A'),
    ('P002', 'Siti Rahma', '081234567802', 'B');

-- Dummy data awal petugas
INSERT INTO petugas (id, nama, no_hp, jabatan)
VALUES
    ('T001', 'Budi Santoso', '081234567803', 'Petugas Medis'),
    ('T002', 'Dewi Lestari', '081234567804', 'Administrasi');

-- Dummy data awal donor
INSERT INTO donor
    (id_donor, id_pendonor, id_petugas, tanggal_donor, jumlah_darah)
VALUES
    ('D001', 'P001', 'T001', '2026-10-10', 350),
    ('D002', 'P002', 'T002', '2026-10-12', 400);
