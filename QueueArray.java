import java.util.Scanner;
/**
 * @author Sanjay Gandhi
 */
public class QueueArray<T extends Comparable<T>> {

	int front = -1;
	int rear = 0;
	T[] queue;

	@SuppressWarnings("unchecked")
	public QueueArray() {
		// TODO Auto-generated constructor stub
		queue = (T[]) new Comparable[10];
	}

	@SuppressWarnings("unchecked")
	public void enqueue(T item) {
		if (rear == queue.length) {
			T[] newList = (T[]) new Comparable[queue.length * 2];
			System.arraycopy(queue, 0, newList, 0, queue.length);
			queue = newList;
		}
		if(front == -1)
			front = 0;
		queue[rear++] = item;
	}
	
	@SuppressWarnings("unchecked")
	public void dequeue() {
		if(front == -1){
			System.out.println("Underflow !!");
			return;
		}
		for(int i = front; i < rear; i++)
			queue[i] = queue[i+1];
		rear--;
		if(rear == 0)
			front = -1;
		if (rear < queue.length / 2 && queue.length > 10) {
			T[] newQueue = (T[]) new Comparable[queue.length / 2];
			System.arraycopy(queue, 0, newQueue, 0, queue.length/2);
			queue = newQueue;
		}
	}
	
	public void display() {
		System.out.print("Queue : ");
		for (int i = front; i < rear; i++)
			System.out.print(queue[i] + " ");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		QueueArray<Integer> queue = new QueueArray<Integer>();
		char ch = 'y';
		System.out.println("MENU");
		System.out.println("1. Enqueue");
		System.out.println("2. Dequeue");
			
		do {
			System.out.println("Enter the choice : ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the element to be enqueued : ");
				queue.enqueue(in.nextInt());
				break;
			case 2:
				queue.dequeue();
				break;
			
			default:
				System.out.println("Wrong Choice !! ");
			}
			if (queue.rear != 0)
				queue.display();
			System.out.println();
			System.out.println("Want to continue(y/n) ? ");
			ch = in.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
		in.close();
	}
}
