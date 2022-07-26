package com.interview.tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * Test cases
 * All left children
 * All right children
 * Full tree
 * Complete tree
 */
public class BoundaryTraversal {

    ArrayList<Integer> boundary = new ArrayList<>();
    public void traversal(Node root){
        //find starting point for right side
        Node current = root;
        while(current != null){
            if(current.right != null && current.left != null){
                current = current.left;
                break;
            }
            current = current.left != null ? current.left : current.right;
        }
        addRightSide(current);
        addLeaves(root);
        addLeftSide(root);
    }
    
    private void addRightSide(Node root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
       boundary.add(root.data);
        if(root.right != null){
            addRightSide(root.right);
        }else{
            addRightSide(root.left);
        }
    }
    
    private void addLeftSide(Node root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        if(root.left != null){
            addLeftSide(root.left);
        }else{
            addRightSide(root.right);
        }
       boundary.add(root.data);
    }

    private void addLeaves(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            boundary.add(root.data);
        }
        addLeaves(root.right);
        addLeaves(root.left);
    }
    
    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(100, head);
        head = bt.addNode(90, head);
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(25, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(-7, head);
        BoundaryTraversal bd = new BoundaryTraversal();
        bd.traversal(head);

        System.out.println(bd.boundary);
    }
}
