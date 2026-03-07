public class Mobil {

    private String nopol;
    private String warna;
    private String merk;
    private int kecepatan;
    private double jarak_tempuh;

    public void setNopol(String n) {
        nopol = n;
    }

    public void setWarna(String s) {
        warna = s;
    }

    public void setMerk(String m) {
        merk = m;
    }

    public void setKecepatan(int k) {
        kecepatan = k;
    }

    public void hitungJarakTempuh(double waktu){
        jarak_tempuh = kecepatan*waktu;
    }

    public void ubahSatuanKecepatan(){
        System.out.println("atau " +(kecepatan*5/18) +" m/s");
    }

    public void display() {
        System.out.println("Mobil bermerk " + merk);
        System.out.println("bernomor polisi " + nopol);
        System.out.println("serta memililki warna " + warna);
        System.out.println("memiliki jarak tempuh " +jarak_tempuh +" km");
        System.out.print("bergerak dengan kecepatan " + kecepatan + " kpj ");
    }
}
