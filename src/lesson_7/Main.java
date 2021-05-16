package lesson_7;

    // Графы

class Stack{
    private int maxSize;
    private int[] stackArr;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArr = new int[size];
        this.top = -1;
    }

    public void push(int i){
        stackArr[++top] = i;
    }

    public int pop(){
        return stackArr[top--];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public int peek(){
        return stackArr[top];
    }
}

class Vertex{  // класс Вершина
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;  // буква, метка кот будет обозначать вершину
        this.wasVisited = false;  // нужна, чтобы проверять были мы в этой вершине или нет
    }
}

// исп для работы матрицу смежности

class Graph{

    private final int MAX_VERTS = 32; // max количество вершин
    private Vertex[] vertexList;   // хранит сами объекты (вершины)
    private int[][] adjMat;        // матрица смежности, хранит связи между вершинами
    private int size;           // отображает нынешнее количество вершин
    private Stack stack;

    public Graph() {
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {   // заполняем матрицу нулями, обозначая, что изначально у нас нет ребер вообще
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    private int getAdjUnvisitedVertex(int ver){ // проверка смежности вершин
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i; // возвращаем вершину, смежную с ver
            }
        }
        return -1;
    }

    public void dfs(){  // метод обхода в глубину №1
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int v = getAdjUnvisitedVertex(stack.peek()); // берем самую верхнюю вершину стека
            if (v == -1){
                stack.pop(); // достаем эту вершину
            }else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v); // кладем вершину в стек, т.о. доходим до конца какой-либо ветки и после этого уходим назад.
            }
        }

        for (int i = 0; i < size; i++) {  // если мы заходим сделать обход еще раз, а будет true, то мы не сможем это сделать
            vertexList[i].wasVisited = false;
        }
    }

    public void addVertex (char label){   // сначала добавляем вершины
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){  // потом добавляем связи
        adjMat[start][end] = 1;   // добавляем связь (напр от А к В)
        adjMat[end][start] = 1;   // добавляем связь (от В к А)
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }
}

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');  // эту вершину не покажет, т.к. она не связана ни с одной другой

        graph.addEdge(0, 1); // связываем A и B
        graph.addEdge(1, 2); // связываем B и C
        graph.addEdge(0, 3); // связываем A и D
        graph.addEdge(3, 4); // связываем D и E

        //graph.displayVertex(4);

        graph.dfs();















    }
}
