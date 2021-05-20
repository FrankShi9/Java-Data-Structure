import java.util.EmptyStackException;

public class ArrayStack <E> implements Cloneable{

    private E [] data;
    private int manyItems;

    //constructor 1
    public ArrayStack(){
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = (E[]) new Object[INITIAL_CAPACITY];
    }

    //constructor 2
    public ArrayStack(int initialCapacity){
        if(initialCapacity<0){
            throw new IllegalArgumentException("Capacity must be positive, but your input is: "+initialCapacity);
        }
        manyItems = 0;
        data = (E[]) new Object[initialCapacity];
    }


    public ArrayStack<E> clone(){
        ArrayStack<E> answer;
        try{
            answer = (ArrayStack<E>) super.clone(); //calls the clone() in Object class :)
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("The class is not cloneable:("); //to see if ArrayStack<E> implements Cloneable interface
        }
        answer.data = this.data.clone(); //clone the attributes:)
        return answer;
    }

    public void ensureCapacity(int minCapacity){
        E [] biggerArr;
        if(this.data.length<minCapacity){ //enlarge only when necessary
            biggerArr = (E []) new Object [minCapacity];
            System.arraycopy(this.data,0, biggerArr,0, manyItems);
            data = biggerArr; //handover the reference
        }
    }

    public int getCapacity() {return this.data.length;} //the total capacity of the current data array

    public boolean isEmpty() {return this.manyItems==0;}

    public int size(){return this.manyItems;} //size (cnt) of current stored elements

    public int remainedCapacity(){return (this.data.length-manyItems);}


    public E peek(){

        if(this.isEmpty()){
            throw new EmptyStackException();
        }else{
            return this.data[manyItems-1];
        }
    }

    public E pop(){

//        E[] buf = (E []) new Object[this.manyItems];
//        E ele;
//        if(this.isEmpty()){
//            throw new EmptyStackException();
//        }else{
//            E [] answer = (E[]) new Object [this.data.length];
//            System.arraycopy(this.data,0,buf,0,this.manyItems);
//            ele = buf[manyItems-1];
//            System.arraycopy(this.data,0,answer,0,--manyItems); //change the manyItems attribute
//            this.data = answer; //handover the reference
//        }
//        //return ele;

        if(manyItems == 0) {
            throw new EmptyStackException();
        }

        return data[--manyItems];

    }

    public void push(E item){

        if(this.manyItems==this.getCapacity()){
            ensureCapacity((this.getCapacity()+1)*2); //plus 1 in case the capacity is 0
        }else{
            this.data[manyItems++] = item;
        }
    }

    public void trimToSize(){
        E [] answer;
        if(this.data.length!=this.manyItems){ // if this.data.length>this.manyItems then shrink the array
            answer = (E []) new Object[manyItems];//the final size is the cnt of actual items storing
            System.arraycopy(this.data,0,answer,0,manyItems);
            this.data = answer; //handover the reference
        }
    }

    public static void main(String[] args){
//        String a = "This is a test for arrayStack :)";
//        for (String ele: a.split(" ")){
//            System.out.println(ele);
//        }
        ArrayStack<String> arrayStack1 = new ArrayStack<>();
        for(String s: "This is a test for arrayStack".split(" ")) {
            arrayStack1.push(s);
        }

        try {
            while (!arrayStack1.isEmpty())
                System.out.print(arrayStack1.pop() + " ");
        }catch(EmptyStackException e){
            System.out.println("Stack is empty");
        }
    }

}
