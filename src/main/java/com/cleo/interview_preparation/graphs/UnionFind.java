package com.cleo.interview_preparation.graphs;

public class UnionFind {
    private int[] root;
    private int[] rank;
    public void init(int size){
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i]=0;
            rank[i]=i;
        }


    }
    public int find(int x){
        if(root[x]==x)
            return x;
        else
            return root[root[x]]=find(root[x]);

    }

    public void union(int x, int y){
        int rootX = find(root[x]);
        int rootY = find(root[y]);

        if(rank[rootX]<rank[rootY]){
            root[rootY]=rootX;

        }else if(rank[rootX]>rank[rootY])
            root[rootX]=rootY;
        else{
            root[rootY]=rootX;
            rank[rootY]+=1;
        }


    }
    public boolean connected(int x, int y){
        return find(x)==find(y);
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        init(n);
        int W = edges.length;
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return connected(source,destination);

    }


    public static void main(String[] args) {
        int n = 3; int[][] edges = {{0,1},{1,2},{0,2}}; int source = 0; int destination = 2;
        int n1 = 6, source1 = 0, destination1 = 5; int[][] edges1 ={{0,1},{0,2},{3,5},{5,4},{4,3}};

        UnionFind uf = new UnionFind();
        System.out.println(uf.validPath(n,edges,source,destination));
        UnionFind uf1 = new UnionFind();
        System.out.println(uf1.validPath(n1,edges1,source1,destination1));


    }

}
