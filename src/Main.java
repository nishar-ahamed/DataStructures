import com.datastructures.queue.Queue;

public class Main {

    public static void main(String[] args) {
//        Stack stack = new Stack(2);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        while (!stack.isEmpty()) {
//            System.out.println("" + stack.pop());
//        }

        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        //queue.view();
        queue.enqueue(6);
        queue.dequeue();
        //System.out.println("Front: "+queue.front());
        //System.out.println("Rear : "+queue.rear());
        //queue.view();
        while(!queue.isEmpty()){
            System.out.println(""+queue.dequeue());
        }
    }
}
