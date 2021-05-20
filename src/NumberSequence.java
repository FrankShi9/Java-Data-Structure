import java.util.Iterator;

public class NumberSequence implements Iterable<Integer>{
    private int start, step;

    /** Cons */
    public NumberSequence(int start, int step){
        this.start = start;
        this.step = step;
    }

    public Iterator<Integer> iterator(){
        return new NumberSequenceIterator(this);
    }

    private class NumberSequenceIterator implements Iterator<Integer>{
        private int nextNum;
        private NumberSequence source;

        /**
         * Cons
         */
        public  NumberSequenceIterator(NumberSequence inputNs){
            source = inputNs;
            nextNum = inputNs.start;
        }

        public boolean hasNext(){
            return true;
        }

        public Integer next(){
            int ans = nextNum;
            nextNum += step;
            return ans;
        }
    }// end of NumberSequenceIterator class

    public static void main(String[] args){
        Iterator<Integer> itr = new NumberSequence(15,8).iterator();
        while(itr.hasNext()){
            System.out.printf("next num is "+itr.next()+"\n");
        }
    }

}// end of Number Sequence class
