/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kokhoewong
 */
package W7Tut;


public class IntBTTest {

    public static void main(String[] args) {

        /* Creating object of BT */
        IntBST tree = new IntBST();

        //order must be preserved!!
        tree.insert(50);


        tree.insert(30);

        tree.insert(40);
        tree.insert(20);


        tree.insert(70);

        tree.insert(60);
        tree.insert(80);

        /*  Display tree  */
        System.out.print("\nPost order : ");
        tree.postorder();
        System.out.print("\nPre order : ");
        tree.preorder();
        System.out.print("\nIn order : ");
        tree.inorder();
        System.out.println();

    }
}
