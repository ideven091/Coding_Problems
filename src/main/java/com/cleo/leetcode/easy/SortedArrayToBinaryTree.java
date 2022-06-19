package com.cleo.leetcode.easy;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }
}

public class SortedArrayToBinaryTree {

    public TreeNode insert(TreeNode root, int val){
        if(root==null)
            root = new TreeNode(val);
        else if(val < root.val)
            root.left=insert(root.left,val);
        else
            root.right=insert(root.right,val);
        return root;
    }



    public TreeNode sortedArrayToBST(int[] nums) {

        int n = nums.length;
        if(n==1)
            return new TreeNode(nums[0]);
        int mid =n/2;
        TreeNode root = new TreeNode(nums[mid]);
        int j = mid+1;
        for (int i = 0; i < n; i++) {
            if(i==mid)
                continue;
            root=insert(root,nums[i]);
        }

        return root;

    }
    public TreeNode sortedArrayToBSTV2(int[] nums) {
        int midl = nums.length/2;
        int left = midl-1;
        int right = midl+1;
        TreeNode root = new TreeNode(nums[midl]);
        root.left = fill(0, left, nums);
        root.right = fill(right, nums.length-1, nums);
        return root;
    }

    private TreeNode fill(int low , int high, int[] nums) {
        if(low > high) return null;
        int mid = (low+high)/2;


        TreeNode node = new TreeNode(nums[mid]);

        node.left = fill(low, mid-1, nums);
        node.right = fill(mid+1, high, nums);

        return node;
    }
    public TreeNode sortedArrayToBSTV3
            (int[] nums) {
        if(nums.length == 0) return null;

        return binarySearch(nums, 0, nums.length-1, null);

    }

    public static TreeNode binarySearch(int[] nums, int low, int high, TreeNode root){
        if(low > high) return root;

        int mid = low + (high - low)/2;
        root = new TreeNode(nums[mid]);

        root.left = binarySearch(nums,low, mid-1, root.left);
        root.right = binarySearch(nums, mid+1, high, root.right);

        return root;
    }

    public void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.val + ",");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        else
            return 1+Math.max(height(root.left),height(root.right));
    }

    // TODO: 20/06/22  
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return Math.abs(height(root.left)-height(root.right))<=1;

    }
    public void levelOrderTraversal(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current= queue.poll();
            System.out.print(current.val + " ");
            if(current.left!=null)
                queue.add(current.left);
            if(current.right!=null)
                queue.add(current.right);
        }

    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        int[] nums1 = {0,1,2,3,4,5};
        SortedArrayToBinaryTree sbt = new SortedArrayToBinaryTree();
        TreeNode root = sbt.sortedArrayToBSTV2(nums);
        sbt.preOrder(root);
        System.out.println();

        System.out.println(sbt.height(root));
        System.out.println();
        sbt.levelOrderTraversal(root);
        SortedArrayToBinaryTree sbt1 = new SortedArrayToBinaryTree();
        TreeNode root1 = sbt1.sortedArrayToBSTV2(nums1);
        System.out.println();
        sbt1.preOrder(root1);
        System.out.println();
        sbt1.inOrder(root1);
        System.out.println();
        sbt.levelOrderTraversal(root1);
        System.out.println();
        System.out.println(sbt.height(root1));
        System.out.println(sbt.isBalanced(root));
        SortedArrayToBinaryTree sbt2 = new SortedArrayToBinaryTree();
        TreeNode root2= new TreeNode(nums[0]);
        for(int c:nums1){
            root2=sbt2.insert(root2,c);
        }
        System.out.println(sbt2.isBalanced(root2));
    }
}
