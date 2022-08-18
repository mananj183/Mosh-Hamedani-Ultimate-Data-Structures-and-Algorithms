import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] arr = {0, 2, 3, 5, 6, 7, 9, 12, 16, 20, 44};
//        int index = Search.binarySearch(arr, 90);
        int index = Search.bs(arr, 44);
        System.out.println(Arrays.toString(arr));
        System.out.println(index);
    }
}
