import java.util.ArrayList;

public class Test<E> implements Comparable<E>{
    Comparable<E>[] container;
    private static final int iniCapa = 10;

    public Test(){
        this.container = (Comparable<E>[]) new Object [this.iniCapa];
    }
    public static void main(String[] args){

        int[] test = {1,2,3,4};
        int i = 3;
        while(i>0){
            System.out.println(test[--i]);

        }

        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(1);
        System.out.println(primes.size());

        int [] a = {1};
        //System.out.println(a[1]);
        myMethod(1);
        myMethod(1.0d);
        int [] myArr = {1,2,3,4};
        myMethod(myArr);

        ArrayList<Integer> arr1 = new ArrayList<>(2);
        arr1.add(1);
        arr1.add(2);
        arr1.add(3); //auto enlarge
        System.out.println(arr1);

        Test<Integer> test0 = new Test<>();
        System.out.println(test0.container.length);

        System.out.println(test0.container.length);

        int k = 1, index = 5;
        while(++k<index){
            System.out.println(k);
        }
        System.out.println();
        k = 1;
        while(k++<index){ //++ after < cmp
            System.out.println(k);
        }
    }

    public static void myMethod(Integer i){
        System.out.println(i);
    }
    public static void myMethod(Double d){
        System.out.println(d);
    }

    public static <T> void myMethod(T t){
        System.out.println(t);
    }

    @Override
    public int compareTo(E o) {
        return 0;
    }
}
