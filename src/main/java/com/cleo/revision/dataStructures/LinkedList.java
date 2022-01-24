package com.cleo.revision.dataStructures;

public class LinkedList<T> {

    private static class Node<T>{
        private T element;
        private Node<T> next;

    }
    private Node<T> root, head, current;
    private int length;

    public int length(){
        return length;
    }

    public LinkedList(T element){
        root = new Node<>();
        root.element = element;
        root.next = null;
        current = root;
        length++;
        head = root;
    }

    public void insert(T element){
        if(length() == 0){
            root = new Node<>();
            root.element = element;
            root.next = null;
            current = root;
            length++;
            head = root;
        }else{
            root.next = new Node<>();
            root = root.next;
            root.element = element;
            current = root;
            root.next = null;
            length++;
        }
        /*
        *   Will need to do traversal from bYeginning till end for linked list, 5th standard stuff
        *   INTELLIJ IDEA WILL DO IT EASILY
        * I should be doing NLP
        * Python, NLP,Machine Learning.. .Django,Spring Boot,React,JWT Token
         */
    }
    public T pop(){
        if(length()<=0){
            throw new IndexOutOfBoundsException("JetBrains made an error, please try again");
        }else{
            T answer = root.element;

            /*
            *   This works in case of ArrayList, In Linked List we always traverse from beginning
            * to get the last element in O(n)
             */
           // current = root;
           // root.next = null;
            //root= current;
            //current.next = root;
         //    root = current;

            //  root = current;
             //root = current.next;
           //  root.next = null;
             //current.next = null;
         //   System.out.println("Head=" + head.element);
             //current.next = root;
             //root = current;
             //current.next = root;
             //root.next = null;
            //System.out.println(root.element);
            //System.out.println(current.element);
           //--length;
         Node<T> temp = head;
           while(temp.next!=null){
               current = temp;
               temp = temp.next;
             //  System.out.println(current.element);


           }
           answer = temp.element;
           root = current;
          root.next = null;
          // answer = root.element;
            --length;
           return answer;

          //  return answer;

        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(1);
        list.insert(2);
        list.insert(4);
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());//Error now
    }
}
