package com.cleo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProblemsOnQueues {
    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER startX
     *  3. INTEGER startY
     *  4. INTEGER goalX
     *  5. INTEGER goalY
     */

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        // Write your code here

    }
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        while(n-->0){
            String[] s= input.readLine().split(" ");
            if(s[0].equalsIgnoreCase("1")){
                queue.add(Integer.parseInt(s[1]));
            }else if(s[0].equalsIgnoreCase("2")){
                queue.poll();
            }else if(s[0].equalsIgnoreCase("3"))
                System.out.println(queue.peek());
        }
    }
}
