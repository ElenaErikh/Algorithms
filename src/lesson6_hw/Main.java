package lesson6_hw;

import java.util.Arrays;

public class Main {

    static int[] arr = new int[20];

    public static void main(String[] args) {

//        Задание 6.1. Приведите пример использования древовидной структуры:
//          Иерархия классов исключений java: Object -- Throwable -- Error и Exception и т.д.

        Tree tree = new Tree();

        long start = System.nanoTime();
        tree.insert(new Constellation(1, "Андромеда", 722, 100));
        tree.insert(new Constellation(5, "Большая Медведица", 1280, 125));
        tree.insert(new Constellation(3, "Малая Медведица", 256, 20));
        tree.insert(new Constellation(11, "Кассиопея", 598, 90));
        tree.insert(new Constellation(7, "Гончие Псы", 465, 30));
        System.out.println("Время добавления элементов: " + (System.nanoTime() - start) + " нс");

        start = System.nanoTime();
        tree.max().display();
        System.out.println("Время поиска максимального узла: " + (System.nanoTime() - start) + " нс");

        start = System.nanoTime();
        tree.min().display();
        System.out.println("Время поиска минимального узла: " + (System.nanoTime() - start) + " нс");

        start = System.nanoTime();
        tree.find(1).display();
        System.out.println("Время поиска узла: " + (System.nanoTime() - start) + " нс");

        start = System.nanoTime();
        tree.delete(2);
        System.out.println("Время удаления узла: " + (System.nanoTime() - start) + " нс");

        start = System.nanoTime();
        tree.displayTree();
        System.out.println("Время вывода узла: " + (System.nanoTime() - start) + " нс");



        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }

        System.out.println(Arrays.toString(arr));
        HeapSort hp = new HeapSort();

        start = System.nanoTime();
        hp.sort(arr);
        System.out.println("Время пирамидальной сортировки: " + (System.nanoTime() - start) + " нс");

        System.out.println(Arrays.toString(arr));

    }
}

class Constellation {
    private int id;
    private String name;
    private int size;
    private int numberOfStars;

    public Constellation(int id, String name, int size, int numberOfStars) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.numberOfStars = numberOfStars;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}

//        Задание 6.2. Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.

class Node {
    public Constellation cons;
    public Node leftChild;
    public Node rightChild;

    public void display() {
        System.out.println("ID: " + cons.getId() + ", Созвездие: " + cons.getName() + ", Площадь: " + cons.getSize()
                + "кв. гр., Количество звезд: " + cons.getNumberOfStars());
    }
}

class Tree {
    private Node root;

//    Задание 6.3. Реализуйте методы поиска и вставки узла в дерево.

    public void insert(Constellation cons) {
        Node node = new Node();
        node.cons = cons;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (cons.getId() < current.cons.getId()) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key) {
        Node current = root;
        while (current.cons.getId() != key) {
            if (key < current.cons.getId()) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

//    Задание 6.4. Реализуйте базовые методы обхода дерева и метода дисплей. Реализуйте поиск максимума и минимума.

    private void preOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.rightChild);
            rootNode.display();
            postOrder(rootNode.leftChild);
        }
    }

    public void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public Node min() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node max() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

//    Задание 6.5. Реализуйте метод удаления узла

    public boolean delete(int id) {
        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;

        while (current.cons.getId() != id) {
            parent = current;
            if (id < current.cons.getId()) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == null) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public void displayTree() {
        Node current = root;
        System.out.println("Симметричный обход");
        inOrder(root);
        System.out.println("Прямой обход");
        preOrder(root);
        System.out.println("Обратный обход");
        postOrder(current);
    }
}

//    Задание 6.6
//    Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.

class HeapSort {
    private static int heapSize;

    public static void sort(int[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
    }

    private static void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }

    private static void heapify(int[] a, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && a[i] < a[l]) {
            largest = l;
        }
        if (r < heapSize && a[largest] < a[r]) {
            largest = r;
        }
        if (i != largest) {
            swap(a, i, largest);
            heapify(a, largest);
        }
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


