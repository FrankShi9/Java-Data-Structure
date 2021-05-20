import java.util.Iterator;

public class NumCreator implements Iterator<Integer>{
    private int num = 1;

    public boolean hasNext(){
        return true; //always true here
    }

    public Integer next(){
        num = (num*92863) % 104729 + 1;
        return num;
    }

    public static void main(String[] args){
        Iterator<Integer> lottery = new NumCreator();
        for(int i=1; i<1000; i++){
            System.out.println(lottery.next());
        }
    }
}
