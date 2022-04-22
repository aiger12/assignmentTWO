public class Main {
    public static void main(String[] args){
        MyArrayList<Integer> array= new MyArrayList<Integer>();
        for (int i = 0; i < 10; i++) array.add(i);
        array.add(99,2);
        for (int i = 0; i < 10; i++) {
            System.out.println(array.get(i));
        }
    }
}
