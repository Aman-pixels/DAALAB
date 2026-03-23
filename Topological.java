import java.util.*;

public class Topological {

    static void topo(int v,boolean visited[],Stack<Integer> stack,ArrayList<ArrayList<Integer>> adj){
        visited[v]=true;

        for(int i:adj.get(v))
            if(!visited[i])
                topo(i,visited,stack,adj);

        stack.push(v);
    }

    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int n=sc.nextInt();

        System.out.println("Enter number of edges:");
        int e=sc.nextInt();

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v):");

        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
        }

        boolean visited[]=new boolean[n];
        Stack<Integer> stack=new Stack<>();

        long start=System.nanoTime();

        for(int i=0;i<n;i++)
            if(!visited[i])
                topo(i,visited,stack,adj);

        long end=System.nanoTime();

        System.out.println("Topological Order:");

        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");

        System.out.println();
        System.out.println("Execution Time: "+(end-start)+" ns");
    }
}