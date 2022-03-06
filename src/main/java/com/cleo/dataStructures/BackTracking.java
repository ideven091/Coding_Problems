package com.cleo.dataStructures;


/**
 * Given a partially filled sudoku
 * Find an optimal solution to fill the grid using the rules of sudoku
 */
class Sudoku {

    private static final int N = 9;


    static boolean isSafe(int[][] grid,int row, int column, int n, int N) {

        for (int k = 0; k < N; k++) {
            if (grid[k][column] == n || grid[row][k] == n)
                return false;
        }
        int grid1= (int)(Math.sqrt(N));
        int rs = row - row % grid1;
        int cs = column - column % grid1;

        for (int i = 0; i < grid1; i++) {
            for (int j = 0; j < grid1; j++) {
                if (grid[i + rs][j + cs] == n)
                    return false;
            }

        }
        return true;
    }


   static boolean solve(int[][] grid, int N) {
        int i = 0, j = 0;
        int row=-1,col=-1;
        boolean isEmpty =true;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    row=i;col=j;
                    isEmpty=false;
                    break;
                }
            }
            if(!isEmpty)
                break;
        }
      //  System.out.println(i+ " " + j);
        if(isEmpty)
            return true;
        for (int n = 1; n <= N; n++) {
            if (isSafe(grid,row, col, n,N)) {
                grid[row][col] = n;
                if (solve(grid,N))
                    return true;
                else
                grid[row][col] = 0;

            }

        }
        return false;


    }

    public static void print(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int N = board.length;
        solve(board, N);
        print(board);

    }
}

class PermutationsOfString{

    private static final char first='A',second='D';
    private static int count;
    public static boolean isSafe(String str, int l, int i, int r){
        if(l!=0 && str.charAt(l-1)==first&&str.charAt(i)==second)
            return false;
        if(r==(l+1)&&str.charAt(i)==first&&str.charAt(l)==second)
            return false;
        return true;

    }
    public static void permute(String str,int l, int r) {

        if(l==r) {

            System.out.print(str + " ");
            count++;
        }else {

            for(int i=l;i<=r;i++) {
                if(isSafe(str,l,i,r)) {
                    str = new String(swap(str, i, l));
                    permute(str, l + 1, r);
                    str = new String(swap(str, i, l));
                }
            }
        }
    }
    public static char[] swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
        return ch;
    }

    public static void main(String[] args) {
       String str = "ABCD";
       permute(str,0,str.length()-1);
        System.out.println();
        System.out.println(count);

    }

}


/**
 * Given a starting point in a grid and a destination
 * We put a rat in the starting point where there are obstacles in the grid
 * Further the rat can move either forward or down
 * We need to determine if the rat can reach the destination
 */
class RatInAMaze{


}

public class BackTracking {
}
