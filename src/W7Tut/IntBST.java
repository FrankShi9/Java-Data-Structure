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
public class IntBST {
    IntBTNode root;
	 
    /* Constructor */
    public IntBST()
    {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }


    /* Functions to insert data */
    public void insert(int data)
    {
        root = insert(root, data); //insert to root recursively
    }


    /* Function to insert data recursively */
    private IntBTNode insert(IntBTNode node, int data)
    {
        if (node == null){
            node = new IntBTNode(data);
            return node;
        }  
        if (data < node.data)
        	node.left = insert(node.left, data); //insert l
        else
        	node.right = insert(node.right,data); //insert r   	    
        return node;
    }


    /* Function to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(IntBTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /* Function to search for an element */
    public boolean search(int data)
    {
        return search(root, data);
    }
    /* Function to search for an element recursively */
    private boolean search(IntBTNode node, int data)
    {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        return node.data > data ? search(node.left, data) : search(node.right, data);        
    }
    
    public void delete(int data){
    
        root = delete(root, data);
    
    }

    private IntBTNode delete(IntBTNode node, int data){
        
        /* Base Case: If the tree is empty */
        if (node == null) {
            return node;
        }

        /* Otherwise, recur down the tree */
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } 
        // if key is same as root's key, then This is the node
        // to be deleted
        else {
            // node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            node.data = node.right.getLeftmostData();

            // Delete the inorder successor
            node.right = delete(node.right, node.data);
        }
        return node;
    }


    /* Function for inorder traversal */
    public void inorder()
    {
        root.inorderPrint();
    }
    
    /* Function for preorder traversal */
    public void preorder()
    {
        root.preorderPrint();
    }
    
    /* Function for postorder traversal */
    public void postorder()
    {
        root.postorderPrint();
    }
}