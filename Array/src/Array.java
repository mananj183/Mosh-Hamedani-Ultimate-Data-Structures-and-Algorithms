public class Array {
    private int size = 0;
    private int items[];
    public Array(int length) {
        items = new int[length];
    }
    public void insert(int item){
        // if array is full, resize
        if(size == items.length) {
            int[] tempArr = new int[size+1];
            for (int i=0; i< size; i++)
                tempArr[i] = items[i];
            items = tempArr;
        }
        items[size++] = item;
    }
    public int remove(int index){
        if (index<0 || index >=size)
            throw new IllegalArgumentException();
        else{
            int itemRemoved = items[index];
//            if(index == size-1){
//                items[--size] = 0;
//            }
//            else{
                for(int i = index; i<size-1; i++){
                    items[i] = items[i+1];
                }
                size--;
//            }
            return itemRemoved;
        }
    }
    public int indexOf(int item){
        for(int i=0; i< size; i++){
                if(items[i]==item)
                    return i;
        }
        return -1;
    }
    public int max(){
        int maxNum = items[0];
        for(int i=1; i<size; i++){
            if(items[i]>maxNum)
                maxNum = items[i];
        }
        return maxNum;
    }
    public Array intersect(int[] arr){
//        int[] intersectionArray = new int[size];
//        int intersectCount = 0;
        Array intersectionArray = new Array(size);
        for(int i=0; i<size; i++){
            for(int j=0; j<arr.length; j++){
                if(items[i]==arr[j]){
//                    intersectionArray[intersectCount++] = items[i];
                    intersectionArray.insert(items[i]);
                }
            }
        }
        return intersectionArray;
    }
    public void reverse(){
        int temp = 0;
        for(int i=0; i<size/2; i++){
            temp = items[i];
            items[i] = items[size-i-1];
            items[size-i-1] = temp;
        }
    }
    public void insertAt(int item, int index){
        if (index<0 || index>size)
            throw new IllegalArgumentException();
        if(size == items.length) {
            int[] tempArr = new int[size+1];
            for (int i=0; i< size; i++)
                tempArr[i] = items[i];
            items = tempArr;
        }
        for(int i=size-1; i>=index; i--){
            items[i+1] = items[i];
        }
        items[index] = item;
        size++;
    }
    public void print(){
        System.out.print("[");
        for(int i=0; i< size; i++){
            if(i!=size-1)
                System.out.print(items[i] + ", ");
            else
                System.out.println(items[i] + "]");
        }
    }
}
