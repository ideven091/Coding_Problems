package com.cleo.interview_preparation.sde_sheet;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next=null;
    }
}

class LinkedList{

    public Node insert(Node root, int data){
        if(root==null)
            root = new Node(data);
        Node current = root;
        while(current.next!=null)
            current=current.next;
        current.next=new Node(data);
        return root;
    }
    public  boolean detectLoop(Node head){
        // Add code here
        Node hair = head,tortoise=head;
        while(tortoise.next.next!=null){
            tortoise=tortoise.next.next;
            hair=hair.next;
            if(tortoise==hair)
                return true;
        }
        return false;
    }
}
public class Lists {


}
