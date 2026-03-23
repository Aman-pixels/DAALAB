import java.util.*;

public class Stable {

    static boolean prefers(int[][] womenPref,int w,int m,int m1,int n){
        for(int i=0;i<n;i++){
            if(womenPref[w][i]==m) return true;
            if(womenPref[w][i]==m1) return false;
        }
        return false;
    }

    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of men/women:");
        int n=sc.nextInt();

        int menPref[][]=new int[n][n];
        int womenPref[][]=new int[n][n];

        System.out.println("Enter men's preference list:");

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                menPref[i][j]=sc.nextInt();

        System.out.println("Enter women's preference list:");

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                womenPref[i][j]=sc.nextInt();

        int womenPartner[]=new int[n];
        boolean menFree[]=new boolean[n];
        int next[]=new int[n];

        Arrays.fill(womenPartner,-1);

        int freeCount=n;

        long start=System.nanoTime();

        while(freeCount>0){

            int m;
            for(m=0;m<n;m++)
                if(!menFree[m])
                    break;

            int w=menPref[m][next[m]];
            next[m]++;

            if(womenPartner[w]==-1){
                womenPartner[w]=m;
                menFree[m]=true;
                freeCount--;
            }

            else{
                int m1=womenPartner[w];

                if(prefers(womenPref,w,m,m1,n)){
                    womenPartner[w]=m;
                    menFree[m]=true;
                    menFree[m1]=false;
                }
            }
        }

        long end=System.nanoTime();

        System.out.println("Stable Matching:");

        for(int i=0;i<n;i++)
            System.out.println("Man "+womenPartner[i]+" - Woman "+i);

        System.out.println("Execution Time: "+(end-start)+" ns");
    }
}