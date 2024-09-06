package multiThreading;

public class MultiThreading extends Thread{

    private final int thread_number;

    public MultiThreading(int t){
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
