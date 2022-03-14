package com.cleo.dataStructures.graphs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Date 09/03/2022
 * @author Deven Kalra
 *
 * Given a directed acyclic graph, do a topological sort on this graph.
 *
 * Kruskal Algorithm for BFS of DAG
 *
 * Space and time complexity is O(V+E).
 */
public class TopologicalSort {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
    }

    public static int[] topologicalSorting(ArrayList<ArrayList<Integer>> adj, int V){
        // boolean[] visited =  new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        int[] in_degree = new int[V];
        for (int u = 0; u < V; u++) {
            for(int x:adj.get(u)){
                in_degree[x]++;
            }
        }

        /*
         * Added job for which finish time is the earliest
         */
        for (int u = 0; u < V; u++) {
            if(in_degree[u]==0)
                queue.add(u);
        }
        int i=0;
        int[] result = new int[V];
        while(!queue.isEmpty()){
            int u = queue.poll();

            /*
             * Storing result for earliest finished jobs
             */
            result[i++]=u;

            //visited[u]=true;
            for(int x:adj.get(u)){
                /*
                 * Adding to queue when job is finished
                 */
                if(--in_degree[x]==0)
                    queue.add(x);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        var adj = new ArrayList<ArrayList<Integer>>();
        int V = 3;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        System.out.println(Arrays.toString(topologicalSorting(adj,V)));
    }
}
