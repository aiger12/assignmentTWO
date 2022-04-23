public class MyHeap<T extends Comparable<T>> {
    private T[] pq;
    private int capacity;
    private int pos=0;

    void add(T item) {
        pq[pos++] = item;
        minHeapify(++pos, pq);
    }

    T removeRoot() {
        int t=pq.length;
        T k= pq[t];
        pq[t]=pq[1];
        pq[1]=k;
        maxHeapify(pq,pq[1]);
        remove(pq[pq.length]); //method remove(T item)
        return (T)pq[1];
    }
    boolean remove(T item){
        for(int i=1;i<pq.length;i++){
            if(item.equals(pq[i])){
                pq[i]=pq[i+1];
                return true;
            }
        }
        return false;
    }

    private void minHeapify(int N, T[] pq) { //min item is root
        for(int i=N;i>0;i--){
            for(int j=i;j>1;j=j/2){
                if (pq[j/2].compareTo(pq[j])>0) {
                    T k=pq[j];
                    pq[j]=pq[j/2];
                    pq[j/2]=k;
                }
            }
        } //our array is sorted by minheapify(root is min item)
    }
    public T maxHeapify(T[] pq,T value) {//max item will be root
        if(pos==capacity){ return pq[pq.length];} else {
         pq[pos++]=value;
         T child=pq[pos-1];
         T parent=pq[(pos-1)/2];
         while(child.compareTo(parent)>0) {
             T tmp = pq[pos - 1];
             pq[pos - 1] = pq[(pos - 1) / 2];
             pq[(pos - 1) / 2] = tmp;

             child = parent;
             maxHeapify(pq, pq[pos++]); //here i use recursion
         }
         }
       return (T)pq[pq.length];

    }

    /*private void maxHeapify(int N,T[]pq){
        for(int i=1;i<pq.length;i++){
            for(int j=i;j<pq.length/2;j++){

                if(pq[j].compareTo(pq[2*j])>0){
                    T k=pq[j];
                    pq[j]=pq[j*2];
                    pq[j*2]=k;
                }if(pq[j].compareTo(pq[2*j+1])>0){

                }
            }
        }
    }*/
}