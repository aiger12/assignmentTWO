public interface MyList<T> {
    int size(); //+
    boolean contains(Object o); //+
    void add(T item);//+
    void add(T item, int index);
    boolean remove(T item); //+
    void clear();//+
    T remove(int index);
    T get(int index); //+
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}

