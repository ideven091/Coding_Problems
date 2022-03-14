package com.cleo.codeChef.greedy;

import java.util.PriorityQueue;

class Node{
    char ch;
    int freq;
    Node left;
    Node right;

    public Node(char ch, int freq,Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left=left;
        this.right=right;
    }

}

public class HuffmanEncoding {


    static void printHCodes(char[] arr, int[] freq){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((n1,n2)->n1.freq-n2.freq);
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(new Node(arr[i],freq[i], null, null));
        }
        while(priorityQueue.size()>1){
            Node l = priorityQueue.poll();
            Node r = priorityQueue.poll();
            assert r != null;
            priorityQueue.add(new Node('$',l.freq+r.freq,l,r));

        }
        assert priorityQueue.peek() != null;
        printRec(priorityQueue.peek(),"");
    }

    static void printRec(Node root, String s){
        if(root.ch!='$'){
            System.out.println(root.ch + " " + s);
            return;
        }
        printRec(root.left,s+"0");
        printRec(root.right,s+"1");


    }

    public static void main(String[] args) {
        char[] input = {'a','d','b','e','f'};
        int[] freq = {10,50,20,40,80};
        printHCodes(input,freq);
    }
}
