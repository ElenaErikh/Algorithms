package lesson7_hw;

//      Задание7.1. Приведите пример графа.
// Фильтр поиска товаров на сайтах магазинов. Есть поиск по категориям и подкатегориям, поиск по бренду, по акциям,
// по полу, по сезону, по цвету и т.д.


//        Задание7.2. Реализуйте базовые методы графа.

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}

class Graph {
    private final int MAX_VERTS = 12;
    private Vertex[] vertexList;
    private int[][] matrix;
    private int size;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        matrix = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        matrix[start][end] = 1;
        matrix[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

//        Задание7.3. Метод обхода в глубину.

    public void DFS(int val) {
        vertexList[val].wasVisited = true;

        for (int i = 0; i < size; i++) {
            int v = getAdjUnvisitedVertex(val);
            if (!vertexList[i].wasVisited && v != -1) {
                fullDisplayVertex(val, v);
                DFS(i);
            }
        }
    }

    private int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (matrix[ver][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public void fullDisplayVertex(int vertex1, int vertex2) {
        System.out.println(" Вершины " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
    }

    //        Задание7.4. Метод обхода в ширину.

    public void BFS(int val) {
        int[] queue = new int[size];
        int begin = 0;
        int end = 0;

        vertexList[0].wasVisited = true;
        queue[end++] = val;

        displayVertex(0);

        int val2;
        while (begin < end) {
            val = queue[begin++];

            for (int i = 0; i < size; i++) {
                val2 = getAdjUnvisitedVertex(val);
                if (!vertexList[i].wasVisited && val2 != -1) {
                    vertexList[i].wasVisited = true;
                    displayVertex(end);
                    queue[end++] = i;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('У');
        graph.addVertex('Ф');
        graph.addVertex('Х');
        graph.addVertex('Ц');
        graph.addVertex('Ч');
        graph.addVertex('Ъ');
        graph.addVertex('Ы');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        long start = System.nanoTime();
        graph.DFS(0);
        System.out.println("Время обхода в глубину: " + (System.nanoTime() - start) + " нс");

        start = System.nanoTime();
        graph.BFS(0);
        System.out.println("Время обхода в ширину: " + (System.nanoTime() - start) + " нс");


    }
}
