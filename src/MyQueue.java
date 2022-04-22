public class MyQueue<T extends Comparable<T>>{
    MyLinkedList<T>array=new MyLinkedList<>();
    public boolean empty() {
        if(array.size()==0) return true;
        else return false;
    }

    public int size() {
        return array.size();
    }

    public T peek() {
        return array.get(0);//
    }

    public T enqueue(T item) {
        array.add(item);
        return item;
    }

    public Object dequeue() {
        return array.remove(0);
    }
}
