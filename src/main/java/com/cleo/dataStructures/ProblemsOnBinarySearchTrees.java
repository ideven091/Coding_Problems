package com.cleo.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinarySearchTree{

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static Node root;
    public Node insert(Node root, int data){
        if(root==null)
            root = new Node(data);
        else if(data<root.data)
            root.left = insert(root.left,data);
        else
            root.right = insert(root.right,data);

        return root;
    }

    public static boolean search(Node root,int data){
        if(root==null)
            return false;
        if(root.data==data)
            return true;
        if(data<root.data)
            return search(root.left,data);
        else
            return search(root.right,data);
    }

    public Node getMax(Node root){
        if(root==null)
            return null;
        if(root.right==null)
            return root;
        else return getMax(root.right);

    }
    ArrayList<Integer> list = new ArrayList<>();

    ArrayList<Integer> inOrder(Node root) {
        // code here
      if(root==null)
          return list;
      inOrder(root.left);
      list.add(root.data);
      inOrder(root.right);
        return list;
    }
    void inOrder2(Node root){
        if(root==null)
            return;
        inOrder2(root.left);
        System.out.println(root.data);
        inOrder2(root.right);

    }

     ArrayList<Integer> levelOrder(Node root) {
        // code here
         ArrayList<Integer> list = new ArrayList<>();
         Queue<Node> queue = new LinkedList<>();
         queue.add(root);

         while(!queue.isEmpty()){
             Node current = queue.poll();
             list.add(current.data);
             if(current.left!=null)
                 queue.add(current.left);
             if(current.right!=null)
                 queue.add(current.right);
         }
         return list;

    }

    //Why was I not able to solve this stupid
    public Node lca(Node root, int n1, int n2) {
        // code here.
        if(root==null)
            return null;
        if(n1==root.data||n2== root.data)
            return root;
        Node lca1 = lca(root.left,n1,n2);
        Node lca2 = lca(root.right, n1, n2);

        if(lca1!=null&&lca2!=null)
            return root;
        if(lca1!=null)
            return lca1;
        else
            return lca2;

    }
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        // Write your code here


        return null;

    }
    public int height(Node root){
        if(root==null)
            return  0;
        return 1+Math.max(height(root.left),height(root.right));
    }

    // TODO: 06/02/22
    // FIXME: 06/02/22
    public  ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        // code here.
        // TODO: 06/02/22
        ArrayList<Integer> list = new ArrayList<>();
        while(root!=null){
            if(root.left==null&&root.right==null)
                return list;
            if(root.left!=null)
                if(root.data>low) {
                    list.add(root.left.data);
                    root = root.left;
                }

            if(root.right!=null)
                if(root.right.data<high){
                    list.add(root.right.data);
                    root = root.right;
                }

        }
        return list;


    }
    private static ArrayList<Integer> common = new ArrayList<>();
    public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        //code here
        if(root1==null||root2==null)
            return null;
            if (root1.data == root2.data)
                common.add(root1.data);
            while (root1 != null) {

                if (search(root2, root1.data))
                    common.add(root1.data);

                root1 = root1.left;
                    root1 = root1.right;
            }
        return common;

    }
    public static void main(String[] args) {
        BinarySearchTree tree= new BinarySearchTree();
        root = new Node(0);
        Node root2 = new Node(15);
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.insert(root2,35);
        tree.insert(root,1);
        tree.insert(root,2);
        tree.insert(root,10);
        tree.insert(root,20);
        tree.insert(root,15);
        tree.insert(root,5);
        tree.insert(root,35);
        tree.inOrder2(root);
        System.out.println(search(root,4));
        System.out.println(findCommon(root,root2));
        System.out.println(tree.levelOrder(root));
        System.out.println(tree.lca(root,5,15).data);
        System.out.println(tree.printNearNodes(root,6,26));
        System.out.println(tree.height(root));

    }
}
class MaximalPairs{

    public static long solve(List<Integer> arr) {
        // Write your code here

        if(arr==null)
            return 0;
        else if(arr.size()==1)
            return 0;
        else if(arr.size()==2)
            return 1;
        else{
            long count = 0;



            return count;
        }

    }

}

public class ProblemsOnBinarySearchTrees {

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null)
            root = new Node(data);
        else if(root.data>data)
            root.left = insert(root.left,data);
        else
            root.right = insert(root.right,data);

          return root;
    }


    public static void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root){
        if(root==null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(0);

        insert(root,1);
        insert(root,2);
        insert(root, 5);
        insert(root, 4);
        insert(root, 3);
        inOrder(root);
        System.out.println();
        preOrder(root);
    }
}
