import java.util.*;

public class Main {

    static int partition(int arr[], int low, int high){
        int pivot=arr[high];
        int i=low-1;

        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

    static void quickSort(int arr[],int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n=sc.nextInt();

        int arr[]=new int[n];

        System.out.println("Enter elements:");

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        long start=System.nanoTime();

        quickSort(arr,0,n-1);

        long end=System.nanoTime();

        System.out.println("Sorted elements:");

        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");

        System.out.println();
        System.out.println("Execution Time: "+(end-start)+" ns");
    }
}