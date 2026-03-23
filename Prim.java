import java.util.*;

public class Prim {

    static int minKey(int key[], boolean mst[], int n){
        int min=Integer.MAX_VALUE,index=-1;

        for(int i=0;i<n;i++){
            if(!mst[i] && key[i]<min){
                min=key[i];
                index=i;
            }
        }
        return index;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int n=sc.nextInt();

        int graph[][]=new int[n][n];

        System.out.println("Enter adjacency matrix:");

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                graph[i][j]=sc.nextInt();

        int parent[]=new int[n];
        int key[]=new int[n];
        boolean mst[]=new boolean[n];

        for(int i=0;i<n;i++)
            key[i]=Integer.MAX_VALUE;

        key[0]=0;
        parent[0]=-1;

        long start=System.nanoTime();

        for(int count=0;count<n-1;count++){

            int u=minKey(key,mst,n);
            mst[u]=true;

            for(int v=0;v<n;v++){
                if(graph[u][v]!=0 && !mst[v] && graph[u][v]<key[v]){
                    parent[v]=u;
                    key[v]=graph[u][v];
                }
            }
        }

        long end=System.nanoTime();

        int cost=0;

        System.out.println("Edges in MST:");

        for(int i=1;i<n;i++){
            System.out.println(parent[i]+" - "+i+" : "+graph[i][parent[i]]);
            cost+=graph[i][parent[i]];
        }

        System.out.println("Minimum Cost: "+cost);
        System.out.println("Execution Time: "+(end-start)+" ns");
    }
}