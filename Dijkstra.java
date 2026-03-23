import java.util.*;

public class Dijkstra {

    static int minDistance(int dist[], boolean visited[], int n){
        int min=Integer.MAX_VALUE, index=-1;

        for(int i=0;i<n;i++){
            if(!visited[i] && dist[i]<=min){
                min=dist[i];
                index=i;
            }
        }
        return index;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int graph[][]=new int[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                graph[i][j]=sc.nextInt();

        int src=sc.nextInt();

        int dist[]=new int[n];
        boolean visited[]=new boolean[n];

        for(int i=0;i<n;i++)
            dist[i]=Integer.MAX_VALUE;

        dist[src]=0;

        long start=System.nanoTime();

        for(int count=0;count<n-1;count++){

            int u=minDistance(dist,visited,n);
            visited[u]=true;

            for(int v=0;v<n;v++){
                if(!visited[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE
                        && dist[u]+graph[u][v]<dist[v])
                    dist[v]=dist[u]+graph[u][v];
            }
        }

        long end=System.nanoTime();

        for(int i=0;i<n;i++)
            System.out.println(src+" -> "+i+" = "+dist[i]);

        System.out.println("Execution Time: "+(end-start)+" ns");
    }
}