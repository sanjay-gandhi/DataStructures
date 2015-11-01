import java.util.Scanner;

/**
 * @author Sanjay Gandhi
 *
 */

class ListNode<T extends Comparable<T>> {
	T value;
	ListNode<T> next;

	public ListNode(T item) {
		value = item;
		next = null;
	}
}

public class LinkedList<T extends Comparable<T>> {
	ListNode<T> head;
	ListNode<T> tail;

	public LinkedList() {
		head = tail = null;
	}

	public void addFirst(T item) {
		ListNode<T> temp = new ListNode<T>(item);
		if (head == null)
			head = tail = temp;
		else {
			temp.next = head;
			head = temp;
		}
	}

	public void addLast(T item) {
		ListNode<T> temp = new ListNode<T>(item);
		if (head == null)
			head = tail = temp;
		else {
			tail.next = temp;
			tail = temp;
		}
	}

	public void addInOrder(T item) {
		ListNode<T> temp = new ListNode<T>(item);
		ListNode<T> curr = head.next;
		ListNode<T> prev = head;
		if (head == null) {
			head = tail = temp;
			return;
		}
		if (item.compareTo(head.value) < 0) {
			temp.next = head;
			head = temp;
			return;
		}
		if (item.compareTo(tail.value) > 0) {
			tail.next = temp;
			tail = tail.next;
			return;
		}
		while (curr.value.compareTo(item) < 0) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = temp;
		temp.next = curr;
	}

	public void deleteFirst() {
		if (head == null)
			System.out.println(" Underflow !");
		else if (head == tail)
			head = tail = null;
		else
			head = head.next;
	}

	public void deleteLast() {
		if (head == null)
			System.out.println(" Underflow !");
		else if (head == tail)
			head = tail = null;
		else {
			ListNode<T> current = head;
			ListNode<T> prev = current;
			while (current.next != null) {
				prev = current;
				current = current.next;
			}
			tail = prev;
			tail.next = null;
		}
	}

	public void deleteItem(T item) {
		boolean deleted = false;
		if (head == null) {
			System.out.println(" Underflow !");
			return;
		}
		while (head == tail || (head.value.compareTo(item) == 0)) {
			deleteFirst();
			deleted = true;
		}
		while (tail.value.compareTo(item) == 0) {
			deleteLast();
			deleted = true;
		}
		if (!deleted) {
			ListNode<T> curr = head;
			ListNode<T> prev = curr;
			while (curr != null) {
				if (curr.value.compareTo(item) == 0) {
					prev.next = curr.next;
					curr = prev.next;
					continue;
				}
				prev = curr;
				curr = curr.next;
			}
		}
	}

	public void display() {
		ListNode<T> curr = head;
		System.out.print("LIST : ");
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		LinkedList<Integer> list = new LinkedList<Integer>();
		char ch = 'y';
		System.out.println("MENU");
		System.out.println("1. Enqueue");
		System.out.println("2. Push");
		System.out.println("3. Insert in order");
		System.out.println("4. Dequeue");
		System.out.println("5. Pop");
		System.out.println("6. Delete Item");
		do {
			System.out.println("Enter the choice : ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the element to be queued : ");
				list.addLast(in.nextInt());
				break;
			case 2:
				System.out.println("Enter the element to be pushed : ");
				list.addFirst(in.nextInt());
				break;
			case 3:
				System.out.println("Enter the element to be inserted : ");
				list.addInOrder(in.nextInt());
				break;
			case 4:
				list.deleteLast();
				break;
			case 5:
				list.deleteFirst();
				break;
			case 6:
				System.out.println("Enter the Item to be deleted : ");
				list.deleteItem(in.nextInt());
				break;
			default:
				System.out.println("Wrong Choice !! ");
			}
			if (list.head != null)
				list.display();
			System.out.println();
			System.out.println("Want to continue(y/n) ? ");
			ch = in.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
		in.close();
	}
}
