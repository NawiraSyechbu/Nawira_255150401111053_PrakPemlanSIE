package TreeApp;

class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }

    public void add(int data) {
        if (data > this.data) {
            if (this.right == null) {
                this.right = new Node(data);
            } else this.right.add(data);
        }

        if (data < this.data) {
            if (this.left == null) {
                this.left = new Node(data);
            } else this.left.add(data);
        }
    }
}
