package com.cleo.interview_preparation.sde_sheet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left,right;

    public TreeNode(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }
}

class BinaryTree{
    public TreeNode insert(TreeNode root, int data){
        if(root==null)
            root = new TreeNode(data);
        else if(data < root.val)
            root.left = insert(root.left,data);
        else
            root.right = insert(root.right,data);
        return root;
    }

    List<List<Integer>> levelOrdered = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return levelOrdered;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            temp = new ArrayList<>();
            if(current.left!=null&&current.right!=null){
                temp.add(current.left.val);
                temp.add(current.right.val);
                levelOrdered.add(temp);
                queue.add(current.left);
                queue.add(current.right);

            }


           else if(current.left!=null) {
                temp.add(current.left.val);
               levelOrdered.add(temp);
                 queue.add(current.left);
             }
           else if(current.right!=null) {
               temp.add(current.right.val);
              levelOrdered.add(temp);
                queue.add(current.right);
            }
        }
        return levelOrdered;


    }



}

public class TreeProblems {


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        tree.insert(root,4);
        tree.insert(root,5);
        tree.insert(root,3);
        tree.insert(root,11);
        tree.insert(root,15);
        System.out.println(tree.levelOrder(root));

    }
}
