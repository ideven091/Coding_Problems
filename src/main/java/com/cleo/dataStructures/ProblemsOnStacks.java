package com.cleo.dataStructures;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

 class Stack<T extends Comparable<T>> {

    protected static class Node<T>{
        T data;
        Node<T> next;
        public Node(T data){
            this.data = data;
            next = null;
        }
    }
    private  Node<T> top, root;

    public  void push(T data){
        if(top == null) {
            top = new Node<>(data);
            root = top;
        }
        else{
            Node<T> current = top;
         top = new Node<>(data);
          top.next = current;



        }
    }
    public  T pop(){
        if(top==null)
            return null;
        Node<T> current = top, prev = top;

        T answer = top.data;
        top = top.next;
        //
        // current = null;


        return answer;
    }

    public  void print(){
        Node<T> temp = root;
        while(temp!=null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
    }
    public  boolean find(T x){
        Node<T> temp = root;
        while(temp!=null){
            if(temp.data == x)
                return true;
            temp = temp.next;
        }
        return false;
    }
    public T peek(){
        return root.data;
    }


    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> temp = root;
        while(temp!=null) {
            stringBuilder.append(temp.data);
            temp = temp.next;
        }
        return stringBuilder.toString();
    }



}

class Problems{

   static Stack<Integer> stack, current;

    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        int i=0,j=0;
        List<Integer> max = new ArrayList<>();
     //   System.out.println(operations.size());
    //    int n = Integer.parseInt(operations.get(0));

        for (int k = 0; k < operations.size(); k++) {


           var str = operations.get(k).split(" ");
          System.out.print(str[0]+ " ");
           if(str[0].equals("1")){
               if(stack==null) {
                   stack = new Stack<>();
                   stack.push(Integer.parseInt(str[1]));
                   current = stack;

               }
               else{
                   current.push(Integer.parseInt(str[1]));
               }
               
           }
           else if(str[0].equals("2")){
               assert current != null;
               System.out.println(current.peek());
           }
           else if(str[0].equals("3")){
               Stack<Integer> temp = stack;
               int max1 = -1;
               while(temp!=null){
                    if(max1<temp.peek())
                        max1 = temp.peek();
                    temp.pop();

               }
               max.add(max1);

           }


       }
  //      System.out.println(stack);

        return max;

    }
    static boolean ispar(String x)
    {
        Stack<Character> stack = new Stack<>();
        // add your code here
        String opening = "[({";
        String closing = "])}";
        for(char c: x.toCharArray()){

            if(opening.contains(String.valueOf(c)))
                stack.push(c);
            else {
                if(stack.pop()==null)
                    return false;
                stack.pop();
            }

        }
        return true;


    }


}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res = Problems.getMax(ops);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
