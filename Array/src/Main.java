public class Main {
    public static void main(String[] args){
        Array arr = new Array(4);
        arr.insert(20);
        arr.insert(3);
//        arr.insert(50);
//        arr.insert(54);
//        arr.insert(2);
//        arr.insert(234);
        arr.print();
        arr.insertAt(990, 2);
//        System.out.println(arr.max());
//        Array intersectedArray = arr.intersect(new int[]{22, 12, 56, 78});
//        intersectedArray.print();
//        arr.remove(3);
//        System.out.println( arr.indexOf(20));
        arr.print();
        arr.reverse();
        arr.print();
    }
}
