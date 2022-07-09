package com.cleo.interview_preparation.sde_sheet;

import java.util.ArrayList;

public class GraphProblems {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        visited[0]=true;
        int source = 0;
        int count = 0;
        for (int i = 0; i < V-1; i++) {
            for(int vertex:adj.get(i)){
                visited[vertex]=true;
                if(dfsUtil(adj,source,vertex,visited))
                    return false;

            }
        }
        return true;

    }
    public boolean dfsUtil( ArrayList<ArrayList<Integer>> adj, int source, int destination, boolean[] visited){
        if(source==destination)
            return true;
        visited[source]=true;
        for(int vertex:adj.get(source)){
            if(!visited[vertex])
                dfsUtil(adj,vertex,destination,visited);
        }
        return false;
    }
}
