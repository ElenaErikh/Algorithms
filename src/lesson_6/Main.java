package lesson_6;

public class Main{
    public static void main(String[] args) {
        Tree theTree = new Tree();

        theTree.insert(new Person(4, "Ivan", 35));
        theTree.insert(new Person(2, "Ivan1", 78));
        theTree.insert(new Person(3, "Ivan2", 24));
        theTree.insert(new Person(5, "Ivan3", 21));

        System.out.println("Max: ");
        theTree.max().display();
        System.out.println("Min: ");
        theTree.min().display();

        System.out.println("Find: ");
        theTree.find(3).display();

        theTree.delete(2);

        System.out.println();

        theTree.displayTree();
    }
}

class Person {
    public int id;
    public String name;
    public int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

class Node{  // этот класс не отвечает за создание узлов, это и есть сам узел в связанном списке
    public Person person;
    public Node leftChild;
    public Node rightChild;

    public void display(){
        System.out.println("ID: " + person.id + ", Имя: " + person.name + ", Возраст: " + person.age);
    }
}

class Tree{ // класс создания дерева
    private Node root; // корневой узел, точка отсчета

    public void insert(Person person){
        Node node = new Node(); // создаем новый узел с уже имеющимися для нас данными Person
        node.person = person;
        if (root == null){ // если дерева еще вообще нет, нет ни одного элемента
            root = node;   // то говорим, что текущий node это наш корневой верхний узел
        }else{
            Node current = root; // создаем переменную на кот сейчас находимся
            Node parent;  // чтобы определять нашего родителя
            while (true){  // сделано, чтобы пройти по всему дереву
                parent = current; // когда мы будем проходить ниже, то parent будет узел, на кот мы были
                if (person.id < current.person.id){  // сравниваем id которое хотим вставить с текущим id
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;  // находим пустой элемент и родителю этого элемента присаиваем значение
                        // пишем так (а не current = node), чтобы создать ссылки в LinkedList, т.е. у предыдущего элемента parent
                        // появился следующий элемент leftchild который = node
                        return;
                    }
                }else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key){  // ищем по  id
        Node current = root;  // current - узел, на кот мы в данный момент. берем его за точку отсчета (root )
        while (current.person.id != key){
            if (key < current.person.id){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
            if (current == null){  // это значит, что мы дошли до листа, т.е. элемента, у кот нет потомков
                return null;
            }
        }
        return current;
    }

    private void preOrder(Node rootNode){  // прямой обход
        if (rootNode != null){
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node rootNode){ // обратный обход
        if (rootNode != null){
            postOrder(rootNode.rightChild);
            rootNode.display();
            postOrder(rootNode.leftChild);
        }
    }

    public void inOrder(Node rootNode){
        if (rootNode != null){ // rootNode это исходный узел с кот начнем искать
            inOrder(rootNode.leftChild);  // вызываем этот же метод, но теперь исходным узлом будет левый потомок текущего узла
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public Node min(){
        Node current, last = null;
        current = root;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node max(){
        Node current, last = null;
        current = root;
        while (current != null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean delete(int id){
        Node current = root; // узел на кот мы сейчас
        Node parent = root;  // его родительский узел

        boolean isLeftChild = true;

        while (current.person.id != id){  // 1. ищем узел кот надо удалить
            parent = current;
            if (id < current.person.id){
                isLeftChild = true;
                current = current.leftChild;
            }else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null){ // 1. если узел - лист, нет преемников
            if (current == root){
                root = null;
            }else if (isLeftChild){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
        }else if (current.rightChild == null){ // 2. если есть один потомок (левый)
            if (current == null){
                root = current.leftChild;
            }else if (isLeftChild){
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
        }else if (current.leftChild == null){  // 2. если есть один потомок (правый)
            if (current == null){
                root = current.rightChild;
            }else if (isLeftChild){
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }
        }else {                                   // 3. если есть два потомка
            Node successor = getSuccessor(current);
            if (current == root){
                root = successor;
            }else if (isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node){ // поиск преемника в правом поддереве (идем на правую ветку, а по ней ищем самый левый элемент)
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public void displayTree(){
        Node current = root;
        System.out.println("Симметричный");
        inOrder(root);
        System.out.println("Прямой");
        preOrder(root);
        System.out.println("Обратный");
        postOrder(current);
    }
}







