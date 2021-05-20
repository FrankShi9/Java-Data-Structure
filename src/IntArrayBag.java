

public class IntArrayBag implements Cloneable
{

   private int[ ] data;
   private int manyItems;  //The number of elements in the bag
   
   /**
   * Initialize an empty bag with an initial capacity of 10. 
   **/   
   public IntArrayBag( ){  //default constructor 
      final int INITIAL_CAPACITY = 10; //immutable constant
      manyItems = 0;                    //how many items stored
      data = new int[INITIAL_CAPACITY];
   }
     
   /**
   * Initialize an empty bag with a specified initial capacity. 
   **/   
   public IntArrayBag(int initialCapacity){ //constructor 2 #method overload
      if (initialCapacity < 0)
         throw new IllegalArgumentException("The initialCapacity is negative: " + initialCapacity);
      data = new int[initialCapacity];  //data [] is the internal storage array
      manyItems = 0;
   }
        
 
   /**
   * Add a new element to this bag. If the new element would take this
   * bag beyond its current capacity, then the capacity is increased
   * before adding the new element.
   **/
   public void add(int element){
      if (manyItems == data.length){  
         ensureCapacity((manyItems + 1)*2); // Ensure twice as much space as we need. in case initialCapa
                                                         // city = manyItems = 0
      }

      data[manyItems] = element;
      manyItems++;

   }


   /**
   * Add new elements to this bag. If the new elements would take this
   * bag beyond its current capacity, then the capacity is increased
   * before adding the new elements.
   **/
   public void addMany(int... elements){
      if (manyItems + elements.length > data.length){  
         ensureCapacity((manyItems + elements.length)*2);// Ensure twice as much space as we need.
      }

      System.arraycopy(elements, 0, data, manyItems, elements.length);
      manyItems += elements.length;
   }


   /**
   * Add the contents of another bag to this bag.
   **/
   public void addAll(IntArrayBag addend){
      ensureCapacity(manyItems + addend.manyItems);         
      System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems); //correct solu
      manyItems += addend.manyItems;
   }
   
   public void addAll2(IntArrayBag addend){
	   ensureCapacity(manyItems + addend.manyItems);
	   for(int i = 0; i < addend.manyItems; i++){ //it will loop until death since every i++ comes with manyItems++
		   add(addend.data[i]);
	   }
	   
   }
   
   
   /**
   * Generate a copy of this bag.
   **/ 
   public IntArrayBag clone( ){  // Clone an IntArrayBag object.
      IntArrayBag answer;
      
      try{
         answer = (IntArrayBag) super.clone( );
      }
      catch (CloneNotSupportedException e){  
         throw new RuntimeException("This class does not implement Cloneable");
      }
      
      answer.data = data.clone( );     
      return answer;
   }
   

   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   **/
   public int countOccurrences(int target){  //useful for intersection function
      int answer;
      int index;
      
      answer = 0;
      for (index = 0; index < manyItems; index++) {
         if (target == data[index]) {
            answer++;
         }
      }
      return answer;
   }


   /**
   * Change the current capacity of this bag.
   **/
   public void ensureCapacity(int minimumCapacity){
      int[ ] biggerArray;
      
      if (data.length < minimumCapacity){
         biggerArray = new int[minimumCapacity];
         System.arraycopy(data, 0, biggerArray, 0, manyItems);
         data = biggerArray; //pass the reference
      }
   }

   
   /**
   * Accessor method to get the current capacity of this bag. 
   **/
   public int getCapacity( ){
      return data.length;
   }

              
   /**
   * Remove one copy of a specified element from this bag.
   **/
   public boolean remove(int target){
      int index; // The location of target in the data array.
       
      // First, set index to the location of target in the data array,
      // which could be as small as 0 or as large as manyItems-1; If target
      // is not in the array, then index will be set equal to manyItems;
      for (index = 0; (index < manyItems) && (target != data[index]); index++); //find the matching index
         
      if (index == manyItems) // The target was not found, so nothing is removed.       
         return false;
      else{  // The target was found at data[index].
         
    	  // So reduce manyItems by 1 and copy the last element onto  data[index].
         data[index] = data[--manyItems];
         return true;
      }
   }

   //could add a removeAll(intArrayBag input);
   /**
   * TODO: Remove many targets and return the total number of elements removed. 
   * Please use enhanced for loop.
   **/
   public int removeMany(int...targets){//can take many ints or one int array

	   int count = 0;

	   for(int ele: targets){ //enhanced for loop

          if(remove(ele)){
             count++;
          }

       }
	   return count;
   }
                 
   
   /**
   * Determine the number of elements in this bag.
   **/ 
   public int size( ){
      return manyItems;
   }
   
   
   /**
   * Reduce the current capacity of this bag to its actual size (i.e., the
   * number of elements it contains).
   **/
   public void trimToSize( ){
      int[ ] trimmedArray;
      
      if (data.length != manyItems){
         trimmedArray = new int[manyItems];
         System.arraycopy(data, 0, trimmedArray, 0, manyItems);
         data = trimmedArray; //pass the reference
      }
   }
      
   /**
   * Create a new bag that contains all the elements from two other bags.
   **/   
   public static IntArrayBag union(IntArrayBag b1, IntArrayBag b2){

      IntArrayBag answer = new IntArrayBag(b1.getCapacity( ) + b2.getCapacity( ));
      
      System.arraycopy(b1.data, 0, answer.data, 0, b1.manyItems);
      System.arraycopy(b2.data, 0, answer.data, b1.manyItems, b2.manyItems);

      answer.manyItems = b1.manyItems + b2.manyItems;
      
      return answer;
   }
   
   /**
   * TODO: Create a new bag that contains the intersected elements from two other bags.
   **/ 
//   public static IntArrayBag intersection(IntArrayBag b1, IntArrayBag b2){
//	      IntArrayBag answer = new IntArrayBag();
//
//          //students implementation here.
//	      IntArrayBag backup = b1.clone(); //deep copy
//
//	      int cnt1 = 0, cnt2 = 0;
//	      //remove repeat items and store unique values in a backup
//          for(int i=0; i<backup.manyItems; i++){
//
//             if(backup.countOccurrences(backup.data[i])>1){
//                int cnt = backup.countOccurrences(backup.data[i])-1;
//                int tmp[] = new int[cnt];
//
//                for(int c=0;c<cnt;c++){
//                   tmp[c] = backup.data[i];
//                }
//
//                backup.removeMany(tmp);//ensure eles in backup[] are all unique
//
//             }
//
//          }
//
//
//	      for(int i=0;i<backup.manyItems;i++){
//
//             //count each unique ele in b1 and b1
//             cnt1 = b1.countOccurrences(backup.data[i]);
//             cnt2 = b2.countOccurrences(backup.data[i]);
//
//	         if( cnt1>1 && cnt2>1 ){
//
//	            int cnt = Math.min(cnt1,cnt2);//min between the two
//
//	            int tmp[] = new int [cnt];
//
//	            for( int j=0; j<tmp.length; j++){
//	               tmp[j] = backup.data[i]; //fill cnt dup eles
//                }
//
//	            answer.addMany(tmp);
//	            answer.manyItems += tmp.length;
//
//             }else if(cnt1 == 0 || cnt2 == 0){
//
//
//             }else{
//                answer.add(backup.data[i]);
//                answer.manyItems++;
//             }
//
//
//          }
//
//	      return answer;
//	   }
       public static IntArrayBag intersection(IntArrayBag b1, IntArrayBag b2){

          IntArrayBag answer = new IntArrayBag();
          int count, item;

          for(int i=0;i<b1.manyItems;i++){
             item = b1.data[i];
             if(answer.countOccurrences(item) == 0){

                count = Math.min(b1.countOccurrences(item),b2.countOccurrences(item));

                for(int j=0; j<count; j++){
                   answer.add(item);
                }

             }

          }
          return answer;
       }


	   public void printData(){
            System.out.println(this.getClass());
            for(int i=0;i<manyItems;i++) {
               System.out.println(data[i]);
            }
            System.out.println("---------------------------");
       }
}
           