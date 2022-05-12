package com.cleo.dataStructures.graphs;

class UnionFind{

    private int[] vertices;

    private int count;

    public int getCount(){
        return count;
    }

    public UnionFind(int N){
        vertices = new int[N];
        count=N;
        for (int i = 0; i < N; i++) {
            vertices[i]=i;
        }
    }

    public void union(int V1, int V2){

        int p1 = find(V1);
        int p2 = find(V2);
        if(p1 == p2)
            return;
        for (int i = 0; i < vertices.length; i++) {
            if(vertices[i]==p1)
                vertices[i]=p2;
        }
        count--;
    }

    public int find(int p){
        return vertices[p];

    }

    public boolean connected(int V1, int V2){
        return find(V1)==find(V2);

    }


}


class QuickUnionFind{

    private int[] root;

    public void init(int size){
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i]=i;
        }
    }

    public int find(int node1){
        if(root[node1]==node1)
            return node1;
        else
            return root[node1]=find(node1);
    }
    public void union(int node1, int node2){
        int rootNode1 = find(node1);
        int rootNode2= find(node2);
        if(rootNode1!=rootNode2){
            root[rootNode1]=rootNode2;
        }
    }
    public boolean connected(int V1, int V2){
        return find(V1)==find(V2);

    }

}
class UnionFindByRank{

    private int[] root;
    private int[] rank;

    public void init(int size){
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i]=i;
            rank[i]=1;
        }
    }
    public int find(int node1){
        if(root[node1]==node1)
            return node1;
        else
            return root[node1]=find(node1);
    }
    public void union(int node1, int node2) {
        int rootNode1 = find(node1);
        int rootNode2 = find(node2);
        if (rootNode1 != rootNode2) {
            if (rank[rootNode1] > rank[rootNode2])
                root[rootNode2] = rootNode1;
            else if (rank[rootNode1] < rank[rootNode2])
                root[rootNode1] = rootNode2;
            else {
                root[rootNode1] = rootNode2;
                rank[rootNode2] += 1;
            }
        }
    }
        public boolean connected ( int V1, int V2){
            return find(V1) == find(V2);

        }
    }


public class DisjointSets {

    public static void main(String[] args) {
        int n = 9;
        UnionFind uf = new UnionFind(n);
        uf.union(0,1);
        uf.union(0,2);
        uf.union(1,3);
        uf.union(4,8);
        uf.union(5,6);
        uf.union(5,7);
         System.out.println(uf.connected(0,3));
        System.out.println(uf.getCount() + " connected components" );


    }
}
