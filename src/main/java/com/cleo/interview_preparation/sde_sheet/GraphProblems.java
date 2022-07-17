package com.cleo.interview_preparation.sde_sheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphProblems {

    public void addEdge(List<List<Integer>> adj, int u, int v){
        adj.get(u).add(v);
    }

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


    public static int maxRegion(List<List<Integer>> grid) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            adj.add(new ArrayList<>());
        }
        int answer = 0;
        for (int i = 0; i < grid.size() -1; i++) {

            for (int j = 0; j < grid.size() -1; j++) {

                int box = grid.get(i).get(j);
                if (box== 1) {
                    if (grid.get(i).get(j + 1) == 1) {

                        adj.get(box).add(grid.get(i).get(j + 1));
                        answer++;
                    }
                    if (grid.get(i + 1).get(j) == 1) {
                        adj.get(box).add(grid.get(i + 1).get(j));
                        answer++;
                    }
                    if (grid.get(i + 1).get(j + 1) == 1) {
                        adj.get(box).add(grid.get(i + 1).get(j + 1));
                        answer++;
                    }

                }

            }


        }
        for(var row:grid)
            System.out.println(row);

        for (var row : adj) {
            System.out.println(row);
        }
        return answer;
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

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,0,0},
                {0,1,1,0},
                {0,0,1,0},
                {1,0,0,0}
        };
        List<List<Integer>> graph = new ArrayList<>();
        int i=0;
        for(int[] row: grid){
            graph.add(new ArrayList<>());
            for(int box:row){
                graph.get(i).add(box);
            }
            i++;
        }
        System.out.println(maxRegion(graph));
    }
}
