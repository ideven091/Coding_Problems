package com.cleo;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

class SinglyLinkedList{

    private static     class Node{

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            //   this.next = next;
        }
    }

    private Node root;

    public int getLength(){
        if(root==null)
            return 0;
        else{
            int count = 0;
            while(root!=null){
                count++;
                root = root.next;
            }
            return count;
        }
    }

    public void insertAtBeginning(int data){
        Node temp = new Node(data);
        if(root==null){
           root = temp;


        }else {
            temp.next = root;
            root = temp;
        }
    }
    public void insertAtEnd(int data){
        if(root==null) {
            root = new Node(data);
        }else {
            Node current= root,prev=root;
            while (current!= null) {
                prev=current;
                current = current.next;
            }
            current= new Node(data);
            prev.next = current;
            current.next = null;

        }

    }

    public void insertAtIth(int data, int position){
        Node current = root, prev = root;
        int p = 0;
        while(p<position){
            prev = current;
            current = current.next;
            p++;
        }
        Node temp = new Node(data);
        prev.next = temp;
        temp.next = current;
    }

    public void printList(){
        Node current = root;
        while(current!=null){
            System.out.print(current.data +" ");
            current = current.next;
        }
    }

    public void printInReverse(){

    }

}




public class ProblemsOnLists {

    public static void main(String[] args) throws IOException {
        SinglyLinkedList list = new SinglyLinkedList();
       // list.insertAtBeginning(1);
       // list.insertAtBeginning(2);
        //list.insertAtEnd(3);
        //list.insertAtEnd(4);
        //list.insertAtIth(100,2);
        //list.printList();
        //System.out.println();
        //System.out.println(list.getLength());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while(n-->0){
            list.insertAtBeginning(Integer.parseInt(reader.readLine()));

        }
        list.printList();
    }


}
