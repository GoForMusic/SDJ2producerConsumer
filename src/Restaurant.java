import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Assuming we serve only 5 customers at a time
public class Restaurant {
    public static void main(String[] args) {
        BlockingQueue<Customer> queue = new ArrayBlockingQueue<>(5);
        Reception producer = new Reception(queue);
        Waiter consumer = new Waiter(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
