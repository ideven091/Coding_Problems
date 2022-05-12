package com.cleo.dataStructures.tries;

public class Tries {

    private TrieNode root = new TrieNode();

    private static class TrieNode{
        private TrieNode[] child= new TrieNode[26];
        boolean isEnd;
    }

    public boolean search(String word){
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i)-'a';
            if(curr.child[index]==null)
                return false;
            curr = curr.child[index];
        }
        return true;
    }

}
