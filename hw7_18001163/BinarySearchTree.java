package hw7_18001163;

import hw5_18001163.BinaryTreeInterface;

public class BinarySearchTree<E extends Comparable, T> implements BinaryTreeInterface<T> {

    protected static class Node<E> {
        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child
        private Node<E> right; // a reference to the right child
        // Constructs a node with the given element and neighbors. ∗/

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

    }

    private Node<E> root = null;
    private int size = 0;

    @Override
    public T root() {
        return (T) root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(T p) {
        if (!(p instanceof Node))
            return -1;
        if (isEmpty() || p == null)
            return -1;
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    @Override
    public T parent(T p) {
        if (!(p instanceof Node))
            return null;
        if (isEmpty())
            return null;
        Node<E> newNode = (Node<E>) p;
        if (newNode != null && newNode.getParent() != null) {
            return (T) newNode.getParent();
        }
        return null;
    }

    @Override
    public T left(T p) {
        if (!(p instanceof Node))
            return null;
        if (isEmpty())
            return null;
        Node<E> newNode = (Node<E>) p;
        if (newNode != null && newNode.getLeft() != null) {
            return (T) newNode.getLeft();
        }
        return null;
    }

    @Override
    public T right(T p) {
        if (!(p instanceof Node))
            return null;
        if (isEmpty())
            return null;
        Node<E> newNode = (Node<E>) p;
        if (newNode != null && newNode.getRight() != null) {
            return (T) newNode.getRight();
        }
        return null;
    }

    @Override
    public T sibling(T p) {
        if (!(p instanceof Node))
            return null;
        if (isEmpty() || p == null)
            return null;
        Node<E> node = (Node<E>) p;
        if (node.getParent() != null) {
            T nodeParent = (T) node.getParent();
            if (numChildren(nodeParent) != 2) {
                return null;
            } else {
                Node<E> left = node.parent.getLeft();
                if (left.getElement() == node.getElement())
                    return (T) node.parent.getRight();
                Node<E> right = node.parent.getRight();
                if (right.getElement() == node.getElement())
                    return (T) node.parent.getLeft();
            }
        }
        return null;
    }

    public Node<E> addRoot(E element) {
        if (root == null) {
            Node<E> newNode = new Node<E>(element, null, null, null);
            root = newNode;
            size++;
        } else {
            root.setElement(element);
        }
        return root;
    }

    public void print(Node p, int level) {
        if (p == null)
            return;
        print(p.getRight(), level + 1);
        for (int i = 1; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(p.getElement());
        print(p.getLeft(), level + 1);
    }

    public E findMin(Node<E> root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root.getElement();
    }

    public T binarySearch(Node<E> root, E key) {
        if (root == null) {
            return null;
        }
        if (root.getElement().compareTo(key) == 0) {
            return (T) root;
        } else if (key.compareTo(root.getElement()) < 0) {
            return binarySearch(root.getLeft(), key);
        } else if (key.compareTo(root.getElement()) > 0) {
            return binarySearch(root.getRight(), key);
        }
        return null;
    }

    public T insert(Node<E> root, E key) {
        if (root == null) {
            root = new Node(key, null, null, null);
            return (T) root;
        }
        if (key.compareTo(root.getElement()) < 0) {
            root.setLeft((Node<E>) insert(root.getLeft(), key));
        } else if (key.compareTo(root.getElement()) > 0) {
            root.setRight((Node<E>) insert(root.getRight(), key));
        } else {
            System.out.println("Da co phan tu " + key + " trong cay");
        }
        return (T) root;
    }

    public T delete(Node<E> root, E key) {
        if (root == null) {
            return (T) root;
        }
        if (key.compareTo(root.getElement()) < 0) {
            root.setLeft((Node<E>) delete(root.left, key));
        } else if (key.compareTo(root.getElement()) > 0) {
            root.setRight((Node<E>) delete(root.right, key));
        } else {
            if (root.getLeft() == null) {
                return (T) root.right;
            } else if (root.getRight() == null) {
                return (T) root.left;
            }
            root.setElement((E) findMin(root.right));
            root.setRight((Node<E>) delete(root.right, root.getElement()));
        }
        return (T) root;
    }

    public void search(Node<E> p, E key) {
        if (p == null) {
            return;
        }
        if (p.getElement().compareTo(key) == 0) {
            System.out.println(p.getElement());
        }
        if (p.getLeft() != null) {
            search(p.getLeft(), key);
        }
        if (p.getRight() != null) {
            search(p.getRight(), key);
        }
    }

}
