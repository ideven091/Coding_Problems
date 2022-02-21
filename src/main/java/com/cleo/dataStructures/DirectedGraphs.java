package com.cleo.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraphs {

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
      //  adj.get(v).add(u);
    }

    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, boolean[] recursionStack){
        visited[i] =true;
        recursionStack[i]=true;

        for(int u:adj.get(i)){
            if(!visited[u]&&DFSRec(adj,u,visited,recursionStack)) {
              //  Stream.of(visited).forEach(System.out::println);
               // System.out.println(List.of(recursionStack));
                //System.out.println("Hi1");
                return true;
            }
            else if(recursionStack[u]) {
                //System.out.println(List.of(recursionStack));
                //System.out.println("Hi2");
                return true;
            }
        }
        recursionStack[i]=false;
     //   System.out.println("Hi3");
        return false;
    }

    // TODO: 21/02/22
    public boolean is_Possible(int[][] grid) {
        // Code here
        int V = grid[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length-1; j++) {
                addEdge(adj,grid[i][j],grid[i][j+1]);
            }
        }
        boolean[] recursionStack = new boolean[V];
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                if(DFSRec(adj,i,visited,recursionStack))
                    return true;
            }

        }
        return false;
    }

    /**
     * Kahn's Algorithm for Sorting a Directed Acyclic Graph
     */
    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] in_degree = new int[V];

        for (int u = 0; u < V; u++) {
            for (int x:adj.get(u))
                in_degree[x]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (in_degree[i] == 0)
                q.add(i);


        while (q.isEmpty()==false) {
            int u = q.poll();
            System.out.print(u+" ");

            for (int x: adj.get(u))
                if (--in_degree[x] == 0)
                    q.add(x);
        }
    }

    /**
     * Modification of Kahn's Algorithm of Topological Sorting a DAG to
     * detecting a cycle in a directed graph
     */
    static boolean detectCycleV2(ArrayList<ArrayList<Integer>> adj, int V){
        int[] in_degree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int x:adj.get(u))
                in_degree[x]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(in_degree[i]==0)
                queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int x:adj.get(u)){
                if(--in_degree[x]==0)
                    queue.add(x);
                count++;
            }
        }
        return count==V;
    }

    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];

        boolean[] recursionStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                if(DFSRec(adj,i,visited,recursionStack))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DirectedGraphs dg = new DirectedGraphs();
        var adj = new ArrayList<ArrayList<Integer>>();
        int V = 4;
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        dg.addEdge(adj,0,1);
        dg.addEdge(adj,0,2);
     //  dg.addEdge(adj,1,2);
        dg.addEdge(adj,2,3);
        System.out.println(detectCycleV2(adj,V));
        topologicalSort(adj,V);
    }
}
