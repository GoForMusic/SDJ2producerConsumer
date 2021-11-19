package blockingque;

public class TaskConsumer implements Runnable{

    private String name;
    private BlockingQueue queue;

    public TaskConsumer(BlockingQueue queue, int id) {
        this.name = "Consumer: "+id;
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            Task task= queue.retrieve();
            int result = task.a + task.b;
            System.out.println(name+" calculated result: "+result);
        }
    }
}
