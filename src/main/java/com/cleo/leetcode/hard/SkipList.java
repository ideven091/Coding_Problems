package com.cleo.leetcode.hard;

public class SkipList {

    private static class ListNode {
        int data;
        ListNode left;
        ListNode right;

        public ListNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private ListNode root;
    private int length;

    public SkipList() {

    }

    /**
     * Given a number in the skip list
     * @param target number to find
     * @return true or false in O(log(N)) time
     */

    public boolean search(int target) {


        // TODO: 04/02/22
        return false;
    }

    public void add(int num) {

        // TODO: 04/02/22
    }

    public boolean erase(int num) {

        // TODO: 04/02/22

        return false;
    }
}

