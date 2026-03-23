import java.util.*;

public class Stable {

    static boolean prefers(int[][] womenPref, int w, int m, int m1, int n){
        for(int i=0;i<n;i++){
            if(womenPref[w][i]==m) return true;
            if(womenPref[w][i]==m1) return false;
        }
        return false;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int menPref[][]=new int[n][n];
        int womenPref[][]=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char c=sc.next().charAt(0);
                menPref[i][j]=c-'W';
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char c=sc.next().charAt(0);
                womenPref[i][j]=c-'A';
            }
        }

        int womenPartner[]=new int[n];
        boolean menFree[]=new boolean[n];
        int next[]=new int[n];

        Arrays.fill(womenPartner,-1);

        int freeCount=n;

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

        for(int i=0;i<n;i++)
            System.out.println((char)(womenPartner[i]+'A')+" - "+(char)(i+'W'));
    }
}