
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kokhoewong
 */
public class BinaryTreeTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
         
        // Le us create tree in the last diagram above
        
        tree.root = new IntBTNode(1);
        tree.root.left = new IntBTNode(2);
        tree.root.right = new IntBTNode(3);
        tree.root.left.right = new IntBTNode(5);
        tree.root.left.left = new IntBTNode(4);
        tree.root.right.right = new IntBTNode(6);
        //tree.root.right.left = new IntBTNode(5);
          
        int node_count = IntBTNode.treeSize(tree.root);
        int index = 0;
          
        if (tree.isComplete(tree.root, index, node_count))
            System.out.println("The binary tree is complete");
        else
            System.out.println("The binary tree is not complete"); 
        
        if (tree.isComplete(tree.root))
            System.out.println("The binary tree is complete");
        else
            System.out.println("The binary tree is not complete");
        tree.root.print(1);
        
        
        
        BinaryTree heap = new BinaryTree();

        heap.root = new IntBTNode(10);
        heap.root.left = new IntBTNode(9);
        heap.root.right = new IntBTNode(8);
        heap.root.left.left = new IntBTNode(7);
        heap.root.left.right = new IntBTNode(6);
        heap.root.right.left = new IntBTNode(5);
        heap.root.right.right = new IntBTNode(4);
        heap.root.left.left.left = new IntBTNode(3);
        heap.root.left.left.right = new IntBTNode(2);
        heap.root.left.right.left = new IntBTNode(1);

        if(heap.isHeap(heap.root) == true)
            System.out.println("Given binary tree is a Heap");
        else
            System.out.println("Given binary tree is not a Heap");

        heap.root.print(1);
    }
}
