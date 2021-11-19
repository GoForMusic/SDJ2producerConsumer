package blockingque;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Task> queue;
    private int cap;


    public BlockingQueue(int cap){
        queue = new LinkedList<>();
        this.cap = cap;
    }

    //add a element to que and notify all the ques
    public synchronized void add(Task e)
    {
        while(queue.size() >=cap){
            try {
                System.out.println("Queue was full");
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        queue.add(e);
        notifyAll();
    }

    //get a element from que and notify the others threads
    public synchronized Task retrieve()
    {
        while (queue.isEmpty()){
            try {
                System.out.println("Queue was empty");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Task task = queue.poll();
        notifyAll();
        return task;
    }



}
