package DoubleLinkedListProject;

public class DoubleLinkedList {
    Node head, tail;
    int size = 0;

    void init(){ head = null; }
    boolean isEmpty(){ return size == 0; }
    int size(){ return size; }

    void addFirst(Node data){
        if (isEmpty()){
            head = data;
            tail = data;
        } else {
            data.next = head;
            head.prev = data;
            head = data;
        }
        size++;
    }

    void addLast(Node data){
        if (isEmpty()){
            head = data;
            tail = data;
        } else {
            tail.next = data;
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    //find by value (a)
    Node findByValue(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    //find by index (b)
    Node findByIndex(int n) {
        if (n < 0 || n >= size) return null;
        Node current = head;
        int counter = 0;
        while (current != null) {
            if (counter == n) return current;
            current = current.next;
            counter++;
        }
        return null;
    }

    //remove by index (c)
    void removeByIndex(int n) {
        if (isEmpty() || n < 0 || n >= size) {
            System.out.println("[removeByIndex] Index " + n + " tidak valid.");
            return;
        }
 
        if (size == 1) {
            // Hanya ada satu node
            head = null;
            tail = null;
            
 
        } else if (n == 0) {
            // Hapus head
            head = head.next;
            head.prev = null;
 
        } else if (n == size - 1) {
            // Hapus tail
            tail = tail.prev;
            tail.next = null;
 
        } else {
            // Hapus node di tengah
            Node target = findByIndex(n);
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        System.out.println("[removeByIndex] Index " + n + " berhasil.");
        size--;
    }

    //remove by value (d)
    void removeByValue(Object value) {
        if (isEmpty()) {
            System.out.println("[removeByValue] List kosong.");
            return;
        }
 
        Node target = findByValue(value);
        if (target == null) {
            System.out.println("[removeByValue] Nilai '" + value + "' tidak ditemukan.");
            return;
        }
 
        if (size == 1) {
            head = null;
            tail = null;
 
        } else if (target == head) {
            head = head.next;
            head.prev = null;
 
        } else if (target == tail) {
            tail = tail.prev;
            tail.next = null;
 
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        System.out.println("[removeByValue] Nilai '" + value + "' berhasil.");
        size--;
    }

    //add at index (e)
    void addAtIndex(int n, Node data) {
        if (n < 0 || n > size) {
            System.out.println("[addAtIndex] Index " + n + " tidak valid.");
            return;
        }
 
        if (n == 0) {
            addFirst(data);
 
        } else if (n == size) {
            addLast(data);
 
        } else {
            Node successor = findByIndex(n);   // node yang akan tergeser ke kanan
            Node predecessor = successor.prev; // node sebelum posisi sisipan
 
            // Tautkan data ke successor dan predecessor
            data.next = successor;
            data.prev = predecessor;
            predecessor.next = data;
            successor.prev = data;
            size++;
        }
        System.out.println("[addAtIndex] Index " + n + " berhasil.");
    }

    //add after value (f)
    void addAfterValue(Object value, Node newNode) {
        Node target = findByValue(value);
        if (target == null) {
            System.out.println("[addAfterValue] Nilai '" + value + "' tidak ditemukan.");
            return;
        }
 
        if (target == tail) {
            addLast(newNode);
        } else {
            Node successor = target.next;
 
            // Tautkan newNode di antara target dan successor
            newNode.prev = target;
            newNode.next = successor;
            target.next = newNode;
            successor.prev = newNode;
            size++;
        }
        System.out.println("[addAfterValue] Nilai '" + value + "' berhasil.");
    }

    //add before value (g)
    void addBeforeValue(Object value, Node newNode) {
        Node target = findByValue(value);
        if (target == null) {
            System.out.println("[addBeforeValue] Nilai '" + value + "' tidak ditemukan.");
            return;
        }
 
        if (target == head) {
            addFirst(newNode);
        } else {
            Node predecessor = target.prev;
 
            // Tautkan newNode di antara predecessor dan target
            newNode.next = target;
            newNode.prev = predecessor;
            predecessor.next = newNode;
            target.prev = newNode;
            size++;
        }
        System.out.println("[addBeforeValue] Nilai '" + value + "' berhasil.");
    }

    void print(){
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    void printBackward(){
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }


    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        list.addLast(nodeA);
        System.out.println("Head: " +list.head.data);
        System.out.println("Tail: " +list.tail.data);

        list.addFirst(nodeB);
        System.out.println("Head: " +list.head.data);
        System.out.println("Tail: " +list.tail.data);

        list.addFirst(nodeC);
        System.out.println("Head: " +list.head.data);
        System.out.println("Tail: " +list.tail.data);

        list.print();

        System.out.println("Next of B: " +nodeB.next.data);
        System.out.println("Prev of B: " +nodeB.prev.data);

        list.printBackward();

        //Find by Value
        System.out.println("\n-- FIND BY VALUE --");
        System.out.println("[FindByValue]: " +list.findByValue("A").data);

        //Find by Index
        System.out.println("\n-- FIND BY INDEX --");
        System.out.println("[findByIndex]: " +list.findByIndex(2).data);

        //Remove by Index
        System.out.println("\n-- REMOVE BY INDEX --");
        //Remove by Index dengan index yang tidak valid
        list.removeByIndex(4);
        list.print();
        //Remove by Index dengan index yang valid
        list.removeByIndex(2);
        System.out.println("Setelah removeByIndex(2): ");
        System.out.println("Normal:");
        list.print();
        System.out.println("Backward:");
        list.printBackward();

        //Remove by Value
        System.out.println("\n-- REMOVE BY VALUE --");
        //Remove by Index dengan value yang valid
        list.removeByValue("C");
        System.out.println("Setelah removeByValue('C'): ");
        System.out.println("Normal:");
        list.print();
        System.out.println("Backward:");
        list.printBackward();
        System.out.println("Size: " + list.size());
        //Remove by Index dengan value yang tidak valid
        list.removeByValue("N");

        //Add At Index
        System.out.println("\n-- ADD AT INDEX --");
        System.out.println("List sebelum addAtIndex: ");
        list.print();
        //Add at Index dengan index yang valid [0] sebagai head
        list.addAtIndex(0, new Node("E"));
        System.out.println("Setelah addAtIndex(0, 'E'): ");
        System.out.println("Normal:");
        list.print();
        System.out.println("Backward:");
        list.printBackward();
        //Add at Index dengan index yang tidak valid
        list.addAtIndex(4, new Node("D"));
        System.out.println("Size: " + list.size());

        //Add After Value
        System.out.println("\n-- ADD AFTER VALUE --");
        //Add at After Value dengan value yang valid
        list.addAfterValue("B", new Node("C"));
        System.out.println("Setelah addAfterValue('B', 'C'): ");
        System.out.println("Normal:");
        list.print();
        System.out.println("Backward:");
        list.printBackward();
        //Add After Value dengan value yang tidak valid
        System.out.println("addAfterValue dengan nilai tidak ada ('Z'):");
        list.addAfterValue("Z", new Node("Z+"));
        
        //Add Before Value
        System.out.println("\n-- ADD BEFORE VALUE --");
        //Add Before Value dengan value yang valid
        list.addBeforeValue("E", new Node("N+"));
        System.out.println("Setelah addBeforeValue('E', 'N+'):");
        System.out.println("Normal:");
        list.print();
        System.out.println("Backward:");
        list.printBackward();
        //Add Before Value dengan value yang valid dan sebelum value node head
        list.addBeforeValue("B", new Node("K"));
        System.out.println("Setelah addBeforeValue('B', 'K') [sebelum head]:");
        System.out.println("Normal:");
        list.print();
        System.out.println("Backward:");
        list.printBackward();
        //Add Before Value dengan value yang tidak valid
        System.out.println("addBeforeValue nilai tidak ada ('Z'):");
        list.addBeforeValue("Z", new Node("Z-"));
 
        System.out.println("\nSize akhir: " + list.size());
    }
}
