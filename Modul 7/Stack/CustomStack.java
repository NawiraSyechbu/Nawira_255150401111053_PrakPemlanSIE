public class CustomStack {
    Node top;
    int size = 0;

    public void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;
        size++;
    }

    //Method pusAfterValue() untuk menambahkan node pada posisi tertentu (setelah node tertentu)
    public void pushAfterValue(int value, int x) {
        Node n = new Node(x);
        Node current = top;
        //Mencari node dengan nilai data sesuai parameter int value
        while (current.data != value) {
            current = current.next;
        }
        n.next = current.next;
        current.next = n;
        size++;
    }

    public int pop() {
        if (top == null)
            throw new RuntimeException("Stack is empty.");
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public Node peek(){
        if (top == null)
            throw new RuntimeException("Stack is empty.");
        return top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    //Method display() untuk menampilkan isi stack
    public void display(){
        Node current = top;
        while (current != null) {
            System.out.print("[" +current.data +"] ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomStack custom = new CustomStack();
        custom.push(1);
        custom.push(2);
        custom.push(3);
        System.out.println("Node teratas saat ini adalah " +custom.peek().data);
        System.out.print("Custom Stack: ");
        while (!custom.isEmpty()) {
            System.out.print("[" + custom.pop() + "]");
        }
        System.out.println("End.\n\n");
        
        custom.push(1);
        custom.push(2);
        custom.push(3);
        custom.push(4);
        System.out.print("Custom Stack: ");
        custom.display();
        System.out.println("\n\n");
        custom.pushAfterValue(2, 5);
        System.out.print("Custom Stack: ");
        custom.display();
    }
}
