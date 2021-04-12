/******************************************************************************
 * An ArrayBag is a generic collection of references to objects.
 * The same object may appear multiple times in a bag.
 ******************************************************************************/
public class ArrayBag<E> implements Cloneable //Comparable or not is specified in E
{

    private E[ ] data;
    private int manyItems;

    /**
     * Initialize an empty bag with an initial capacity of 10.
     **/
    public ArrayBag( )
    {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = (E[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Initialize an empty bag with a specified initial capacity.
     **/
    public ArrayBag(int initialCapacity)
    {
        if(initialCapacity < 0){

            throw new IllegalArgumentException("The initialCapacity is negative: "+ initialCapacity);

        }
        data = (E[]) new Object[initialCapacity];
        manyItems = 0;
    }


    /**
     * Add a new element to this bag. If the new element would take this
     * bag beyond its current capacity, then the capacity is increased
     * before adding the new element.
     * @param element
     *   the new element that is being inserted
     **/
    public void add(E element)
    {
        if (manyItems == data.length)
        {  // Ensure twice as much space as we need.
            ensureCapacity((manyItems + 1)*2);
        }
        data[manyItems] = element;
        manyItems++;
    }


    /**
     * Add the contents of another bag to this bag.
     * @param addend
     *   a bag whose contents will be added to this bag
     **/
    public void addAll(ArrayBag<E> addend)
    {
        // If addend is null, then a NullPointerException is thrown.
        ensureCapacity(manyItems + addend.manyItems);
        System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
        manyItems += addend.manyItems;
    }


    /**
     * Add new elements to this bag. If the new elements would take this
     * bag beyond its current capacity, then the capacity is increased
     * before adding the new elements.
     * @param elements
     *   (a variable-arity argument)
     *   one or more new elements that are being inserted
     **/
    public void addMany(E... elements)//mth with a flexible length of params:)
    {
        if (manyItems + elements.length > data.length)
        {  // Ensure twice as much space as we need.
            ensureCapacity((manyItems + elements.length)*2);
        }
        System.arraycopy(elements, 0, data, manyItems, elements.length);
        manyItems += elements.length;
    }


    /**
     * Generate a copy of this bag.
     * @return
     *   The return value is a copy of this bag. Subsequent changes to the
     *   copy will not affect the original, nor vice versa.
     **/
    public ArrayBag<E> clone( )
    {  // Clone an ArrayBag object.
        ArrayBag<E> answer;
        try
        {
            answer = (ArrayBag<E>) super.clone( );
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException
                    ("This class does not implement Cloneable");
        }
        answer.data = data.clone( );
        return answer;
    }


    /**
     * Accessor method to count the number of occurrences of a particular element
     * in this bag.
     * @param target
     *   the element that needs to be counted
     * @return
     *   the number of times that target occurs in this bag
     **/
    public int countOccurrences(E target)
    {
        int answer;
        int index;
        answer = 0;
        if(target == null){
            //count how many times null appears
            for (index = 0; index < manyItems; index++)
                if (data[index] == null)
                    answer++;
        }else{
            for (index = 0; index < manyItems; index++)
                if (target.equals(data[index]))
                    answer++;
        }
        return answer;
    }


    /**
     * Change the current capacity of this bag.
     * @param minimumCapacity
     *   the new capacity for this bag
     **/
    public void ensureCapacity(int minimumCapacity)
    {
        E biggerArray[ ];
        if (data.length < minimumCapacity)
        {
            biggerArray = (E[]) new Object[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }


    /**
     * Accessor method to get the current capacity of this bag.
     **/
    public int getCapacity( )
    {
        return data.length;
    }


    /**
     * Accessor method to retrieve a random element from this bag.
     * @precondition
     *   This bag is not empty.
     * @return
     *   a randomly selected element from this bag
     **/
    public E grab( )
    {
        int i; //index i
        //make sure the bag is not empty
        if(manyItems == 0){
            throw new IllegalStateException("Bag size is zero!");
        }

        i = (int) (Math.random()*manyItems); //random index
        return (E) data[i];

    }


    /**
     * Remove one copy of a specified element from this bag.
     * @param target
     *   the element to remove from the bag
     * @return
     *   If target was found in the bag, then one copy of target has been removed and the method returns true.
     *   Otherwise the bag remains unchanged and the method returns false.
     **/
    public boolean remove(E target)
    {

        int index; //The location of target in the data array

        if(target == null){
            return true;
        }
        // First, set index to the location of target in the data array,
        // which could be as small as 0 or as large as manyItems-1; If target
        // is not in the array, then index will be set equal to manyItems;
        for(index = 0; (index< manyItems) && (target != data[index]); index++);

        if(index == manyItems){

            return false;

        }else{

            // The target was found at data[index].
            // So reduce manyItems by 1 and copy the last element onto data[index].
            data[index] = data[--manyItems];
            return true;

        }


    }


    /**
     * Determine the number of elements in this bag.
     * @return
     *   the number of elements in this bag
     **/
    public int size( )
    {
        return manyItems;
    }


    /**
     * Reduce the current capacity of this bag to its actual size (i.e., the number of elements it contains).
     **/
    public void trimToSize( )
    {
        E[ ] trimmedArray;
        if (data.length != manyItems)
        {
            trimmedArray = (E[]) new Object[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }


    /**
     * Create a new bag that contains all the elements from two other bags.
     **/
    public static <E> ArrayBag<E> union(ArrayBag<E> b1, ArrayBag<E> b2)
    {
        // If either b1 or b2 is null, then a NullPointerException is thrown.
        // In the case that the total number of items is beyond
        // Integer.MAX_VALUE, there will be an arithmetic overflow and
        // the bag will fail.
        ArrayBag<E> answer = new ArrayBag<E>(b1.getCapacity( ) + b2.getCapacity( ));

        System.arraycopy(b1.data, 0, answer.data, 0, b1.manyItems);
        System.arraycopy(b2.data, 0, answer.data, b1.manyItems, b2.manyItems);
        answer.manyItems = b1.manyItems + b2.manyItems;

        return answer;
    }

}
