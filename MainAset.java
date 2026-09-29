/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum4;

/**
 *
 * @author Inka Putri
 */
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
