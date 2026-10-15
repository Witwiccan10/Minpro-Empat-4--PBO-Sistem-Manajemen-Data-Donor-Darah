# Minpro-4-PBO-Sistem-Manajemen-Data-Donor-Darah

**Nama:** Muhammad Kevin Athfalyuna  
**Kelas:** B  
**Mata Kuliah:** Pemrograman Berorientasi Objek

## Deskripsi Singkat Program

Sistem Manajemen Data Donor Darah merupakan program berbasis Java yang digunakan untuk mengelola data pendonor, petugas, dan kegiatan donor darah.

Program ini merupakan pengembangan dari Mini Project 3 dengan menambahkan integrasi database MySQL menggunakan JDBC dan DAO serta implementasi framework ORM menggunakan Hibernate.

Program memiliki fitur untuk menambah, menampilkan, mencari, mengubah, dan menghapus data pendonor, petugas, serta kegiatan donor darah. Data disimpan di dalam database sehingga dapat diakses kembali ketika program dijalankan.

---

# Struktur Package

Struktur package pada program terdiri dari:

```text
src/main/java
│
├── config
│   ├── DatabaseConnection.java
│   ├── HibernateUtil.java
│   ├── TestConnection.java
│   ├── TestPendonorDAO.java
│   ├── TestPetugasDAO.java
│   ├── TestDonorDAO.java
│   ├── TestHibernate.java
│   └── TestDonorHibernate.java
│
├── controller
│   ├── DonorController.java
│   ├── PendonorController.java
│   └── PetugasController.java
│
├── dao
│   ├── DonorDAO.java
│   ├── PendonorDAO.java
│   └── PetugasDAO.java
│
├── entity
│   ├── DonorEntity.java
│   ├── PendonorEntity.java
│   └── PetugasEntity.java
│
├── main
│   └── Main.java
│
├── model
│   ├── Donor.java
│   ├── Identifiable.java
│   ├── Orang.java
│   ├── Pendonor.java
│   └── Petugas.java
│
└── view
    └── MenuView.java

database
└── donor_darah.sql

pom.xml
README.md
```

*Catatan: sesuaikan daftar file di atas dengan struktur project aktual sebelum diunggah ke GitHub.*

### Model

Package `model` berisi class yang merepresentasikan data dalam program.

- `Orang` merupakan abstract class yang menjadi superclass dari `Pendonor` dan `Petugas`.
- `Pendonor` digunakan untuk menyimpan data pendonor.
- `Petugas` digunakan untuk menyimpan data petugas.
- `Donor` digunakan untuk menyimpan data kegiatan donor darah.
- `Identifiable` merupakan interface yang mendefinisikan method `getId()`.

### Controller

Package `controller` digunakan untuk mengatur proses pengelolaan data antara view, model, dan DAO.

- `PendonorController` mengelola data pendonor.
- `PetugasController` mengelola data petugas.
- `DonorController` mengelola data kegiatan donor darah.

### View

Package `view` berisi `MenuView.java` yang digunakan untuk menampilkan menu dan menerima input dari pengguna.

### Main

Package `main` berisi `Main.java` sebagai titik awal program dijalankan.

### DAO

Package `dao` berisi class yang bertanggung jawab terhadap operasi database menggunakan JDBC dan `PreparedStatement`.

- `PendonorDAO` mengelola operasi database pendonor.
- `PetugasDAO` mengelola operasi database petugas.
- `DonorDAO` mengelola operasi database donor.

### Entity

Package `entity` berisi class yang dipetakan ke tabel database menggunakan anotasi Hibernate ORM.

- `PendonorEntity` dipetakan ke tabel `pendonor`.
- `PetugasEntity` dipetakan ke tabel `petugas`.
- `DonorEntity` dipetakan ke tabel `donor`.

### Config

Package `config` berisi konfigurasi koneksi database, konfigurasi Hibernate, dan class pengujian koneksi serta pengambilan data.

---

# Alur Program

## 1. Menu Utama

<img width="470" height="235" alt="image" src="https://github.com/user-attachments/assets/dcf57fbd-b9f0-4102-aa48-74474eabfa66" />

**Gambar 1. Menu Utama Program**

Menu utama merupakan tampilan awal program yang menyediakan pilihan untuk mengelola data pendonor, petugas, dan kegiatan donor darah.

Pengguna dapat memilih menu sesuai dengan operasi yang ingin dilakukan.

---

## 2. Menampilkan Data Pendonor

<img width="460" height="286" alt="AdobeExpressPhotos_1f97a5510df5485a8887a83b889b9383_CopyEdited" src="https://github.com/user-attachments/assets/90088460-8abf-4f84-b993-4613020fbfa5" />

**Gambar 2. Menampilkan Data Pendonor**

Menu ini digunakan untuk menampilkan data pendonor yang telah tersimpan di dalam database MySQL.

Data pendonor terdiri dari ID, nama, nomor HP, dan golongan darah.

---

## 3. Menampilkan Data Petugas

<img width="436" height="253" alt="AdobeExpressPhotos_0737146aa1fe4549b1a8560915dd685e_CopyEdited" src="https://github.com/user-attachments/assets/68e13912-e128-4ed4-9921-e945d45fa0c0" />

**Gambar 3. Menampilkan Data Petugas**

Menu ini digunakan untuk menampilkan data petugas yang tersimpan di dalam database.

Data petugas terdiri dari ID, nama, nomor HP, dan jabatan.

---

## 4. Menampilkan Data Donor

<img width="412" height="288" alt="AdobeExpressPhotos_fa0721708db74f5e9bf65f06f4ee18bc_CopyEdited" src="https://github.com/user-attachments/assets/910320ca-5f94-4155-808b-15a9caf5ab21" />

**Gambar 4. Menampilkan Data Donor**

Menu ini digunakan untuk menampilkan data kegiatan donor darah.

Data donor terdiri dari ID donor, pendonor, petugas, tanggal donor, dan jumlah darah yang didonorkan.

Data pendonor dan petugas dihubungkan melalui relasi foreign key pada database.

---

## 5. Menambahkan Data

<img width="342" height="137" alt="AdobeExpressPhotos_44aaabedf129428ab39d154077d6075b_CopyEdited" src="https://github.com/user-attachments/assets/81007b81-eb74-4939-a46a-e8bf455b7df4" />

**Gambar 5. Menambahkan Data**

Pengguna dapat menambahkan data pendonor, petugas, atau kegiatan donor darah melalui menu yang tersedia.

Data yang dimasukkan akan diproses oleh controller dan DAO, kemudian disimpan ke dalam database MySQL.

---

## 6. Mengubah Data

<img width="363" height="250" alt="AdobeExpressPhotos_fb4788b4d22545a1902acf3aba7cd20a_CopyEdited" src="https://github.com/user-attachments/assets/8761bec8-e71e-4811-b832-b2003c0baf9b" />

**Gambar 6. Mengubah Data**

Fitur update digunakan untuk mengubah data yang telah tersimpan berdasarkan ID data.

Perubahan dilakukan melalui controller dan DAO, kemudian diterapkan pada database menggunakan query SQL.

---

## 7. Menghapus Data

<img width="352" height="66" alt="AdobeExpressPhotos_fb74e9b9d63446c59fbbaeeec785fd53_CopyEdited" src="https://github.com/user-attachments/assets/24b95352-3cb2-4c04-80fd-499c54c375cc" />

**Gambar 7. Menghapus Data**

Fitur hapus digunakan untuk menghapus data berdasarkan ID.

Penghapusan data memperhatikan relasi antartabel agar data pendonor atau petugas yang masih digunakan dalam transaksi donor tidak dihapus secara sembarangan.

---

# Penerapan Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut class.

Contohnya pada class `Orang`:

```java
private String id;
private String nama;
private String noHp;
```

Atribut tersebut tidak dapat diakses secara langsung dari luar class. Pengaksesan dan perubahan data dilakukan melalui getter dan setter.

Contoh:

```java
public String getNama() {
    return nama;
}

public void setNama(String nama) {
    this.nama = nama;
}
```

Dengan demikian, akses terhadap data objek dilakukan melalui method yang telah disediakan.

---

# Penerapan Inheritance

Inheritance diterapkan dengan menggunakan class `Orang` sebagai superclass dan `Pendonor` serta `Petugas` sebagai subclass.

Struktur inheritance:

```text
             Orang
            /     \
       Pendonor   Petugas
```

Class `Pendonor`:

```java
public class Pendonor extends Orang
```

Class `Petugas`:

```java
public class Petugas extends Orang
```

Atribut umum seperti ID, nama, dan nomor HP ditempatkan pada superclass `Orang`, sedangkan atribut khusus seperti golongan darah dan jabatan berada pada masing-masing subclass.

---

# Penerapan Abstraction

Abstraction diterapkan menggunakan abstract class dan abstract method.

Class `Orang` didefinisikan sebagai abstract class:

```java
public abstract class Orang
```

Class tersebut memiliki abstract method:

```java
public abstract String getInfo();
```

Method `getInfo()` diimplementasikan oleh subclass `Pendonor` dan `Petugas` sesuai dengan karakteristik masing-masing.

Dengan demikian, class `Orang` menjadi dasar umum bagi class turunannya.

---

# Penerapan Polymorphism

## 1. Overriding

Overriding diterapkan pada method `getInfo()` yang didefinisikan pada class `Orang` dan diimplementasikan kembali oleh subclass.

Pada class `Pendonor`:

```java
@Override
public String getInfo() {
    return "ID Pendonor    : " + getId()
            + "\nNama           : " + getNama()
            + "\nNo. HP         : " + getNoHp()
            + "\nGolongan Darah : " + golonganDarah;
}
```

Pada class `Petugas`:

```java
@Override
public String getInfo() {
    return "ID Petugas : " + getId()
            + "\nNama       : " + getNama()
            + "\nNo. HP     : " + getNoHp()
            + "\nJabatan    : " + jabatan;
}
```

Kedua subclass memiliki method dengan nama dan parameter yang sama, tetapi menghasilkan informasi sesuai dengan jenis objeknya.

## 2. Overloading

Overloading diterapkan pada method `cariDonor()` di `DonorController`.

Method pertama digunakan untuk mencari berdasarkan ID:

```java
public Donor cariDonor(String idDonor)
```

Method kedua digunakan untuk mencari berdasarkan ID dan tanggal:

```java
public Donor cariDonor(String idDonor, String tanggalDonor)
```

Kedua method memiliki nama yang sama dengan parameter berbeda sehingga merupakan penerapan method overloading.

---

# Penerapan MVC

Program menggunakan struktur Model-View-Controller (MVC) untuk memisahkan tanggung jawab setiap bagian.

### Model

Model merepresentasikan objek dan data program, seperti `Orang`, `Pendonor`, `Petugas`, dan `Donor`.

### View

View berisi `MenuView.java` yang bertanggung jawab terhadap tampilan menu dan input pengguna.

### Controller

Controller mengatur alur pengelolaan data melalui `PendonorController`, `PetugasController`, dan `DonorController`.

Controller berkomunikasi dengan DAO untuk menjalankan operasi database.

Pemisahan ini membuat struktur program lebih terorganisir dan memudahkan pemeliharaan kode.

---

# Nilai Tambah - Interface

Program menggunakan interface `Identifiable` sebagai kontrak untuk objek yang memiliki ID.

```java
public interface Identifiable {
    String getId();
}
```

Interface tersebut diimplementasikan oleh abstract class `Orang`:

```java
public abstract class Orang implements Identifiable
```

Dengan interface ini, class yang mengimplementasikannya harus menyediakan method `getId()`.

---

# Validasi Input

Program menerapkan validasi input untuk membantu mencegah data yang tidak sesuai.

Contoh validasi yang diterapkan:

- Input wajib diisi sesuai ketentuan program.
- ID diperiksa agar tidak duplikat.
- Nomor HP diperiksa agar berisi angka.
- Golongan darah dibatasi pada pilihan yang valid.
- Jumlah darah harus berupa angka positif.
- Tanggal donor menggunakan format `yyyy-MM-dd`.
- Data pendonor dan petugas harus tersedia sebelum digunakan dalam data donor.

Validasi membantu menjaga konsistensi data sebelum diproses dan disimpan ke database.

**[Masukkan Screenshot 8: Contoh Validasi Input]**

**Gambar 8. Validasi Input**

---

# Implementasi JDBC dan DAO

JDBC (Java Database Connectivity) digunakan untuk menghubungkan aplikasi Java dengan database MySQL.

Konfigurasi koneksi database terdapat pada class `DatabaseConnection`.

Operasi database dipisahkan ke dalam class DAO, yaitu:

- `PendonorDAO`
- `PetugasDAO`
- `DonorDAO`

Setiap DAO bertanggung jawab untuk menjalankan operasi tambah, baca, cari, ubah, dan hapus data sesuai kebutuhan.

Program menggunakan `PreparedStatement` untuk menjalankan query dengan parameter.

Pemisahan operasi database melalui DAO membuat kode akses data tidak bercampur langsung dengan tampilan menu.

---

# Implementasi Framework ORM - Hibernate

Hibernate ORM digunakan untuk memetakan objek Java ke tabel database secara lebih terstruktur.

Konfigurasi Hibernate dilakukan melalui class `HibernateUtil`, sedangkan pemetaan tabel dilakukan menggunakan entity.

## 1. Entity Pendonor

Class `PendonorEntity` dipetakan ke tabel `pendonor`.

Anotasi yang digunakan antara lain:

```java
@Entity
@Table(name = "pendonor")
public class PendonorEntity
```

Anotasi `@Entity` menandai class sebagai entity Hibernate, sedangkan `@Table` menentukan tabel database yang dipetakan.

## 2. Entity Petugas

Class `PetugasEntity` dipetakan ke tabel `petugas`.

```java
@Entity
@Table(name = "petugas")
public class PetugasEntity
```

Atribut class dipetakan ke kolom database menggunakan anotasi `@Column`.

## 3. Entity Donor

Class `DonorEntity` dipetakan ke tabel `donor`.

```java
@Entity
@Table(name = "donor")
public class DonorEntity
```

Relasi dengan pendonor dan petugas menggunakan anotasi:

```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_pendonor", nullable = false)
private PendonorEntity pendonor;
```

```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_petugas", nullable = false)
private PetugasEntity petugas;
```

Relasi `@ManyToOne` menunjukkan bahwa beberapa kegiatan donor dapat merujuk pada satu pendonor atau satu petugas.

## 4. Pengujian Hibernate

Pengujian Hibernate dilakukan melalui class `TestHibernate` dan `TestDonorHibernate`.

Berdasarkan hasil pengujian, Hibernate berhasil membaca data pendonor serta data donor beserta informasi pendonor dan petugas yang terkait.

Hasil pengujian `TestDonorHibernate` menunjukkan:

- Data donor `D001` dan `D002` berhasil dibaca.
- Informasi pendonor dan petugas berhasil ditampilkan.
- Tanggal dan jumlah darah berhasil dibaca.
- Proses berakhir dengan status `BUILD SUCCESS`.

**[Masukkan Screenshot 9: Pengujian Hibernate dan Output BUILD SUCCESS]**

**Gambar 9. Pengujian Hibernate ORM**

Implementasi Hibernate pada program ini telah diuji untuk pembacaan data. Pengujian CRUD melalui Hibernate secara terpisah belum dicakup dalam hasil pengujian tersebut.

---

# Database MySQL

Program menggunakan database `minpro4_donor_darah`.

Database terdiri dari tiga tabel utama:

### 1. Tabel pendonor

Menyimpan informasi pendonor berupa ID, nama, nomor HP, dan golongan darah.

### 2. Tabel petugas

Menyimpan informasi petugas berupa ID, nama, nomor HP, dan jabatan.

### 3. Tabel donor

Menyimpan kegiatan donor berupa ID donor, ID pendonor, ID petugas, tanggal donor, dan jumlah darah.

Tabel donor memiliki foreign key yang menghubungkan tabel pendonor dan petugas.

Script SQL untuk membuat tabel dan memasukkan data awal disediakan pada folder `database`.

---

# Dummy Data

Program menggunakan data awal pada database MySQL agar pengujian dapat dilakukan tanpa harus memasukkan seluruh data dari awal.

Contoh data awal yang digunakan:

```text
Pendonor : P001 dan P002
Petugas  : T001 dan T002
Donor    : D001 dan D002
```

Data awal dibuat melalui script SQL `database/donor_darah.sql`.

---

# Kesimpulan

Mini Project 4 merupakan pengembangan dari Mini Project 3 dengan menambahkan integrasi database MySQL melalui JDBC dan DAO serta penerapan framework ORM menggunakan Hibernate.

Program tetap menerapkan konsep Pemrograman Berorientasi Objek berupa encapsulation, inheritance, abstraction, polymorphism, dan interface, serta mempertahankan struktur MVC.

Implementasi JDBC dan DAO digunakan untuk operasi database aplikasi, sedangkan Hibernate ORM digunakan untuk memetakan entity Java ke tabel database dan membaca data beserta relasinya.
