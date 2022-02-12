package com.cleo.dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class ProblemsOnGraphs {



    //DAG, Directed Weighted Acyclic Graph
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
       // bfs.add(0);

        return bfs;
    }
    // TODO: 18/01/22  
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        return null;
    }

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