package com.cleo.codeChef.medium;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LCA {

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int a, int b){
        adj.get(a).add(b);
        adj.get(b).add(a);
    }
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static class Tuple {
        int a;
        int b;

        public Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }


    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null)
            root = new Node(data);
        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }

    public static Node lca(Node root, int v1, int v2){
        if(root==null)
            return null;
        if(root.data==v1||root.data==v2)
            return root;
     Node lca1 = lca(root.left,v1,v2);
        Node lca2 = lca(root.right,v1,v2);
        if(lca1==null&&lca2==null)
            return root;
        if(lca1!=null)
            return lca1;
        else return lca2;

    }


    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(reader.readLine());
            Node root;
            List<Tuple> vertices = new ArrayList<>();
            while (N-- > 0) {
                String[] s = (reader.readLine().split(" "));
                vertices.add(new Tuple(Integer.parseInt(s[0]), Integer.parseInt(s[1])));



            }
            int Q = Integer.parseInt(reader.readLine());
            String[] s = (reader.readLine().split(" "));
            int root1 = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            root = new Node(root1);
            for(var x:vertices){
                insert(root,x.a);
                insert(root,x.b);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
