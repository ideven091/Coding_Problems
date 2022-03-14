package com.cleo.dataStructures.graphs;


/**
 * Given a binary graph, find the number of islands in the graph
 */
public class NumberOfIslands {
    public int numOfIslands(char[][] grid) {
        // Code here
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    DFS(grid,i,j);
                }
            }

        }
        return count;
    }

    private void DFS(char[][] grid, int i, int j){
        if(i<0  || i >= grid.length|| j < 0 ||  j>= grid[i].length||grid[i][j]=='0')
            return;
        grid[i][j]='0';
        DFS(grid,i,j+1);
        DFS(grid,i,j-1);
        DFS(grid,i+1,j);
        DFS(grid,i-1,j);
        DFS(grid,i+1,j-1);
        DFS(grid,i-1,j-1);
        DFS(grid,i+1,j+1);
        DFS(grid,i-1,j+1);


    }

    public static void main(String[] args) {

        char[][] grid ={{'0','1'},{'1','0'},{'1','1'},{'1','0'}};
        System.out.println(new NumberOfIslands().numOfIslands(grid));
    }
}
