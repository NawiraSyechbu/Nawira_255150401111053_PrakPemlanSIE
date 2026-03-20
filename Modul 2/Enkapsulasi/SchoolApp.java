package Enkapsulasi;

public class SchoolApp {
    public static void main(String[] args) {
        Student miki = new Student("Miki");
        Student mini = new Student("Mini");

        Student.setSkor(miki, 75);
        Student.setSkor(mini, 80);

        System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
        System.out.println("Grade " + mini.getNama() + " " + mini.getSkor());

        mini.updateNama("Mono");
        Student.setSkor(mini, 93);

        System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
        System.out.println("Grade " + mini.getNama() + " " + mini.getSkor());
    }
}
