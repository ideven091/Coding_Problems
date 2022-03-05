package com.cleo.dataStructures;


class GFG {
    public static boolean isSafe(int[][] board,int row, int col, int num) {

        for (int d = 0; d < board.length; d++) {

            if (board[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {

            if (board[r][col] == num) {
                return false;
            }
        }
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty)
        {
            return true;
        }

        for (int num = 1; num <= n; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board[row][col] = num;
                if (solveSudoku(board, n))
                {
                    // print(board, n);
                    return true;
                }
                else
                {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board, int N) {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }

    public static void main(String args[]) {

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

        if (solveSudoku(board, N))
        {
            print(board, N);
        }
        else {
            System.out.println("No solution");
        }
    }
}
/**
 * Given a partially filled sudoku
 * Find an optimal solution to fill the grid using the rules of sudoku
 */
class Sudoku {

    private static final int N = 4;


    static boolean isSafe(int[][] grid,int row, int column, int n) {

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


   static boolean solve(int[][] grid) {
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
            if (isSafe(grid,row, col, n)) {
                grid[row][col] = n;
                if (solve(grid))
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
        int[][] grid = {
                {1, 0, 3, 4},
                {0, 0, 2, 1},
                {0, 1, 0, 2},
                {2, 4, 0, 0}
        };
        solve(grid);
        print(grid);

    }
}

class PermutationsOfString{

    public static boolean isSafe(String str, int l, int i, int r){
        if(l!=0&&str.charAt(l-1)=='A'&&str.charAt(r)=='B')
            return false;
        return r != (l + 1) || str.charAt(i) != 'A' || str.charAt(l) != 'B';
    }

    public static void permute(String str,int l, int r) {

        if(l==r)

                System.out.print(str+ " ");
        else {

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

    }

}

public class BackTracking {
}
