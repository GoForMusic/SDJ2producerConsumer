import java.util.concurrent.BlockingQueue;

// producer
public class Reception implements Runnable {
    BlockingQueue<Customer> queue;

    public Reception(BlockingQueue<Customer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String [] customers = {"ALfonso", "Adrian", "Benjamin", "Christopher", "Emil",
        "Juraj", "Khaled", "Mihai", "Sachin"};
        System.out.println(customers.length + " Customers waiting");
        for (String c : customers){
            Customer customer = new Customer(c);
            try {
                Thread.sleep(1000);
                queue.put(customer);
                System.out.println("Put " + customer.getName() + " in the queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // no more customers to put i the queue, receptionist can go and eat
        System.out.println("No more customers to put in the queue");
        try {
            Thread.sleep(1000);
            queue.put(new Customer("Receptionist"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
