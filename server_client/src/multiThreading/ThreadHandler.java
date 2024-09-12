package multiThreading;

public class ThreadHandler {
    public static void  main(String[] args){
//        MultiThreading t1 = new MultiThreading(1);
//        MultiThreading t2 = new MultiThreading(2);
//        MultiThreading t3 = new MultiThreading(3);
//
//        t1.start();
//        t2.start();
//        t3.start();

        MultiThread_Runnable t1 = new MultiThread_Runnable(1);
        Thread tt1 = new Thread(t1);
        MultiThread_Runnable t2 = new MultiThread_Runnable(2);
        Thread tt2 = new Thread(t2);
        MultiThread_Runnable t3 = new MultiThread_Runnable(3);
        Thread tt3 = new Thread(t3);

        tt1.start();
        tt2.start();
        tt3.start();


    }
}
