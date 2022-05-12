package com.cleo.revision.dataStructures;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Graph1{

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {

            //     System.out.println(edges.get(i).get(1));
            addEdge(adj, edges.get(i).get(0), edges.get(i).get(1));

        }
        //  int[] result = new int[n];
        Map<Integer, Integer> result = new LinkedHashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int a = adj.get(s).size();
        boolean[] visited = new boolean[n + 1];

        queue.add(s);
        visited[s] = true;
        int i = 1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            //System.out.println(u);


            visited[u] = true;

            for (int vertex : adj.get(u)) {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    queue.add(vertex);
                    result.compute(vertex,(k,v)->v==null?6:v+6);


                }
            }
        }

       return null;
    }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                    int n = Integer.parseInt(firstMultipleInput[0]);

                    int m = Integer.parseInt(firstMultipleInput[1]);

                    List<List<Integer>> edges = new ArrayList<>();

                    IntStream.range(0, m).forEach(i -> {
                        try {
                            edges.add(
                                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                            .map(Integer::parseInt)
                                            .collect(toList())
                            );
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });

                    int s = Integer.parseInt(bufferedReader.readLine().trim());
                    List<Integer> result = bfs(n, m, edges, s);

                    bufferedWriter.write(
                            result.stream()
                                    .map(Object::toString)
                                    .collect(joining(" "))
                                    + "\n"
                    );

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }


public class ProblemsOnGraphs {




    //DAG, Directed Weighted Acyclic Graph
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfsGraph = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                bfsGraph.set(i,adj.get(i).get(j));
            }
        }
        return bfsGraph;
    }
    // TODO: 18/01/22  


    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public ArrayList<ArrayList<Integer>> printGraph(
            int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<ArrayList<Integer>> clone = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            clone.add(new ArrayList<>());
        }
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                clone.get(i).add(adj.get(i).get(j));
            }
        }
        return clone;
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);

        printGraph(adj);
        System.out.println(bfsOfGraph(V,adj));
    }
}


class KittyCalculations{

}