public class VarArgs {

    public static void main(String[] args){
        test();
        test("a","b");
        test("a","b","c");
    }

    public static void test(String... args){
        System.out.println("begin ---------------");
        System.out.println(args.getClass());
        System.out.println("---------------");
        for(String arg: args){
            System.out.println(arg);
        }
        System.out.println("end ---------------");
    }

}
