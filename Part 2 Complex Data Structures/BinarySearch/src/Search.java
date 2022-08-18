import java.util.Arrays;

public class Search {
    static int binarySearch(int[] arr, int target){
        Arrays.sort(arr);
        return binarySearch(arr, target, 0, arr.length-1);
    }
    private static int binarySearch(int[] arr, int target, int left, int right){
        if (right < left)
            return -1;

        int middle = (left+right)/2;
        if (arr[middle] == target){
            return middle;
        }
        if(target > arr[middle]){
            return binarySearch(arr, target, middle+1, right);
        }

        return binarySearch(arr, target, left, middle-1);
    }

    static int bs(int[] arr, int target){
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int middle = (left + right)/2;
            if(target == arr[middle]){
                return middle;
            }
            if(target > arr[middle]){
                left = middle+1;
            }
            if(target < arr[middle]){
                right = middle-1;
            }
        }
        return -1;
    }

    static int ternarySearch(int[] arr, int target){
        Arrays.sort(arr);
        return ternarySearch(arr, target, 0, arr.length-1);
    }
    private static int ternarySearch(int[] arr, int target, int left, int right){
        if(left > right){
            return -1;
        }
        int partitionSize = (right - left)/3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;
        if (target == arr[mid1])
            return mid1;
        if (target == arr[mid2])
            return mid2;
        if(target<arr[mid1]){
            return ternarySearch(arr, target, left, mid1-1);
        }
        if (target > arr[mid2])
            return ternarySearch(arr, target, mid2+1, right);

        return ternarySearch(arr, target, mid1+1, mid2-1);
    }

}
