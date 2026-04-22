package Queue_Antrian;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Antrian {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String nama;


        while (true) {
            System.out.println("Menu Antrian Pelanggan:");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Tampilkan Antrian Terdepan");
            System.out.println("5. Keluar");
            System.out.print("Pilih (1-4): ");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline
                switch (choice) {
                    case 1:
                        System.out.print("Masukan Nama Pelanggan: ");
                        nama = sc.nextLine();
                        if (nama.equalsIgnoreCase("Budi")){ //Pengecekan apakah input pengguna pada variabel nama adalah budi (tidak case sensitive dengan IgnoreCase)
                            ((LinkedList<String>) queue).addFirst(nama); //Downcasting tipe reference queue dari Queue<String> menjadi LinkedList<String> untuk pemanggilan addFirst(); pada penambahan budi
                        } else { queue.add(nama); } //Penambahan elemen/nama normal/bukan budi
                        System.out.println(nama + " ditambahkan ke antrian.");
                        break;
                    case 2:
                        if (queue.isEmpty())
                        System.out.println("Antrian kosong.");
                        else {
                            nama = queue.poll(); //Mengeluarkan head dan menginisialisasi var nama dengan nilai return poll()
                            System.out.println("Melayani pelanggan : " + nama);
                        }
                        break;
                    case 3:
                        System.out.println("Antrian Saat Ini: " + queue);
                        break;
                    case 4:
                        //Untuk menampilkan antrian paling depan/head dengan method peek()
                        if (queue.isEmpty()){
                            System.out.println("Tidak ada antrian.");
                        } else {
                            System.out.println("Pelanggan terdepan: " +queue.peek());
                        }
                        break;
                    case 5:
                        System.out.println("Keluar.");
                        sc.close();
                        return;
                    default:
                        throw new Exception("Invalid input.");
                }
            } catch(Exception e) {
                System.out.println("Invalid input.");
                sc.next(); // consume newline
            }
            System.out.println();
        }
    }
}
