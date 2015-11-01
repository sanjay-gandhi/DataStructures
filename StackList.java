import java.util.Scanner;

/**
 * @author Sanjay
 *
 */

class StackNode<T extends Comparable<T>> {
	T value;
	StackNode<T> next;

	public StackNode(T item) {
		value = item;
		next = null;
	}
}

public class StackList<T extends Comparable<T>> {
	StackNode<T> top = null;
	
	public void push(T item) {
		StackNode<T> temp = new StackNode<T>(item);
		if (top == null)
			top = temp;
		else {
			temp.next = top;
			top = temp;
		}
	}
	
	public void pop() {
		if (top == null)
			System.out.println(" Underflow !");
		else
			top = top.next;
	}
	
	public void display() {
		StackNode<T> curr = top;
		System.out.print("STACK : ");
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		StackList<Integer> stack = new StackList<Integer>();
		char ch = 'y';
		System.out.println("MENU");
		System.out.println("1. Push");
		System.out.println("2. Pop");
			
		do {
			System.out.println("Enter the choice : ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the element to be pushed : ");
				stack.push(in.nextInt());
				break;
			case 2:
				stack.pop();
				break;
			
			default:
				System.out.println("Wrong Choice !! ");
			}
			if (stack.top != null)
				stack.display();
			System.out.println();
			System.out.println("Want to continue(y/n) ? ");
			ch = in.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
		in.close();
	}
}
