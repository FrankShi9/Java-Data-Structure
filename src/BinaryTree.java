
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author kokhoewong
 */
public class BinaryTree {
    IntBTNode root;

    public BinaryTree() {
        root = null;
    }
    
    //recursive method
    public boolean isComplete(IntBTNode root, int index, int number_nodes){
        //An empty tree is complete
        if (root == null) return true;
        
        //If index assigned to current node is more than
        //number of nodes in tree, then tree is not complete
        if (index >= number_nodes) return false; 
  
        //Recur for left and right subtrees
        return (isComplete(root.left, 2 * index + 1, number_nodes) 
            && isComplete(root.right, 2 * index + 2, number_nodes));
  
    }
    
    //iterative method
    public boolean isComplete(IntBTNode root){
        //An empty tree is complete Binary Tree
        if(root == null) return true;   
        //Create an empty queue
        Queue<IntBTNode> queue =new LinkedList<>(); 
        //Create a flag variable which will be set true
        //when there is a node which is not full
        boolean flag = false;
        // Do level order traversal using queue.
        queue.add(root);
        while(!queue.isEmpty()){
            IntBTNode temp_node = queue.remove();            
            /* Check if left child is present*/
            if(temp_node.left != null){
                 // If we have seen a non full node, and we see a node
                 // with non-empty left child, then the given tree is not
                 // a complete Binary Tree
                if(flag == true)
                    return false;                
                 // Enqueue Left Child
                queue.add(temp_node.left);
            }
            // If this a non-full node, set the flag as true
            else flag = true;
             
            /* Check if right child is present*/
            if(temp_node.right != null){
                // If we have seen a non full node, and we see a node
                // with non-empty right child, then the given tree is not
                // a complete Binary Tree
                if(flag == true)
                    return false;                
                // Enqueue Right Child
                queue.add(temp_node.right);          
            }
            // If this a non-full node, set the flag as true
            else flag = true;
        }
         // If we reach here, then the tree is complete Bianry Tree
        return true;
    }
    
     //This Function checks the heap property in the tree.
    boolean isHeapUtil(IntBTNode root){
        //Base case : single node satisfies property
        if(root.left == null && root.right==null)
            return true;    
        //node will be in second last level
        if(root.right == null){
            //  check heap property at Node
            //  No recursive call , because no need to check last level
            return root.data >= root.left.data;
        }
        else{
            //  Check heap property at Node and
            //  Recursive check heap property at left and right subtree
            if(root.data >= root.left.data && root.data >= root.right.data)
                return isHeapUtil(root.left) && isHeapUtil(root.right);
            else
                return false;
        }
    }
     
    //Function to check binary tree is a Heap or Not.
    boolean isHeap(IntBTNode root){
        if(root == null)
            return true;        
        // These two are used in isCompleteUtil()
        int node_count = IntBTNode.treeSize(root);      
        return isComplete(root, 0 , node_count)==true && isHeapUtil(root)==true;
    } 
}
