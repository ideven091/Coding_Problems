package com.cleo.dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
        // Your code here
        s1.push(x);
        s2.push(x);


    }


    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        // Your code here

        return s2.pop();
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
       stackQueue.Push(1);
       stackQueue.Push(2);
    //   stackQueue.Pop();
     //   stackQueue.s1.push(1);

          System.out.println(stackQueue.Pop());
    }
}
class MyQueue {

    int front, rear;
    int[] arr = new int[100005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    //Function to push an element x in a queue.
    void push(int x) {
        // Your code here
        arr[front++] = x;
    }

    //Function to pop an element from queue and return that element.
    int pop() throws Exception{
        // Your code here
        if(rear<=front)
        return arr[rear++];
        else
            return -1;
    }

    public static void main(String[] args) {

    }
}
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
    return 0;
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
