public class PenerbitApp {
    public static void main(String[] args) {

        //instansiasi objek penerbit dari Class Penerbit tanpa parameter
        Penerbit penerbit = new Penerbit();
        penerbit.display();

        //instansiasi objek or dari Class Penerbit dengan 1 parameter
        Penerbit or = new Penerbit("O'Reilly");
        or.display();

        //instansiasi objek gm dari Class Penerbit dengan 2 parameter
        Penerbit gm = new Penerbit("Gramedia", "Jakarta");
        gm.display();
    }
}
