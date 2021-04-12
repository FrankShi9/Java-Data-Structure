public class RecursiveBinSearch {
    public static void main(String[] args){
        int [] a = {1,2,3,4,5};
        System.out.println(BS(a,0,4,1));
    }

    private static boolean RBS(int[] input, int first, int last, int x){
        if(first>last){
            return false;
        }
        int mid =(int) Math.floor((first+last)/2);
        if(x==input[mid]){
            return true;
        }else if (x<input[mid]){
            return RBS(input, first, --mid, x);
        }else{
            return RBS(input, ++mid, last, x);
        }
    }

    private static boolean BS(int[] input, int first, int last, int x){
        while(first<=last) {
            int mid = (int) Math.floor((first + last) / 2);
            if (x == input[mid]) {
                return true;
            } else if (x < input[mid]) {
                last = --mid;
            } else {
                first = ++mid;
            }

        }
        return false;
    }
}
