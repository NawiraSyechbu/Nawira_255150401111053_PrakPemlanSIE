package Queue;

public class CustomQueue {

    private Node head, tail;
    private int size = 0;

    public void enqueue(int x) {
        Node n = new Node(x);
        if (tail != null) tail.next = n;
        tail = n;
        if (head == null) head = tail;
        size++;
    }

    public int dequeue() {
        if (head == null)
            throw new RuntimeException("Queue is empty.");
        int val = head.data; //Menyimpan sementara atribut data dari head pada variabel val sebelum dikeluarkan dari queue untuk digunakan pada return
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //Method print()
    public void print(){
        Node current = head;

        while(current != null){
            System.out.print(current.data +" ");
            current = current.next;
        }

        System.out.println();
    }

    //Method peek()
    public int peek(){
        return head.data;
    }


    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        queue.enqueue(5);
        queue.enqueue(15);
        queue.enqueue(25);

        //Mengeluarkan nilai 5 dari queue
        queue.dequeue();

        //Menambahkan nilai 30 dan 40 ke dalam queue
        queue.enqueue(30);
        queue.enqueue(40);

        //Penggunaan method print()
        System.out.print("Custom Queue: ");
        queue.print();

        //Penggunaan method peek()
        System.out.println("Elemen paling depan: " +queue.peek());

        System.out.print("Custom Queue: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }

}
