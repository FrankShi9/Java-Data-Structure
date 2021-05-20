/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ting.Cao
 */
public class IntArrayBagTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntArrayBag firstBag = new IntArrayBag();
        
        firstBag.addMany(1,2,3,4,5,6,7);       
        System.out.println("There are : "+firstBag.size() + " item(s) in the first bag"); //7
       
        IntArrayBag secondBag = new IntArrayBag();
        int[] nums = {3,3,4,5,6,7,8,9};
        secondBag.addMany(nums); //
        System.out.println("There are : "+secondBag.size() + " item(s) in the second bag"); //8
        
        firstBag.addAll(secondBag); //15
        firstBag.addAll(firstBag); //30
        //firstBag.addAll2(firstBag); //heap space error
        System.out.println("There are : "+firstBag.size() + " item(s) in the first bag"); //30
        
        System.out.println("firstBag has: "+firstBag.countOccurrences(3)+"eles"); //6
        

        IntArrayBag part1 = new IntArrayBag();
        part1.addMany(1,2,2); //3
        int[] a = {1,2}; //2
        part1.removeMany(a);
        System.out.println("There are : "+part1.size() + " item(s) in the part 1 bag");
        part1.printData();

        IntArrayBag part2 = new IntArrayBag();

        part2.addMany(2,2,2,3,4); //5
        System.out.println("There are : "+part2.size() + " item(s) in the part 2 bag");

        IntArrayBag unionBag = IntArrayBag.union(part1, part2);
        IntArrayBag intersectionBag = IntArrayBag.intersection(part1, part2);
        System.out.println("There are : "+unionBag.size() + " item(s) in the unionBag"); //6
        unionBag.printData();
        System.out.println("There are : "+intersectionBag.size() + " item(s) in the intersectionBag"); //1
        intersectionBag.printData();

        IntArrayBag b1 = new IntArrayBag();
        b1.addMany(1,2,3);
        IntArrayBag b2 = b1.clone();
        System.out.println(b1.countOccurrences(2));
        System.out.println(b2.countOccurrences(2));
        System.out.println("b1"+b1);
        System.out.println("b2"+b2);
        b1 = b2; //garbage collect
        System.out.println("b1"+b1);
        System.out.println("b2"+b2);
        System.out.println(b2.countOccurrences(1));

    }
    
}
