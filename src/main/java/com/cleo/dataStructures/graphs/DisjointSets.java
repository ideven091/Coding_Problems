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

class QuickFind{
    private final int[] root;
    
    public QuickFind(int size){
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i]=i;
        }
    }
    public int find(int element){
        if(element == root[element])
            return element;
        else 
            return root[element]=find(root[element]);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY)
            root[rootX]=rootY;
        
    }
    public boolean connected(int x, int y){
        return find(x)==find(y);
    }
}
class UnionFindByRank{

    private final int[] root;
    private int[] rank;

    public UnionFindByRank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i]=i;
            rank[i]=1;
        }
    }

    public int find(int element){
        if(element==root[element])
            return element;
        return root[element]=find(root[element]);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rank[rootX]>rank[rootY])
            root[rootY]=rootX;
        else if(rank[rootX]<rank[rootY])
            root[rootX]=rootY;
        else{
            root[rootX]=rootY;
            rank[rootX]+=1;
        }
    }
    public boolean connected(int x, int y){
        return find(x)==find(y);
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
        
        QuickFind qf = new QuickFind(n);
        qf.union(0,1);
        qf.union(0,2);
        qf.union(1,3);
        qf.union(4,8);
        qf.union(5,6);
        qf.union(5,7);
        System.out.println(qf.connected(0,3));
        
        UnionFindByRank unionFindByRank = new UnionFindByRank(n);
        unionFindByRank.union(0,1);
        unionFindByRank.union(0,2);
        unionFindByRank.union(1,3);
        unionFindByRank.union(4,8);
        unionFindByRank.union(5,6);
        unionFindByRank.union(5,7);
        System.out.println(qf.connected(0,3));


    }
}
