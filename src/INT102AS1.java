public class INT102AS1 {

    public static void main(String[] args) {
        System.out.println(multiplication(2,11));
        //System.out.println(Math.pow(2,3));
        System.out.println(exp(2,11));
    }

    public static long multiplication(int base , int exp) {


        if (exp==1) {
            return base;
        }
        else {
            long a_1 = multiplication(base, exp/2);
            long a_2 = multiplication(base, exp-(exp/2));
            return a_1 *a_2;
        }

    }


    public static long exp(int a, int n){
        if (n == 1){
            return a;
        }else{
            if(n%2==0){
                int mid = (n/2);
                long buf = exp(a,mid);
                return buf*buf;
            }else{
                int mid = (n/2);
                long buf = exp(a,mid);
                long result = buf*buf;
                return result*a;
            }
        }
    }


}
