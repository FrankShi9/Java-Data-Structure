import java.util.*;

public class Face implements Comparable<Face>{
    private int top=0, bot=0 , l=0, r=0;

    public Face(int top, int bot, int l, int r){
        this.top = top;
        this.bot = bot;
        this.l = l;
        this.r = r;
    }

    public int getTop(){
        return this.top;
    }

    public int getBot(){
        return this.bot;
    }

    public int getL(){
        return this.l;
    }

    public int getR(){
        return this.r;
    }

    public int getSum(){
        return this.top+this.bot+this.l+this.r;
    }


    @Override
    public String toString(){
        return "top: "+this.getTop()+" bot: "+this.getBot()+" left: "+this.getL()+" right: "+this.getR()+" sum: "+this.getSum();
    }


    @Override
    public int compareTo(Face o) {
        if(this.getSum()>o.getSum()){
            return 1;
        }else if(this.getSum()==o.getSum()){
            return 0;
        }else{
            return -1;
        }
    }

    public static class TopToBotComparator implements Comparator<Face>{

        @Override
        public int compare(Face f1, Face f2) {
            return (f1.getTop()-f2.getTop());
        }

    }

    public static class BigToSmallComparator implements Comparator<Face>{
        @Override
        public int compare(Face f1, Face f2) {
            if(f1.getSum() > f2.getSum()){
                return f1.getSum() - f2.getSum();
            }else{
                return f2.getSum() - f1.getSum();
            }
        }
    }

    public static class LeftToRightComparator implements Comparator<Face>{
        @Override
        public int compare(Face f1, Face f2) {
            return f1.getL()-f2.getL();
        }
    }


    public static void main(String[] args){
        ArrayList<Face> faceList = new ArrayList<>();

        faceList.add(new Face(1,2,1,2));
        faceList.add(new Face(3,4,3,4));
        faceList.add(new Face(5,6,5,6));
        faceList.add(new Face(7,8,7,8));

        Scanner kb = new Scanner(System.in);
        String input = "";
        boolean det = true;

        while(det == true){
            input = kb.nextLine();
            if(input.equalsIgnoreCase("quit")) det = false;
            else if(input.equalsIgnoreCase("SmallToBig")){
                Collections.sort(faceList);
                for(Face face: faceList){
                    System.out.println(face.toString());
                }

            }
            else if(input.equalsIgnoreCase("BigToSmall")){
                Collections.sort(faceList, new BigToSmallComparator());

                for(Face face: faceList){
                    System.out.println(face.toString());
                }

            } else if(input.equalsIgnoreCase("LeftToRight")){
                Collections.sort(faceList, new LeftToRightComparator());
                for(Face face: faceList){
                    System.out.println(face.toString());
                }
            }
            else if(input.equalsIgnoreCase("TopToBottom")){
                Collections.sort(faceList, new TopToBotComparator());
                for(Face face: faceList){
                    System.out.println(face.toString());
                }
            }
            else{
                System.out.println("Invalid input, try again");
            }
        }

    }
}
