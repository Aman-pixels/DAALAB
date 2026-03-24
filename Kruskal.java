import java.util.*;

class Edge implements Comparable<Edge>{
    int src,dest,weight;

    public int compareTo(Edge e){
        return this.weight - e.weight;
    }
}

public class Kruskal{

    static int find(int parent[],int i){
        if(parent[i]==i)
            return i;
        return find(parent,parent[i]);
    }

    static void union(int parent[],int x,int y){
        int xset=find(parent,x);
        int yset=find(parent,y);
        parent[xset]=yset;
    }

    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int v=sc.nextInt();

        System.out.println("Enter number of edges:");
        int e=sc.nextInt();

        Edge edges[]=new Edge[e];

        for(int i=0;i<e;i++)
            edges[i]=new Edge();

        System.out.println("Enter edges (src dest weight):");

        for(int i=0;i<e;i++){
            edges[i].src=sc.nextInt();
            edges[i].dest=sc.nextInt();
            edges[i].weight=sc.nextInt();
        }

        Arrays.sort(edges);

        int parent[]=new int[v];

        for(int i=0;i<v;i++)
            parent[i]=i;

        long start=System.nanoTime();

        int count=0;
        int i=0;
        int cost=0;

        while(count<v-1){

            Edge next=edges[i++];

            int x=find(parent,next.src);
            int y=find(parent,next.dest);

            if(x!=y){
                System.out.println(next.src+" - "+next.dest+" : "+next.weight);
                cost+=next.weight;
                union(parent,x,y);
                count++;
            }
        }

        long end=System.nanoTime();

        System.out.println("Minimum Cost: "+cost);
        System.out.println("Execution Time: "+(end-start)+" ns");
    }
}