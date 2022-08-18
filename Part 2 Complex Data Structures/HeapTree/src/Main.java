import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] arr = {5,3,8,4,1,12,13};
        MinHeap mh = new MinHeap();
        mh.insert(5,"a");
        mh.insert(3,"b");
        mh.insert(8,"c");
        mh.insert(4,"d");
        mh.insert(1,"e");
        mh.insert(12,"f");
        mh.insert(13,"g");
        System.out.println(mh.remove());
        System.out.println(mh.remove());
        System.out.println();
//        MaxHeap.heapify(arr);
//        System.out.println(Arrays.toString(arr));
//        Heap h = new Heap();
//        boolean f = h.isMaxHeap(arr);
//        System.out.println(f);
//        arr = h.heapify(arr);
//        System.out.println(Arrays.toString(arr));
//        int[] arr = {20,14,2,24,54,21,1,43};
//        Heap heap = new Heap(new int[]{5,6,8,7});
//        for (int i : arr){
//            heap.insert(i);
//        }
//        for (int i = arr.length-1; i>=0; i--){
//            arr[i] = heap.remove();
//        }
//        System.out.println(Arrays.toString(arr));

//        heap.insert(15);
//        heap.insert(10);
//        heap.insert(3);
//        heap.insert(8);
//        heap.insert(12);
//        heap.insert(9);
//        heap.insert(4);
//        heap.insert(1);
//        heap.insert(24);
//        System.out.println(heap.remove());
//        System.out.println(heap);
    }
}
