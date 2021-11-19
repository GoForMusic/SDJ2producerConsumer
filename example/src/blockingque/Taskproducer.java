package blockingque;

import java.util.Random;

public class Taskproducer implements Runnable{

    private BlockingQueue queue;
    String name;

    public Taskproducer(BlockingQueue queue, int id)
    {
        this.queue=queue;
        name  = "producer: "+id;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true){
            int a = rand.nextInt(100);
            int b = rand.nextInt(100);
            Task t= new Task(a,b);
            queue.add(t);
            System.out.println(name+" added task " + "("+a+","+b+")");
        }
    }
}
