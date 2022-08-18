public class MinPriorityQueue {
    private MinHeap mh = new MinHeap();
    public void add(String val, int priority){
        mh.insert(priority, val);
    }
    public String remove(){
        return mh.remove();
    }
    public boolean isEmpty(){
        return mh.isEmpty();
    }
}
