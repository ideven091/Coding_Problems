package com.cleo.interview_preparation.graphs;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

    public void addEdge(int u, int v, boolean isDirected){
       adj.get(u).add(v);
       if(!isDirected)
           adj.get(v).add(u);
    }


    public void init(int n, int[][] edges){
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            addEdge( edge[ 0 ], edge[ 1 ], true);
        }
    }

    public boolean validPathV2(int n, int[][] edges, int source, int destination) {
      init(n,edges);
        int countPath=0;
        System.out.println(adj);
        countPath = dfsUtil(source,destination,countPath);
        return countPath!=0;

    }
    public int countPaths(int n, int[][] edges, int source, int destination) {
        init(n,edges);
        int countPath=0;
        System.out.println(adj);
        countPath = dfsUtil(source,destination,countPath);
        return countPath;

    }
    List<List<Integer>> paths = new ArrayList<List<Integer>>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        init(graph.length, graph);
        for (int[] edge : graph) {
            addEdge( edge[ 0 ], edge[ 1 ], true);
        }
        return paths;

    }


    public int dfsUtil(int source, int destination, int count){
        if(source==destination)
            return count;
        else{

            for(int u:adj.get(source)){

                    ++count;
                    dfsUtil(u, destination, count);

            }
        }
        return count;
    }

    /**
     *
     * @param cost  Given a m x n grid filled with non-negative numbers,
     * @return find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
     * Note: You can only move either down or right at any point in time.
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     */
    public int minPathSum(int[][] cost) {
        int[][] T = new int[ cost.length][cost[0].length];
        int sum=0,max_sum=0;

        int M = cost.length,N = cost[0].length;
        // fill the matrix in a bottom-up manner
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                T[i][j] = cost[i][j];

                // fill the first row (there is only one way to reach any cell
                // in the first row from its adjacent left cell)
                if (i == 0 && j > 0) {
                    T[0][j] += T[0][j - 1];
                }

                // fill the first column (there is only one way to reach any cell
                // in the first column from its adjacent top cell)
                else if (j == 0 && i > 0) {
                    T[i][0] += T[i - 1][0];
                }

                // fill the rest with the matrix (there are two ways to reach any
                // cell in the rest of the matrix, from its adjacent
                // left cell or adjacent top cell)
                else if (i > 0 && j > 0) {
                    T[i][j] += Integer.min(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
        for(int[] row:T){
            System.out.println(Arrays.toString(row));
        }
        return T[M-1][N-1];

    }



    public static void main(String[] args) {
        int n = 3; int[][] edges = {{0,1},{1,2},{0,2}}; int source = 0; int destination = 2;
        int n1 = 6, source1 = 0, destination1 = 5; int[][] edges1 ={{0,1},{0,2},{3,5},{5,4},{4,3}};

        Graph g = new Graph();
        System.out.println(g.validPathV2(n,edges,source,destination));
       // System.out.println(g.validPathV2(n,edges,source,destination));
        Graph g1 = new Graph();
        System.out.println(g1.countPaths(n,edges,source,destination));
        System.out.println();
        Graph g2 = new Graph();
        System.out.println(g2.countPaths(n1,edges1,source1,destination1));
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(g2.minPathSum(grid));
    }
}
