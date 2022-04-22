public class MyHeap<T extends Comparable<T>> {
    private T[] pq;
    private int N = 0; //length of an array

    void add(T item) {
        pq[N++] = item;
        minHeapify(N++, pq);
    }

    T removeRoot() {
        int t=pq.length;
        T k= pq[t];
        pq[t]=pq[1];
        pq[1]=k;
        maxHeapify(pq);
        return (T)pq[1];
    }

    boolean remove(T item) {
      return true;
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
    private void maxHeapify(T[] pq) { //max item will root
        for(int i= pq.length;i>0;i--){
            for(int j=i;j>1;j=j/2){
                if (pq[j].compareTo(pq[j/2])>0) {
                    T k=pq[j];
                    pq[j]=pq[j/2];
                    pq[j/2]=k;
                }
            }
        } //our array is sorted by minheapify(root is min item)
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



   //
}