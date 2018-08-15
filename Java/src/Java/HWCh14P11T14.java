package Java;

public class HWCh14P11T14 {

    //5 if the element desired first in the array

    //11a True (20 * 19)/2

    //11b False, if already sorted O(n * log n) < O(n^2)

    //12 6,9,22,10,74,81

    //13 0,2,3,5,7,8,1,9,4,3

    //14
    public static void descending_inesertion(int arr[])
    {
        for(int n = arr.length-1; n>0; n--)
        {
            int temp = arr[n];
            int i =n;
            while(i<arr.length-1 && temp > arr[i+1])
            {
                arr[i] = arr[i + 1];
                i++;
            }
            arr[i] = temp;
        }
    }
    public static void selection_sort(int arr[])
    {
        for(int n = 0; n<arr.length-1;n++)
        {
            int min = n;
            for(int j=n+1; j<arr.length-1;j++)
            {
                if(arr[n]>arr[j])
                    min = j;
            }
            int temp = arr[n];
            arr[n]= arr[min];
            arr[min] = temp;
        }
    }
    public static void main(String args[])
    {
        int arr[] = {5,8,10,56,11,34};
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        selection_sort(arr);
        for(int i=0;i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }
}
