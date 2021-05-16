package lesson_7.WideSearch;

//  Обход в ширину

import java.util.LinkedList;
import java.util.Queue;

class Vertex{  // класс Вершина
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;  // буква, метка кот будет обозначать вершину
        this.wasVisited = false;  // нужна, чтобы проверять были мы в этой вершине или нет
    }
}

// исп для работы матрицу смежности

class Graph {

    private final int MAX_VERTS = 32; // max количество вершин
    private Vertex[] vertexList;   // хранит сами объекты (вершины)
    private int[][] adjMat;        // матрица смежности, хранит связи между вершинами
    private int size;           // отображает нынешнее количество вершин

    public Graph() {
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

    public void bfs(){  // метод поиска в ширину №1
        Queue<Integer> queue = new LinkedList<>(); // создаем очередь
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;  // смежная с v1 вершина
        while (!queue.isEmpty()){ // пока не опустеет очередь продолжаем цикл
            int v1 = queue.remove(); // записываем значение из очереди, при этом удаляем его из очереди
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1){ // если v2 смежна с v1
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for (int i = 0; i < size; i++) { // сброс флагов
            vertexList[i].wasVisited = false;
        }
    }

    public void bfs2(int v){  // метод поиска в ширину №2
        int[] queue = new int[size];  // здесь уже исп массив
        int qH = 0; // имитируем очередь из массива, это голова
        int qT = 0;  // хвост

        vertexList[0].wasVisited = true;
        queue[qT++] = v;

        displayVertex(0);

        int v2;
        while (qH < qT){
            v = queue[qH++];

            for (int i = 0; i < size; i++) {
                v2 = getAdjUnvisitedVertex(v);  // помещаем в v2 вершину, смежную с v
                if (!vertexList[i].wasVisited && v2 != -1){ // если смежные вершины есть и мы ее еще не посещали
                    vertexList[i].wasVisited = true;
                    displayVertex(qT);
                    queue[qT++] = i;
                }
            }
        }
        for (int i = 0; i < size; i++) { // сброс флагов
            vertexList[i].wasVisited = false;
        }
    }

    public void fullDisplayVertex(int vertex1, int vertex2){
        System.out.println(" Вершины " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
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

        graph.bfs();
        //graph.bfs2(0);
    }
}
