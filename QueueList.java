import java.util.Scanner;

/**
 * @author Sanjay
 *
 */
class QueueNode<T extends Comparable<T>> {
	T value;
	QueueNode<T> next;

	public QueueNode(T item) {
		value = item;
		next = null;
	}
}


public class QueueList<T extends Comparable<T>> {
		QueueNode<T> front;
		QueueNode<T> rear;

		public QueueList() {
			front = rear = null;
		}
		
		public void enqueue(T item) {
			QueueNode<T> temp = new QueueNode<T>(item);
			if (front == null)
				front = rear = temp;
			else {
				rear.next = temp;
				rear = temp;
			}
		}
		public void dequeue() {
			if (front == null)
				System.out.println(" Underflow !");
			else if (front == rear)
				front = rear = null;
			else
				front = front.next;
		}
		
		public void display() {
			QueueNode<T> curr = front;
			System.out.print("LIST : ");
			while (curr != null) {
				System.out.print(curr.value + " ");
				curr = curr.next;
			}
		}
		
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);

			QueueList<Integer> queue = new QueueList<Integer>();
			char ch = 'y';
			System.out.println("MENU");
			System.out.println("1. Push");
			System.out.println("2. Pop");
				
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
				if (queue.front != null)
					queue.display();
				System.out.println();
				System.out.println("Want to continue(y/n) ? ");
				ch = in.next().charAt(0);

			} while (ch == 'y' || ch == 'Y');
			in.close();
		}
}
