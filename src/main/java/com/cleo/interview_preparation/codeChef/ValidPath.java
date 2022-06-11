package com.cleo.interview_preparation.codeChef;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge{

    private int source,destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}

class Vertex{
    int data;
    char label;

    public Vertex(int data, char label) {
        this.data = data;
        this.label = label;
    }

    public Vertex() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }
}

class AdjacencyListNode{
   private Edge edge;
   private Vertex vertex;

    public AdjacencyListNode(Edge edge, Vertex vertex) {
        this.edge=edge;
        this.vertex=vertex;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }
}

/**
 *
 */
public class ValidPath {


    public static boolean validPath(int n, String s, ArrayList<ArrayList<AdjacencyListNode>> adj) {
        int source = -1, destination = -1;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B' && i != destination)
                source = i;
            if (s.charAt(i) == 'B' && i != source)
                destination = i;
            if (!dfsUtil(adj, source, destination, visited))
                return false;
        }

        return true;
    }

    //Single source path between source and destination colors "BLUE" contains colors red and green
    public static boolean dfsUtil(ArrayList<ArrayList<AdjacencyListNode>> adj, int source, int destination,boolean[] visited) {
        int count = 0;
        visited[source]=true;
        for(var x:adj.get(source)){


        }

        return false;

    }


    public static void main(String[] args) throws Exception {

        try {
            Scanner in = new Scanner(System.in);
            int T = in.nextInt();

            while (T-- > 0) {
                int n = in.nextInt();
                int i = 0;
                while (i++ < n) {
                    int[] edge = new int[ 2 ];
                    ArrayList<ArrayList<AdjacencyListNode>> adj = new ArrayList<ArrayList<AdjacencyListNode>>();
                    for (int j = 0; j < n - 1; j++) {
                        adj.add(new ArrayList<>());
                    }
                    String s = in.nextLine();
                    List<Vertex> vertices = new ArrayList<>();
                    for (int j = 0; j < s.length(); j++) {
                        vertices.add(new Vertex(j,s.charAt(j)));
                    }


                    edge[ 0 ] = in.nextInt() - 1;
                    edge[ 1 ] = in.nextInt() - 1;
                    Edge edge1 = new Edge(edge[ 0 ], edge[ 1 ]);
                    AdjacencyListNode node = new AdjacencyListNode(edge1,vertices.get(i));
                    adj.get(edge[ 0 ]).add(node);

                    if (validPath(n, s, adj)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }


            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
