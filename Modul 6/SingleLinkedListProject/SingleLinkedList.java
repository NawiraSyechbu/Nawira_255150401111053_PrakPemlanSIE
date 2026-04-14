public class SingleLinkedList {

    Node head, tail;
    int size = 0;

    void init() { head = null; }
    boolean isEmpty() { return size == 0; }
    int size() { return size; }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        size++;
    }

    //find by value (a) --> revisi
    Node findByValue(Object data){
    Node current = head;
    while(current != null){              // ✅ stop saat current null
        if(current.data.equals(data)){   // ✅ bandingkan isi data, bukan reference
            return current;
        }
        current = current.next;
    }
    return null; // tidak ditemukan
}

    //find by index (b)
    Node findByIndex(int data) {
        if (data < 0 || data >= size) return null;
        Node current = head;
        int counter = 0; // mulai dari 0 karena index dimulai dari 0
        while (current != null) {
            if (counter == data) return current; // ketemu, kembalikan node
            current = current.next;
            counter++;
        }
        return null; // tidak ditemukan
    }

    //remove by index (c)
    void removeByIndex(int data){
        if (isEmpty() || data < 0 || data >= size) {
            System.out.println("[removeByIndex] Index " + data + " tidak valid.");
            return;
        }
        if (data == 0) {
            // Hapus head
            head = head.next;
            if (head == null) tail = null;
            System.out.println("[removeByIndex] Index " + data + " berhasil dihapus.");
            return;
        } else {
            Node prev = findByIndex(data - 1);
            Node toRemove = prev.next;
            prev.next = toRemove.next;
            System.out.println("[removeByIndex] Index " + data + " berhasil dihapus.");
            if (toRemove.next == null) {
                // Node yang dihapus adalah tail
                tail = prev;
            }
        }
        size--;
    }

    //remove by value (d)
    void removeByValue(Object data){
        if (isEmpty()) {
            System.out.println("[removeByValue] List kosong.");
            return;
        }
        // Jika node yang dihapus adalah head
        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) tail = null;
            System.out.println("[removeByValue] Nilai '" + data + "' berhasil.");
            size--;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                System.out.println("[removeByValue] Nilai '" + data + "' berhasil.");
                size--;
                return;
            }
            current = current.next;
        }
        System.out.println("[removeByValue] Nilai '" + data + "' tidak ditemukan.");
    }

    //add by index (e)
    void addAtIndex(int n, Node data){
        if (n < 0 || n > size) {
            System.out.println("[addAtIndex] Index " + n + " tidak valid.");
            return;
        }
        if (n == 0) {
            addFirst(data);
            System.out.println("[addAtIndex] Index " + n + " berhasil.");
        } else if (n == size) {
            addLast(data);
            System.out.println("[addAtIndex] Index " + n + " berhasil.");
        } else {
            Node prev = findByIndex(n - 1);
            data.next = prev.next;
            prev.next = data;
            System.out.println("[addAtIndex] Index " + n + " berhasil.");
            size++;
        }
    }

    //add after value (f)
    void addAfterValue(Object value, Node newNode) {
        Node target = findByValue(value);
        if (target == null) {
            System.out.println("[addAfterValue] Nilai '" + value + "' tidak ditemukan.");
            return;
        }
        newNode.next = target.next;
        target.next = newNode;
        System.out.println("[addAfterValue] Nilai '" + value + "' berhasil.");
        if (newNode.next == null) {
            tail = newNode;
        }
        size++;
    }

    //add before value (g)
    void addBeforeValue(Object value, Node newNode) {
        if (isEmpty()) {
            System.out.println("[addBeforeValue] List kosong.");
            return;
        }
        // Jika target adalah head
        if (head.data.equals(value)) {
            System.out.println("[addBeforeValue] Nilai '" + value + "' berhasil.");
            addFirst(newNode);
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(value)) {
                newNode.next = current.next;
                current.next = newNode;
                System.out.println("[addBeforeValue] Nilai '" + value + "' berhasil.");
                size++;
                return;
            }
            current = current.next;
        }
        System.out.println("[addBeforeValue] Nilai '" + value + "' tidak ditemukan.");
    }

    void print(){
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        System.out.println("Head: " +list.head);
        System.out.println("Tail: " +list.tail);

        list.addFirst(nodeA);
        System.out.println("Head: " +list.head.data);
        System.out.println("Tail: " +list.tail.data);

        list.addFirst(nodeB);
        System.out.println("Head: " +list.head.data);
        System.out.println("Tail: " +list.tail.data);

        list.addLast(nodeC);
        System.out.println("Head: " +list.head.data);
        System.out.println("Tail: " +list.tail.data);

        //Find by Value
        System.out.println("\n-- FIND BY VALUE --");
        System.out.println("Found: " +list.findByValue("A").data);

        //Find by Index
        System.out.println("\n-- FIND BY INDEX --");
        System.out.println("Found: " +list.findByIndex(2).data);

        //Remove by Index
        System.out.println("\n-- REMOVE BY INDEX --");
        //Pemanggilan method dengan value yang tidak valid
        list.removeByIndex(4);
        list.print();
        //Pemanggilan method dengan parameter input normal
        list.removeByIndex(2);
        list.print();

        //Remove by Value
        System.out.println("\n-- REMOVE BY VALUE --");
        //Pemanggilan method dengan parameter input normal
        list.removeByValue("A");
        System.out.println("Isi objek list: ");
        list.print();
        System.out.println("Size: " + list.size());
        //Pemanggilan method dengan value yang tidak ada
        list.removeByValue("N");

        //Add At Index
        System.out.println("\n-- ADD AT INDEX --");
        System.out.println("List sebelum addAtIndex: ");
        list.print();
        //Pemanggilan method dengan parameter input normal
        list.addAtIndex(1, new Node("E"));
        System.out.println("Setelah addAtIndex(1, 'E'): ");
        list.print();
        //Pemanggilan method dengan index yang tidak valid
        list.addAtIndex(3, new Node("D"));
        System.out.println("Setelah addAtIndex(1, 'D'): ");
        list.print();
        System.out.println("Size: " + list.size());

        //Add After Value (f)
        System.out.println("\n-- ADD AFTER VALUE --");
        //Pemanggilan method dengan parameter input normal
        list.addAfterValue("D", new Node("C"));
        System.out.println("Setelah addAfterValue('D', 'C'): ");
        list.print();
        //Pemanggilan method dengan value yang tidak ada
        System.out.println("addAfterValue dengan nilai tidak ada ('Z'):");
        list.addAfterValue("Z", new Node("Z+"));
        
        //Add Before Value (g)
        System.out.println("\n-- ADD BEFORE VALUE --");
        //Pemanggilan method dengan parameter input normal
        list.addBeforeValue("B", new Node("N+"));
        System.out.println("Setelah addBeforeValue('B', 'N+'):");
        list.print(); 
        //Pemanggilan method dengan value sebagai head
        list.addBeforeValue("A", new Node("@"));
        System.out.println("Setelah addBeforeValue('A', '@') [sebelum head]:");
        list.print();
        //Pemanggilan mehod dengan value yang tidak ada
        System.out.println("addBeforeValue nilai tidak ada ('Z'):");
        list.addBeforeValue("Z", new Node("Z-"));
        System.out.println("\nSize akhir: " + list.size());
    }
}
