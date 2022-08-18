public class MaxHeap {
    public static void heapify(int[] arr){
        for (int i= arr.length/2-1; i>=0; i--){
            heapify(arr, i);
        }
    }

    private static void heapify(int[] arr, int index){
        int largerChildIndex = index;

        int leftChildIndex= index * 2 + 1;
        if (leftChildIndex < arr.length &&
            arr[leftChildIndex] > arr[largerChildIndex]){
           largerChildIndex = leftChildIndex;
        }

        int rightChildIndex = index * 2 + 2;
        if (rightChildIndex < arr.length &&
            arr[rightChildIndex] > arr[largerChildIndex]){
           largerChildIndex = rightChildIndex;
        }
        if (index == largerChildIndex)
            return;
        swap(arr, index, largerChildIndex);
        heapify(arr,largerChildIndex);
    }
    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
