import java.util.Scanner;

/**
 * @author Sanjay Gandhi
 * 
 *
 */
public class StackArray<T extends Comparable<T>> {

	int top = 0;
	T[] stack;

	@SuppressWarnings("unchecked")
	public StackArray() {
		// TODO Auto-generated constructor stub
		stack = (T[]) new Comparable[10];
	}

	@SuppressWarnings("unchecked")
	public void push(T item) {
		if (top == stack.length) {
			T[] newList = (T[]) new Comparable[stack.length * 2];
			System.arraycopy(stack, 0, newList, 0, stack.length);
			stack = newList;
		}
		stack[top++] = item;
	}
	
	@SuppressWarnings("unchecked")
	public void pop() {
		if (top == 0) {
			System.out.println("UNDERFLOW !!");
			return;
		}
		top--;
		stack[top] = null;
		if (top < stack.length / 2 && stack.length > 10) {
			T[] newStack = (T[]) new Comparable[stack.length / 2];
			System.arraycopy(stack, 0, newStack, 0, stack.length/2);
			stack = newStack;
		}
	}
	
	public void display() {
		System.out.print("Stack : ");
		for (int i = top-1; i >= 0; i--)
			System.out.print(stack[i] + " ");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		StackArray<Integer> stack = new StackArray<Integer>();
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
			if (stack.top != 0)
				stack.display();
			System.out.println();
			System.out.println("Want to continue(y/n) ? ");
			ch = in.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
		in.close();
	}

}
