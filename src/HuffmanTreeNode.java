public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{

    //via objects using hash O(1)
    private String content = null;

    private int weight;

    private String code = "";

    private HuffmanTreeNode leftC = null;

    private HuffmanTreeNode rightC = null;

    //constructor:
    public HuffmanTreeNode(int weight){
        this.weight = weight;
    }

    //compareTo method:
    public int compareTo(HuffmanTreeNode other){
        if(this.weight<other.getWeight()){
            return -1; //this is smaller
        }else if(this.weight>other.getWeight()){
            return 1; //this is larger
        }else{
            return 0; //equal
        }
    }


    //getters and setters
    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public HuffmanTreeNode getLeftC(){
        return this.leftC;
    }

    public HuffmanTreeNode getRightC(){
        return this.rightC;
    }

    public void setLeftC(HuffmanTreeNode inputLC){
        this.leftC = inputLC;
    }

    public void setRightC(HuffmanTreeNode inputRC){
        this.rightC = inputRC;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }


}
