import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<Integer>();
        ((LinkedList<Integer>) queue).add(2);
        ((LinkedList<Integer>) queue).add(3);
        for (int i=0; i<queue.size()-1; i++) {
            ((LinkedList<Integer>) queue).add(queue.poll());
        }

        for (int i=0; i<queue.size()-1; i++) {
            System.out.println(((LinkedList<Integer>) queue).get(i));
        }
    }
}
