public class ThreadExer {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args){
        ThreadExer test = new ThreadExer();
        ThreadX thread0 = test.new ThreadX();
        ThreadX thread1 = test.new ThreadX();
        thread0.start();
        thread1.start();
    }

    class ThreadX extends Thread{
        @Override
        public void run(){
            synchronized (object){
                i++;
                System.out.println("i="+i);
                try{
                    System.out.println("Thread:"+Thread.currentThread().getName()+"going to sleep");
                    Thread.currentThread().sleep(10000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread:"+Thread.currentThread().getName()+"sleep is over");
                i++;
                System.out.println("i="+i);
            }
        }
    }
}
