package TreeApp;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    
    Node root;

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    public int countNodes(Node node){
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeaves(Node node){
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1; // Ini adalah leaf
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int height(Node node){
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void preTraverse(Node node) {
        if (node == null) return;
        System.out.printf("[%d]", node.data);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void inTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%d]", node.data);
        inTraverse(node.right);
    }

    public void postTraverse(Node node) {
        if (node == null) return;
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.printf("[%d]", node.data);
    }

    public void levelTraverse(Node node){
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();  // Step 1: Buat queue kosong
        queue.add(node);                         // Step 2: Enqueue root

        while (!queue.isEmpty()) {               // Step 3: Loop selama queue tidak kosong
            Node current = queue.poll();         // a. Dequeue node
            System.out.printf("[%d]", current.data); // Kunjungi node

            if (current.left != null)            // b. Enqueue left child
                queue.add(current.left);
            if (current.right != null)           // c. Enqueue right child
                queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        
        BinaryTree tree = new BinaryTree();

        //Memasukkan node dengan nilai data pada parameter ke dalam objek tree
        tree.add(75);
        tree.add(29);
        tree.add(18);
        tree.add(16);
        tree.add(45);
        tree.add(21);
        tree.add(33);
        tree.add(22);
        tree.add(94);
        tree.add(81);

        //Pemanggilan method preTraverse
        System.out.println("\n\nMethod preTraverse: " );
        tree.preTraverse(tree.root);

        //Pemanggilan method inTraverse
        System.out.println("\n\nMethod inTraverse: " );
        tree.inTraverse(tree.root);

        //Pemanggilan method postTraverse
        System.out.println("\n\nMethod postTraverse: " );
        tree.postTraverse(tree.root);

        //Pemanggilan method levelTraverse
        System.out.println("\n\nMethod levelTraverse: ");
        tree.levelTraverse(tree.root);

        System.out.println("\n\nJumlah node dalam Binary Tree: " +tree.countNodes(tree.root));

        System.out.println("\n\nJumlah leaf dalam Binary Tree: " +tree.countLeaves(tree.root));

        System.out.println("\nTinggi Tree: " + tree.height(tree.root));
    }
}
