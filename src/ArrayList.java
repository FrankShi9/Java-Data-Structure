import java.util.*;

public class ArrayList<E> extends AbstractList<E> {

    private E[] data;
    private int count = 0;
    private static int INICAPACITY = 16;

    public ArrayList(){
        data = (E[]) new Object[INICAPACITY];
    }

    /** returns number of eles in collection as int*/
    public int size(){
        return count;
    }

    /** returns true if this set contains no eles*/
    public boolean isEmpty(){
        return count==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<E>(this);
    }

    private class ArrayListIterator<E> implements Iterator<E>{
        private ArrayList <E> targetList; // reference to the list it is iterating down
        private int nextIndx = 0; // the index of the next value to return
        private boolean canRemove = false; // to disallow the remove operation initially

        /**
         * Constructor
         * @return
         */
        private ArrayListIterator(ArrayList<E> targetList){
            this.targetList = targetList;
        }
        /** Return true if iterator has at least one more element */
        @Override
        public boolean hasNext() {
            return (nextIndx< targetList.count);
        }

        @Override
        public E next() {
            if(nextIndx>=targetList.count) throw new NoSuchElementException();
            return targetList.get(nextIndx++);
        }
        /** Remove from the list the last element returned by the iterator.
         * Can only be called once per call to next. */
        public void remove(){
            if(!canRemove) throw new UnsupportedOperationException();
            canRemove = false;
            nextIndx--;
            targetList.remove(nextIndx);
        }

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**returns the value at the specified index.
     * throws an indexOutOfBoundsException
     */
    public E get(int index){
        if(index<0 || index>=count){
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    /**Replaces the value at the specified index by the specified value
     * Returns the old value.
     * Throws an IndexOutOfBoundsException if index is out of
     bounds */
    public E set(int index, E value){
        if(index<0 || index>=count){
            throw new IndexOutOfBoundsException();
        }
        E answer = data[index];
        data[index] = value;
        return answer;
    }

    /** Removes the element at the specified index, and returns it.
     * Throws an IndexOutOfBoundsException if index is out of
     bounds */
    public E remove(int index){
        if(index<0 || index>=count){
            throw new IndexOutOfBoundsException();
        }
        E answer = data[index];
        for(int i=index+1; i<count; i++){
            data[i-1] = data[i];
        }
        data[--count] = null;
        return answer;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    /** Adds the specified element at the specified index.*/
    public void add(int index, E item){
        if(index<0 || index>=count){
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity();
        for(int i=count; i>index; i--){
            data[i] = data[i-1];
        }
        data[index] = item;
        count ++;
    }

    /**Ensure data array has sufficient number of elements
     * to add a new element */
    private void ensureCapacity(){
        if(count<data.length){
            return;
        }
        E[] newArray = (E[]) (new Object[data.length*2]);
        for(int i=0; i<count; i++){
            newArray[i] = data[i];

        }
        data = newArray; //pass reference
    }

}
