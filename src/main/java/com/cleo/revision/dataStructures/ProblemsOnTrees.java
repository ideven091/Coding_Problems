package com.cleo.revision.dataStructures;


import java.util.*;

class BinaryTree{

  private static   class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }

    }


    public static void preOrderTraversal(Node root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static Node insert(Node root,int data){
        if(root == null){
            root = new Node(data);
            root.left = null;
            root.right = null;
            return root;
        }
        else if(root.data>data){
            //Node current = root;

                if(root.left!=null){
                    root.left = insert(root.left,data);
                }else{
                    root.left = new Node(data);
                 //   root = root.left;
                    return root;
                }
            }else if(root.data<data){
                if(root.right!=null){
                    root.right = insert(root.right,data);

                }else{
                    root.right = new Node(data);
                 //   root = root.right;
                    return root;
                }
            }
        return root;
        }
    static boolean isIdentical(Node root1, Node root2) {
        // C
        if(root1==null&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;
        if(root1.data!= root2.data)
            return false;

        if(!isIdentical(root1.left,root2.left)||!isIdentical(root1.right,root2.right))
            return false;
        return true;
    }

    // FIXME: 30/01/22
    public static void topView(Node root) {

      if(root==null)
          return;
      else{
          while(root!=null) {
              if(root.left==null||root.right==null){
                  System.out.print(root.data + " ");

              }
              System.out.print(root.data + " ");

              if (root.right!=null) {
                  root = root.right;
              }
                  root = root.left;
//                  System.out.println(root.data + " ");

          }
      }


    }

    public static void levelOrder(Node root) {
      if(root==null)
          return;
      boolean flag = false;
        System.out.print(root.data + " ");
        while(root!=null){
            if(root.left==null && root.right==null)
                break;

            if(root.left!=null) {
                System.out.print(root.left.data + " ");
                flag = true;
            }
            if(root.right!=null)
                System.out.print(root.right.data + " ");
            if(flag)
                root = root.left;
            else
                root = root.right;

        }


    }

    public static void levelOrderV2(Node root){
      if(root==null)
          return;
      else{
          System.out.print(root.data + " ");
          if(root.left!=null&&root.right!=null)
          if(depth(root.left,root.left.data)==depth(root.right,root.right.data))
              System.out.print(root.left.data + " " + root.right.data);
          levelOrderV2(root.left);
          levelOrderV2(root.right);
      }
    }

    public static void levelOrderV3(Node root){
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
    }

    public static int depth(Node root, int val){
      if(root==null)
          return 0;
      if(val > root.data)
          return 1 + depth(root.right, val);
      else if(val == root.data)
          return 1;
      else
          return 1+ depth(root.left, val);

    }

    public static void minDepthAncestor(Node root,int depth){
      while(depth(root,root.data)<depth){

      }
    }
    /**
     *
     * @param root Root of the tree
     * @param v1 Node 1
     * @param v2 Node 2
     * @return Least Common Ancestor of v1 and v2
     */
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        if(root==null)
            return null;
        boolean flag1 = false, flag2=false;
        if(root.data<v1)
            flag1 = true;
        if(root.data<v2)
            flag2=true;

        int n1 = depth(root,v1);
        int n2 = depth(root, v2);
        int min = Math.min(n1,n2);

      //  System.out.println(min);
        while(depth(root,root.data)!=min){
          //  System.out.println(depth(root, root.data));

            if(root.left==null||root.right==null)

                return root;
            if(!flag1)
                root = root.right;
            else
                root = root.left;
        }
        return root;

    }

    public static void inOrder(Node root){
        if(root == null)
            return;
        if(root.left!=null)
            inOrder(root.left);
        System.out.print(root.data + " ");
        if(root.right!=null)
            inOrder(root.right);
    }
    public static void preOrder(Node root){
        if(root==null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node root2 = new Node(1);
        insert(root,1);
        insert(root,2);
        insert(root,5);
        insert(root,6);
        insert(root, 3);
        insert(root, 4);
        insert(root2,2);
        insert(root2,3);
        topView(root2);
        System.out.println();
        topView(root);
        Node answer = lca(root,5,6);
        System.out.println(answer.data);
        System.out.println("Is identical?");
        System.out.println(isIdentical(root,root2));
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        System.out.println("Depth of 6:" + depth(root,6));
        System.out.println();
        System.out.println("Printing top view");
        topView(root);
        System.out.println();
        System.out.println("Level Order Traversal");
        levelOrderV2(root);
        System.out.println();
        System.out.println("Level Order Traversal via queue ");
        levelOrderV3(root);


        preOrderTraversal(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
     }
}

class HuffmanEncoding {

    private static abstract class Node implements Comparable<Node> {
        public int frequency;
        public char data;
        public Node left, right;

        public Node(int frequency) {
            this.frequency = frequency;
        }

        public int compareTo(Node tree) {
            return frequency - tree.frequency;
        }
    }

    private static class HuffmanLeaf extends Node {
        public HuffmanLeaf(int freq, char val) {
            super(freq);
            data = val;
        }

    }

    private static class HuffmanNode extends Node {
        public HuffmanNode(Node l, Node r) {
            super(l.frequency + r.frequency);
            left = l;
            right = r;
        }
    }
    //First we need to find the characters with the least frequency

    private static class Decoding {

        void decode(String s, Node root) {
            StringBuffer result = new StringBuffer();
            while(root!=null){
                int freq = root.frequency;
                if(freq==0) {
                    if(root.left==null && root.right==null){

                    }
                    root = root.left;
                }else if(freq==1){
                        root = root.right;
                        result.append(root.data);

                }


            }

        }

        void decodeV2(String s, Node root){
            StringBuffer decodedString= new StringBuffer();
            while(root!=null){
                StringBuffer s1 = new StringBuffer();
                if(root.frequency==1) {
                    decodedString.append(root.data);
                }
                else if(root.frequency==0)
                    s1.append(root.frequency);
            }
        }
    }

    public static Map<Character, String> mapA = new HashMap<Character, String>();
    public static Node buildTree(int[] charFreqs) {

        PriorityQueue<Node> trees = new PriorityQueue<Node>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));

        assert trees.size() > 0;

        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            Node a = trees.poll();
            Node b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }

        return trees.poll();
    }
    public static void printCodes(Node tree, StringBuffer prefix) {

        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data, prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String test = input.next();

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        Node tree = buildTree(charFreqs);


        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(mapA.get(c));
        }

        //System.out.println(s);
        Decoding d = new Decoding();
      //  d.decode(s.toString(), tree);

    }
}




public class ProblemsOnTrees {


}

//Not a binary tree
/*
class KittyCalculationOnTrees{

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node insert(Node root, int data){
        if(root==null)
            root = new Node(data);
        if(data<root.data)
            root.left = insert(root.left,data);
        else
            root.right = insert(root.right,data);
        return root;
    }

    public Node lca(Node root, int v1, int v2){
        if(root==null)
            return null;
        if(root.data==v1||root.data==v2)
            return root;
        Node lca1 = lca(root.left,v1,v2);
        Node lca2 = lca(root.right,v1,v2);
        if(lca1!=null&&lca2!=null)
            return root;
        if(lca1!=null)
            return lca1;
        else
            return lca2;
    }

    // Calculate the horizontal distance between nodes starting from lca


    public int distance(Node root, int v1, int v2){
        Node leastCommonAncestor = lca(root,v1,v2);


    }
    public int queryResult(int[] nodes){

    }

}

 */