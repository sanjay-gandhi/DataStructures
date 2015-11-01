import java.util.Scanner;

/**
 * @author Sanjay
 *
 */

public class CircularQueue {
	int SIZE = 10;
	int[] cirQueue = new int[SIZE];
	int front = 0;
	int rear = 0;
	int currSize = 0;

	public void enqueue(int item) {
		if (currSize == SIZE) {
			System.out.println("OVERFLOW !!");
			return;
		}
		cirQueue[rear] = item;
		rear = (rear + 1) % SIZE;
		currSize++;
	}

	public void dequeue() {
		if (front == rear && currSize < SIZE) {
			System.out.println("Underflow!!");
			return;
		} else {
			front = (front + 1) % SIZE;
			currSize--;
		}
	}

	public void display() {
		System.out.print("Queue : ");
		if (front < rear)
			for (int i = front; i < rear; i++)
				System.out.print(cirQueue[i] + " ");
		if (rear <= front)
			if (currSize > 0) {
				for (int i = front; i < SIZE; i++)
					System.out.print(cirQueue[i] + " ");
				if (rear != 0)
					for (int i = 0; i < rear; i++)
						System.out.print(cirQueue[i] + " ");
			}
	}

	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue();
		Scanner in = new Scanner(System.in);
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
				cq.enqueue(in.nextInt());
				break;
			case 2:
				cq.dequeue();
				break;

			default:
				System.out.println("Wrong Choice !! ");
			}
			cq.display();
			System.out.println();
			System.out.println("Want to continue(y/n) ? ");
			ch = in.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
		in.close();
	}
}
