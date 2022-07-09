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

    int count = 0;
    private Node head;

    public boolean detectLoop() {
        Node hare = head.next;
        Node tortoise = head;
        while (hare != tortoise) {
            if (hare == null || hare.next == null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public void removeLoop() {
        // code here
        // remove the loop without losing any nodes
        Node tortoise = head, hair = head.next;
        int count = 0;
        int length = 0;

        while (hair != tortoise) {
            if (hair.next == null || tortoise == null)
                break;
            tortoise = tortoise.next;
            hair = hair.next.next;
            count++;
        }
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        if (count >= length)
            return;
        current = head;
        for (int i = 0; i < count; i++) {
            current = current.next;
        }
        Node temp = current.next;
        temp = temp.next;
        current.next = temp;


    }

    public void insert(int data) {

        if (length() <= 0) {
            head = new Node(data);
            count += 1;

        } else {
            Node curr = head;
            while(curr.next!=null)
                curr=curr.next;
            curr.next= new Node(data);
            count++;

        }

    }


    public int length(){
       return count;
    }
    public void printList(){
        Node current = head;
        while(current!=null){
            System.out.print(current.data + " ");
            current=current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Lists l = new Lists();
        l.insert(1);
       l.insert(2);
       l.insert(3);
       l.insert(4);
        l.printList();


    }


}
