import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HuffmanCode {
    //build a (sub) tree element
    public static HuffmanTreeNode buildHuffmanTree(List<HuffmanTreeNode> nodes){
        int n = nodes.size();
        //n-1 times
        for(int i=1;i<n;i++){
            Collections.sort(nodes);

            HuffmanTreeNode min1 = nodes.remove(0);
            HuffmanTreeNode min2 = nodes.remove(0);
            HuffmanTreeNode newNode = new HuffmanTreeNode(min1.getWeight()+ min2.getWeight());
            newNode.setLeftC(min1);
            newNode.setRightC(min2);
            nodes.add(newNode);
        }
        return nodes.get(0); //get the tree added previously
    }


    public static void generateHuffmanCode(HuffmanTreeNode root){ //allocate 0 to leftC and 1 to rightC (set object attr)
        if (root.getLeftC() != null) {
            root.getLeftC().setCode(root.getCode() + "0");
            generateHuffmanCode(root.getLeftC()); //depth first //base case: stop when no child
        }

        if (root.getRightC() != null) {
            root.getRightC().setCode(root.getCode() + "1");
            generateHuffmanCode(root.getRightC());
        }
    }

    //test cases
    public static void main(String[] args) {

        HuffmanTreeNode node1 = new HuffmanTreeNode(4); //weight == frequency
        node1.setContent("A");
        HuffmanTreeNode node2 = new HuffmanTreeNode(3);
        node2.setContent("B");
        HuffmanTreeNode node3 = new HuffmanTreeNode(2);
        node3.setContent("C");
        HuffmanTreeNode node4 = new HuffmanTreeNode(1);
        node4.setContent("D");


        List<HuffmanTreeNode> nodes = new LinkedList<HuffmanTreeNode>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);

        List<HuffmanTreeNode>nodeCopy = new ArrayList<HuffmanTreeNode>();
        nodeCopy.addAll(nodes);

        HuffmanTreeNode root = buildHuffmanTree(nodes);
        generateHuffmanCode(root);

        /*
        for(HuffmanTreeNode node: nodeCopy){
            System.out.println(node.getContent()+"->"+node.getCode());
        }
        */
    }


}
