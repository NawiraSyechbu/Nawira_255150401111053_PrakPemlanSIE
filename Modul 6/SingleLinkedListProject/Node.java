public class Node {
    Object data;
    Node next;

    Node(Object data){
        this.data = data;
    }

    public static void main(String[] args) {

        //Instansiasi objek class Node dengan konstrukor Node(Object data)
        Node node = new Node("A");

        //Inisialisasi atribut data objek node sebelum menggunakan konstruktor
        node.data="A";

        System.out.println("node    :" +node);
        System.out.println("data    : " +node.data);
        System.out.println("pointer : " +node.next);
    }
}
