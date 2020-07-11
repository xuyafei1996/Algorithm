package Array_OneDimensional;

public class ArrayInverse {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6};
        int result[] = Inverse(arr);
        for (int i=0;i<result.length;i++)
            System.out.print(result[i]+" ");
    }

    private static int[] Inverse(int[] arr) {
        int result[] = new int[arr.length];
        for (int start=0,end=arr.length-1;start<arr.length;start++,end--){
            result[end] = arr[start];
        }
        return result;
    }
}
