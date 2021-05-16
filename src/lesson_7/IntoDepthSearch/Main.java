package lesson_7.IntoDepthSearch;

// способ обхода в глубину №2

class Vertex{  // класс Вершина
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;  // буква, метка кот будет обозначать вершину
        this.wasVisited = false;  // нужна, чтобы проверять были мы в этой вершине или нет
    }
}

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

    public void addVertex (char label){   // сначала добавляем вершины
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){  // потом добавляем связи
        adjMat[start][end] = 1;   // добавляем связь (напр от А к В)
        adjMat[end][start] = 1;   // добавляем связь (от В к А)
    }

    private int getAdjUnvisitedVertex(int ver){ // ищем вершины, смежные с ver
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i; // возвращаем вершину, смежную с ver
            }
        }
        return -1;
    }

    public void DFS(int f){ // задаем стартовую вершину f
        vertexList[f].wasVisited = true;

        for (int i = 0; i < size; i++) {
            int v = getAdjUnvisitedVertex(f);
            if (!vertexList[i].wasVisited && v != -1){ // смотрим посетили ли мы уже эту вершину и есть ли с ней связанные
                fullDisplayVertex(f, v);  // f на которой мы сейчас находимся и v смежная с ней вершина
                DFS(i);
            }
        }
        for (int i = 0; i < size; i++) {  // если мы заходим сделать обход еще раз, а будет true, то мы не сможем это сделать
            vertexList[i].wasVisited = false;
        }
    }

    public void fullDisplayVertex(int vertex1, int vertex2){
        System.out.println(" Вершины " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
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

        graph.DFS(0);
    }
}
