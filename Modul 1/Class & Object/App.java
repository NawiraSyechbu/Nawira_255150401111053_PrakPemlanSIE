//import class java.util.Scanner dari package java.util agar Scanner dapat digunakan
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //deklarasi Scanner untuk menerima input pengguna
        Scanner in = new Scanner(System.in);
        
        //instansiasi objek bernama m1
        Mobil m1 = new Mobil();

        //input user untuk merk dan nopol
        System.out.print("Masukkan merk mobil ke-1: ");
        String merk = in.nextLine();
        System.out.print("Masukkan nomor polisi mobil ke-1: ");
        String nopol = in.nextLine();

        //memanggil method untuk inisialisasi atribut objek m1 & menghitung jarak tempuh
        m1.setKecepatan(50);
        m1.setMerk(merk);
        m1.setNopol(nopol);
        m1.setWarna("Merah");
        m1.hitungJarakTempuh(2.5);
        

        System.out.println("---------------");

        //instansiasi objek bernama m2
        Mobil m2 = new Mobil();

        //input user untuk merk dan nopol
        System.out.print("Masukkan merk mobil ke-2: ");
        merk = in.nextLine();
        System.out.print("Masukkan nomor polisi mobil ke-2: ");
        nopol = in.nextLine();

        //memanggil method untuk inisialisasi atribut objek m2 & menghitung jarak tempuh
        m2.setKecepatan(100);
        m2.setMerk(merk);
        m2.setNopol(nopol);
        m2.setWarna("Biru");
        m2.hitungJarakTempuh(2);

        System.out.println("---------------");

        //menampilkan atribut objek m1 & m2
        m1.display();
        m1.ubahSatuanKecepatan();
        System.out.println("---------------");

        m2.display();
        m2.ubahSatuanKecepatan();
        System.out.println("---------------");
        System.out.println("Atribut pada objek m1 diubah.");

        //mengubah warna dari objek m1
        m1.setWarna("Hijau");

        //menampilkan hasil perubahan
        m1.display();
    }
}
