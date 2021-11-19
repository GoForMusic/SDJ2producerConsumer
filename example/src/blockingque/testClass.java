package blockingque;

public class testClass {
    public static void main(String[] args)
    {
        BlockingQueue queue = new BlockingQueue(10);

        for(int i =0;i<101;i++)
        {
            Thread p = new Thread(new Taskproducer(queue,i));
            Thread c = new Thread(new TaskConsumer(queue,i));
            p.start();
            c.start();
        }
    }
}
