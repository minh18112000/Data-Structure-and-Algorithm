package hw7_18001163;

import hw7_18001163.BinarySearchTree.Node;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer, Node> tree = new BinarySearchTree();
        /*
         *   50 
         *  /  \ 
         * 30   70 
         * / \  / \ 
         *20 40 60 80
         */
        Node<Integer> root = tree.addRoot(50);
        tree.insert(root, 30);
        tree.insert(root, 70);
        tree.insert(root, 20);
        tree.insert(root, 40);
        tree.insert(root, 60);
        tree.insert(root, 80);

        tree.print(root, 1);
        System.out.println("=================");
        System.out.println(tree.findMin(root));
        System.out.println(tree.binarySearch(root, 90));
        tree.search(root, 50);
        tree.delete(root, 20);
        tree.delete(root, 50);
        System.out.println("=================");
        tree.print(root, 1);
        // Do máy em không có SSD và ram hơi yếu nên khi insert với (10^6, 10^7, 10^8) 
        // phần tử thì bị treo máy nên cũng không search để so sánh thời gian được ạ.
    }
}