public class MyLinkedList<T extends Comparable<T>> implements MyList<T>{
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {}

    public int size() {
        return length;
    }

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public boolean contains(Object o) {
        for(MyNode<T> i = head; i!=null; i=i.next){
            if(o.equals(i)){
                return true;
            }
        }
        return false;
    }

    public boolean remove(T item) {
        if(head==null)return false;
        for(MyNode<T> i = head; i.next!=null; i=i.next){
            if(item.equals(i.data)){
                i.prev.next=i.next;
                return true;
            } else return false;
        }
        length--;
        return true;
    }



    public void clear() {
        for(MyNode<T> i = head; i.next!=null; i=i.next){
            remove(i.data);
        }
    }

    @Override
    public T remove(int index) {
        return null;
    }

    public void add(T item, int index){
        MyNode<T> newNode = new MyNode<>(item);
        MyNode<T> count;
        if (head == null) {
            head = tail = newNode;
        }else {
            for(MyNode<T> i = tail; i.prev!=null; i=i.prev) {
                i.prev=head;
                newNode.prev = tail;
                tail.next = newNode;
                newNode.next=head;
            }
        }

        length++;

    }


    public int indexOf(Object o) {
        int count=0;
        for(MyNode<T> i = head; i.next!=null; i=i.next){
            count++;
            if(o.equals(i.data)){
                return count;
            }
        }
        return count;
    }


    public int lastIndexOf(Object o) {
        int max=0;
        int k=0;
        for(MyNode<T> i = head; i.next!=null; i=i.next){
            max++;
            if(o.equals(i.data)){
                k=max;
            }
        }
        return k;
    }


    public void sort() {
        for(MyNode<T> i = head; i.next!=null; i=i.next){
            Object count;
            for(MyNode<T> j = head; j.next!=tail; j=j.next){
                T a=(T) i.data;
                T b=(T) j.next.data;
                if(a.compareTo(b)>0){
                    count=i.data;
                    i.data=i.next.data;
                    i.next.data=(T)count;
                }
            }
        }
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }


}