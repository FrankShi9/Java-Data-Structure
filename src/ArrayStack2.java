public class ArrayStack2<E> implements Cloneable{
    private E [] data;

    private int manyItems;

    public ArrayStack2<E> clone(){
        ArrayStack2<E> answer;
        try{
            answer = (ArrayStack2<E>) super.clone(); //calls the clone() in Object class :)
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("The class is not cloneable:("); //
        }
        answer.data = this.data.clone(); //clone the attributes:)
        return answer;
    }

    public static void main(String[] args){
        ArrayStack2<Integer> as1 = new ArrayStack2<>();
        System.out.println(as1.clone().data.length);
    }
}
