package multiThreading;

public class MultiThread_Runnable implements Runnable {
    private final int thread_number;

    public MultiThread_Runnable(int t){
        thread_number = t;
    }
    public void run(){
        for(int i =0; i<=10; i++){
            System.out.println("Thread: "+thread_number + "-"+i);

            if (thread_number == 3) {
                throw new RuntimeException();
            }

            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
