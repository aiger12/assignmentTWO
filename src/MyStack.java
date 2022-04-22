public class MyStack<T extends Comparable<T>> {
    MyArrayList<T> array= new MyArrayList<T>();

    public boolean empty() {
        if(array.size()==0) return true;
        else return false;
    }

    public int size() {
        return array.size();
    }

    public T peek() {
        return array.get(array.size()-1);
    }

    public T push(T item) {
        array.add(item);
        return item;
    }

    public T pop() {
        return array.remove(array.size()-1);
    }
}
