import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.addLast(10);
        l1.addLast(20);
        l1.addLast(30);
        l1.addLast(40);
        l1.addLast(50);
//        l1.addLast(60);
        l1.addLoop();
        System.out.println(l1.hasLoop());
//        l1.findMiddle();
//        System.out.println(l1.kthNodeFromEnd(9));
//        l1.reverseList();
//        int[] arr = l1.toArray();
//        System.out.println(Arrays.toString(arr));
    }
}
