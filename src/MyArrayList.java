public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;
    public MyArrayList() {
        arr = new Object[capacity];
    }

    public int size() {
        return length;
    }

    public boolean contains(Object o) {
        for(int i=0;i<length;i++){
            if(arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    public void add(T item, int index) {
        if (length == capacity) // 9 1 5 4 2 0 0 0
            for(int i = length - 1; i >= 0; i--){
                arr[i + 1] = arr[i];
            }
        arr[index]=item;
        length++;
    }

    public boolean remove(T item){
        for (int i = 0; i < arr.length-1; i++) {
            if(item.equals(arr[i])) {
                arr[i] = arr[i + 1];
                return true;//0 1 2 3 4 5 6 7 8 9 => 0 1 3 4 5 6 7 8 9
            }
        }
        return true;
    }

    public T remove(int index) {
        for (int i = index; i < length-1; i++) {
            arr[i] = arr[i + 1];   //8 9 5 4 0 0 0 0
        }
        length--;
        return (T)arr[index];  //i can not return as-"return T(arr);"
    }

    public void clear() { //удаляем маасив
        for(int i=0;i< arr.length;i++){
            remove(i);
        }
    }
    public T get(int index) {
        return (T)arr[index];
    }

    public int indexOf(Object o) {
        int k=0;
        for(int i=0;i<length;i++){
            if(arr[i].equals(o)) {
                k=i;
            }
        }
        return k;
    }


    public int lastIndexOf(Object o) {  //Exception;
        int max=0;
        for(int i=0;i<length;i++){
            if(arr[i].equals(o)){
                max=i;
            }
        }
        return max;
    }

    public void sort() {
        for (int i = 0; i < length; i++) {  //8 4 2 3 4 0 0 0 0
            Object counter=0;
            for (int j = 0; j < length - 1; j++) {
                T a = (T) arr[j];
                T b = (T) arr[j + 1];
                if (a.compareTo(b) > 0) {
                    counter=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=counter;
                }
            }
        }
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }


}
