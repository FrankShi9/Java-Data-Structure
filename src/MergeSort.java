
public class MergeSort {

    public static void main(String[] args) {
        int[] input = {51, 13, 10, 64, 34, 5, 32, 21};
        int[] result = new int[input.length];
        int[] b = {10,13,51,64};
        int[] c = {5,21,32,34};
        printArr(merge(b,c,result));
        mergeSort(input);
        printArr(result);
    }

    public static int[] merge(int[] B, int[]C, int[]A){
        int i = 0, j = 0, k = 0;

        while(i<B.length && j<C.length){
            if(B[i]<=C[j]){
                A[k] = B[i++];
            }else{
                A[k] = C[j++];
            }
            k++;
        }

        while(j<=C.length-1){
            A[k++] =  C[j++];
        }


        while(i<B.length){
            A[k++] =  B[i++];
        }

        return A;
    }

    public static void mergeSort(int[] input) {

        int[] b, c;
        b = divideArrL(input);
        c = divideArrR(input);
        int[] result = new int[input.length];

        if (b.length == 1 && c.length == 1) {
            merge(b,c, result);
        } else {
            mergeSort(b);
            mergeSort(c);
            merge(b,c,result);
        }


    }


    public static int[] divideArrL(int[] input) {
        int[] a = new int[input.length / 2];//improve here
        int[] b = new int[input.length / 2];
        if (input.length > 0) {

            //copy a
            int mid = (int) (Math.floor((input.length) / 2) - 1);

            for (int i = 0; i <= mid; i++) {
                a[i] = input[i];
            }
            //copy b
            int j = (int) Math.floor((input.length) / 2);

            for (int i = 0; i <= Math.ceil(input.length / 2) - 1; i++) {
                b[i] = input[j++];
            }

        }
        return a;
    }

    public static int[] divideArrR(int[] input) {
        int[] b = new int[input.length / 2];
        if (input.length > 0) {

            //copy b
            int j = (int) Math.floor((input.length) / 2);

            for (int i = 0; i <= Math.ceil(input.length / 2) - 1; i++) {
                b[i] = input[j++];
            }

        }
        return b;
    }
        public static void printArr(int[] input){
            for(int ele:  input){
                System.out.print(ele+" ");
            }
            System.out.println("");
        }
}
