package com.cleo.revision.dataStructures;

import java.util.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class AdjListNode
{
    private int v;
    private int weight;
    AdjListNode(int _v, int _w) { v = _v; weight = _w; }
    int getV() { return v; }
    int getWeight() { return weight; }
}

class Graph
{
    private int V;
    private LinkedList<AdjListNode> adj[];
    Graph(int v)
    {
        V=v;
        adj = new LinkedList[V];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<AdjListNode>();
    }
    void addEdge(int u, int v, int weight)
    {
        AdjListNode node = new AdjListNode(v,weight);
        adj[u].add(node);
    }

    void topologicalSortUtil(int v, Boolean visited[], Stack stack)
    {

        visited[v] = true;
        Integer i;

        Iterator<AdjListNode> it = adj[v].iterator();
        while (it.hasNext())
        {
            AdjListNode node =it.next();
            if (!visited[node.getV()])
                topologicalSortUtil(node.getV(), visited, stack);
        }

        stack.add(v);
    }

    /**
     *Djiskstra Algorithm
     */
    void shortestPath(int s)
    {
        Stack stack = new Stack();
        int dist[] = new int[V];

        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        while (stack.empty() == false)
        {
            int u = (int)stack.pop();

            Iterator<AdjListNode> it;
            if (dist[u] != Integer.MAX_VALUE)
            {
                it = adj[u].iterator();
                while (it.hasNext())
                {
                    AdjListNode i= it.next();
                    if (dist[i.getV()] > dist[u] + i.getWeight())
                        dist[i.getV()] = dist[u] + i.getWeight();
                }
            }
        }

        for (int i = 0; i < V; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }
    }
}

class Main {
    public static void main(String args[])
    {

        Graph g = new Graph(6);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 5, 4);
        g.addEdge(2, 3, 6);
        g.addEdge(5, 3, 1);

        int s = 0;
        System.out.println("Following are shortest distances "+
                "from source " + s );
        g.shortestPath(s);
    }
}

public class DirectedGraphs {

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, boolean[] recursionStack){
        visited[i] =true;
        recursionStack[i]=true;

        for(int u:adj.get(i)){
            if(!visited[u]&&DFSRec(adj,u,visited,recursionStack)) {
              //  Stream.of(visited).forEach(System.out::println);
               // System.out.println(List.of(recursionStack));
                //System.out.println("Hi1");
                return true;
            }
            else if(recursionStack[u]) {
                //System.out.println(List.of(recursionStack));
                //System.out.println("Hi2");
                return true;
            }
        }
        recursionStack[i]=false;
     //   System.out.println("Hi3");
        return false;
    }

    // TODO: 21/02/22
    public boolean is_Possible(int[][] grid) {
        // Code here
        int V = grid[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length-1; j++) {
                addEdge(adj,grid[i][j],grid[i][j+1]);
            }
        }
        boolean[] recursionStack = new boolean[V];
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                if(DFSRec(adj,i,visited,recursionStack))
                    return true;
            }

        }
        return false;
    }

    /**
     * Kahn's Algorithm for Sorting a Directed Acyclic Graph
     */
    static int[] topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] in_degree = new int[V];
        int[] result = new int[V];
        for (int u = 0; u < V; u++) {
            for (int x:adj.get(u))
                in_degree[x]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (in_degree[i] == 0)
                q.add(i);

        int i=0;
        while (q.isEmpty()==false) {
            int u = q.poll();
            result[i++]=u;

            for (int x: adj.get(u))
                if (--in_degree[x] == 0)
                    q.add(x);
        }
        return result;
    }

    /**
     * Modification of Kahn's Algorithm of Topological Sorting a DAG to
     * detecting a cycle in a directed graph
     */
    static boolean detectCycleV2(ArrayList<ArrayList<Integer>> adj, int V){
        int[] in_degree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int x:adj.get(u))
                in_degree[x]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(in_degree[i]==0)
                queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int x:adj.get(u)){
                if(--in_degree[x]==0)
                    queue.add(x);
                count++;
            }
        }
        return count==V;
    }

    static void shortestPath(ArrayList<ArrayList<Integer>> adj, int V, List<Integer> weights){
        int[] vertices = topologicalSort(adj,V);


    }

    /**
     * Prim's Algorithm for finding the minimum weight so that all edges are connected
     * in the graph
     */
    int minimumSpanningTree(int[][] graph, int V){
        boolean[] mSet = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key,Integer.MAX_VALUE);
        int sum = 0;
        key[0]=0;
        for (int count = 0; count < V; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!mSet[i] && (u==-1|| key[i] < key[u]))
                    u = i;
            }
            mSet[u]=true;
            sum+=key[u];
            for (int v = 0; v < V; v++) {
                if(!mSet[v]&&graph[u][v]!=0&&graph[u][v]<key[u])
                    key[v]=graph[u][v];
            }
            }
        return sum;
        }


    int DFS(int V, ArrayList<ArrayList<Integer>> adj, int s, int X){
        boolean[] visited=  new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s]=true;
        queue.add(s);
         int level=0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            if(u==X)
                return level-1;



            visited[u]=true;
            for(int a:adj.get(u)){
                if(!visited[a]) {
                    visited[a] = true;
                    queue.add(a);
                    level++;

                }

            }

        }
        return -1;
    }
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        if(X==0)
            return 0;
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                return DFS(V, adj,i,X);
            }
            visited[i]=true;

        }

            return -1;
    }

    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];

        boolean[] recursionStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                if(DFSRec(adj,i,visited,recursionStack))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DirectedGraphs dg = new DirectedGraphs();
        var adj = new ArrayList<ArrayList<Integer>>();
        int V = 4;
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        dg.addEdge(adj,0,1);
        dg.addEdge(adj,0,2);
     //  dg.addEdge(adj,1,2);
        dg.addEdge(adj,2,3);
        System.out.println(detectCycleV2(adj,V));
        topologicalSort(adj,V);
        int[] result = topologicalSort(adj,V);
        for(int c: result){
            System.out.print(c+ " ");
        }
        System.out.println();
        System.out.println(dg.nodeLevel(V,adj,1));
    }
}
