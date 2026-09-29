# Praktikum4-PBO
L0325003-Inka Putri

**1. AsetIT.Java**
Class ini digunakan untuk membuat objek aset IT. Atributnya sesuai perintah tugas: idAset, namaPerangkat, lokasi, dan statusKondisi. Constructor digunakan untuk mengisi seluruh atribut, sedangkan tampilkanInfoAset() digunakan untuk menampilkan informasi aset.
public class AsetIT {
    String idAset;
    String namaPerangkat;
    String lokasi;
    String statusKondisi;

    public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi) {
        this.idAset = idAset;
        this.namaPerangkat = namaPerangkat;
        this.lokasi = lokasi;
        this.statusKondisi = statusKondisi;
    }

    public void tampilkanInfoAset() {
        System.out.println("ID Aset       : " + idAset);
        System.out.println("Nama Perangkat: " + namaPerangkat);
        System.out.println("Lokasi        : " + lokasi);
        System.out.println("Status Kondisi: " + statusKondisi);
        System.out.println("------------------------------");
    }
}

**2. ManajemenAset.Java**
Class ini berfungsi mengelola kumpulan objek AsetIT. Saya menggunakan ArrayList, karena materi menjelaskan bahwa ArrayList merupakan koleksi dinamis sehingga lebih fleksibel dibandingkan array yang ukurannya tetap. 
Untuk menampilkan data digunakan For-Each, sedangkan untuk menghapus berdasarkan ID digunakan Iterator, sesuai instruksi tugas.
import java.util.ArrayList;
import java.util.Iterator;

public class ManajemenAset {
    
    ArrayList<AsetIT> daftarAset = new ArrayList<>();

    public void tambahAset(AsetIT asetbaru) {
        daftarAset.add(asetbaru);
    }

    public void tampilkanSemuaAset() {
        if (daftarAset.isEmpty()) {
            System.out.println("Belum ada data aset.");
            return;
        }

        for (AsetIT aset : daftarAset) {
            aset.tampilkanInfoAset();
        }
    }

    public void hapusAset(String idAset) {
        Iterator<AsetIT> iterator = daftarAset.iterator();
        boolean ditemukan = false;

        while (iterator.hasNext()) {
            AsetIT aset = iterator.next();

            if (aset.idAset.equals(idAset)) {
                iterator.remove();
                ditemukan = true;
                System.out.println("Aset dengan ID " + idAset
                        + " berhasil dihapus.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Peringatan: Aset dengan ID "
                    + idAset + " tidak ditemukan.");
        }
    }
}

**3. MainAsetIT.Java**
Class ini digunakan untuk menjalankan program. Skenarionya dibuat persis berurutan sesuai tugas:
1.	Membuat objek ManajemenAset. 
2.	Menambahkan minimal 4 aset IT. 
3.	Menampilkan seluruh aset. 
4.	Menghapus salah satu aset berdasarkan ID. 
5.	Menampilkan kembali seluruh aset untuk membuktikan bahwa penghapusan berhasil
public class MainAset {
    public static void main(String[] args) {

        ManajemenAset manajemen = new ManajemenAset();
        manajemen.tambahAset(
                new AsetIT("AST001", "Server", "Ruang Server", "Baik")
        );
        manajemen.tambahAset(
                new AsetIT("AST002", "Router", "Ruang Jaringan", "Baik")
        );
        manajemen.tambahAset(
                new AsetIT("AST003", "Switch", "Ruang Jaringan", "Rusak")
        );
        manajemen.tambahAset(
                new AsetIT("AST004", "PC", "Lab Komputer", "Baik")
        );
        
        System.out.println("===== DAFTAR SEMUA ASET =====");
        manajemen.tampilkanSemuaAset();
        System.out.println("===== PROSES PENGHAPUSAN =====");
        manajemen.hapusAset("AST003");
        System.out.println("\n===== DAFTAR ASET SETELAH PENGHAPUSAN =====");
        manajemen.tampilkanSemuaAset();
    }
}
**4. Output**
  	===== DAFTAR SEMUA ASET =====
ID Aset       : AST001
Nama Perangkat: Server
Lokasi        : Ruang Server
Status Kondisi: Baik
------------------------------
ID Aset       : AST002
Nama Perangkat: Router
Lokasi        : Ruang Jaringan
Status Kondisi: Baik
------------------------------
ID Aset       : AST003
Nama Perangkat: Switch
Lokasi        : Ruang Jaringan
Status Kondisi: Rusak
------------------------------
ID Aset       : AST004
Nama Perangkat: PC
Lokasi        : Lab Komputer
Status Kondisi: Baik
------------------------------
===== PROSES PENGHAPUSAN =====
Aset dengan ID AST003 berhasil dihapus.

===== DAFTAR ASET SETELAH PENGHAPUSAN =====
ID Aset       : AST001
Nama Perangkat: Server
Lokasi        : Ruang Server
Status Kondisi: Baik
------------------------------
ID Aset       : AST002
Nama Perangkat: Router
Lokasi        : Ruang Jaringan
Status Kondisi: Baik
------------------------------
ID Aset       : AST004
Nama Perangkat: PC
Lokasi        : Lab Komputer
Status Kondisi: Baik
------------------------------
