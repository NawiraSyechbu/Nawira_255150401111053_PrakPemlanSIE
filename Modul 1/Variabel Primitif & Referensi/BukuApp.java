public class BukuApp {
    public static void main(String[] args) {

        //instansiasi dengan parameter objek gm & sp dari Class Penerbit
        Penerbit gm = new Penerbit("Gramedia", "Jakarta");
        Penerbit sp = new Penerbit("Springer", "New York");

        //instansiasi & inisialisasi objek artikel dari Class Buku
        Buku artikel = new Buku();
        artikel.judul = "Rahasia OOP";
        artikel.halaman = 10;
        artikel.author = "John D. Walker";
        artikel.penerbit = gm;

        //instansiasi & inisialisasi objek paper dari Class Buku
        Buku paper = new Buku();
        paper.judul = "Tips dan Trik Pemrograman Diet";
        paper.halaman = 240;
        paper.author = "Cydia Lapr";
        paper.penerbit = sp;

        // === memanggil method display untuk objek artikel & paper

        artikel.display();
        paper.display();

        // copy! 
        artikel.author = paper.author;
        artikel.author = "Halu de Luna";
        artikel.display();
        paper.display();

        // copy!
        artikel.penerbit = paper.penerbit;
        artikel.penerbit.nama = "UB Press";
        artikel.display();
        paper.display();
    }
}
