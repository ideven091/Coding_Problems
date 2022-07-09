package com.cleo.interview_preparation.sde_sheet;
// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;


public class GfG
{
   private static class Node
    {
        int data;
        Node next;
    }

    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }

        while (last.next != null)
            last = last.next;
        last.next = curr;
    }

    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t--> 0)
        {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, pos);

            System.out.println(length(tail));
            removeLoop(head);

            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
       Node tortoise = head,hair=head.next;
        int count = 0;
        int length = 0;

        while(hair!=tortoise){
            if(hair.next==null||tortoise==null)
                break;
            tortoise=tortoise.next;
            hair=hair.next.next;
            count++;
        }
       Node current = head;
        while (current!=null){
            length++;
            current=current.next;
        }
        if(count>=length)
            return;
        current=head;
        for (int i = 0; i < count; i++) {
            current=current.next;
        }
       Node temp = current.next;
        temp = temp.next;
        current.next=temp;




    }

}
// } Driver Code Ends



class Solution
{
    //Function to remove a loop in the linked list.
}