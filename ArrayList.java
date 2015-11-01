import java.util.Scanner;

/**
 * @author Sanjay Gandhi
 * 
 *
 */
public class ArrayList<T extends Comparable<T>> {

	int ptr = 0;
	T[] list;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		// TODO Auto-generated constructor stub
		list = (T[]) new Comparable[10];
	}

	@SuppressWarnings("unchecked")
	public void addLast(T item) {
		if (ptr == list.length) {
			T[] newList = (T[]) new Comparable[list.length * 2];
			System.arraycopy(list, 0, newList, 0, list.length);
			list = newList;
			list[ptr++] = item;
		} else
			list[ptr++] = item;
	}

	@SuppressWarnings("unchecked")
	public void addFirst(T item) {
		if (ptr == list.length) {
			T[] newList = (T[]) new Comparable[list.length * 2];
			System.arraycopy(list, 0, newList, 0, list.length);
			list = newList;
		}
		for (int i = ptr; i > 0; i--)
			list[i] = list[i - 1];
		ptr++;
		list[0] = item;
	}

	@SuppressWarnings("unchecked")
	public void addIndex(T item, int index) {
		if (ptr == list.length) {
			T[] newList = (T[]) new Comparable[list.length * 2];
			System.arraycopy(list, 0, newList, 0, list.length);
			list = newList;
		}
		for (int i = ptr; i > index; i--)
			list[i] = list[i - 1];
		ptr++;
		list[index] = item;
	}

	@SuppressWarnings("unchecked")
	public void addInOrder(T item) {
		if (ptr == list.length) {
			T[] newList = (T[]) new Comparable[list.length * 2];
			System.arraycopy(list, 0, newList, 0, list.length);
			list = newList;
		}
		int index;
		for (index = 0; index < ptr; index++)
			if (list[index].compareTo(item) > 0)
				break;
		for (int i = ptr; i > index; i--)
			list[i] = list[i - 1];
		ptr++;
		list[index] = item;
	}

	@SuppressWarnings("unchecked")
	public void deleteFirst() {
		if (ptr == 0) {
			System.out.println("UNDERFLOW !!");
			return;
		}
		for (int i = 0; i < ptr; i++)
			list[i] = list[i + 1];
		ptr--;
		if (ptr < list.length / 2 && list.length > 10) {
			T[] newList = (T[]) new Comparable[list.length / 2];
			System.arraycopy(list, 0, newList, 0, list.length/2);
			list = newList;
		}
	}

	@SuppressWarnings("unchecked")
	public void deleteLast() {
		if (ptr == 0) {
			System.out.println("UNDERFLOW !!");
			return;
		}
		ptr--;
		list[ptr] = null;
		if (ptr < list.length / 2 && list.length > 10) {
			T[] newList = (T[]) new Comparable[list.length / 2];
			System.arraycopy(list, 0, newList, 0, list.length/2);
			list = newList;
		}
	}

	@SuppressWarnings("unchecked")
	public void deleteItem(T item) {
		if (ptr == 0) {
			System.out.println("UNDERFLOW !!");
			return;
		}
		int i;
		for (i = 0; i < ptr; i++)
			if (item.compareTo(list[i]) == 0) {
				for (int j = i; j < ptr; j++)
					list[j] = list[j + 1];
				ptr--;
				deleteItem(item);
				break;
			}
		if (ptr < list.length / 2 && list.length > 10) {
			T[] newList = (T[]) new Comparable[list.length / 2];
			System.arraycopy(list, 0, newList, 0, list.length/2);
			list = newList;
		}
	}

	@SuppressWarnings("unchecked")
	public void deleteIndex(int index) {
		if (ptr == 0) {
			System.out.println("UNDERFLOW !!");
			return;
		}
		if (index < ptr) {
			for (int j = index; j < ptr; j++)
				list[j] = list[j + 1];
			ptr--;
			if (ptr < list.length / 2 && list.length > 10) {
				T[] newList = (T[]) new Comparable[list.length / 2];
				System.arraycopy(list, 0, newList, 0, list.length/2);
				list = newList;
			}
		}
	}

	public void display() {
		System.out.print("LIST : ");
		for (int i = 0; i < ptr; i++)
			System.out.print(list[i] + " ");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		ArrayList inputArray = new ArrayList();
		char ch = 'y';
		System.out.println("MENU");
		System.out.println("1. Enqueue");
		System.out.println("2. Push");
		System.out.println("3. Insert @Index");
		System.out.println("4. Insert in order");
		System.out.println("5. Dequeue");
		System.out.println("6. Pop");
		System.out.println("7. Delete @Index");
		System.out.println("8. Delete Item");
		do {
			System.out.println("Enter the choice : ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the element to be queued : ");
				inputArray.addLast(in.next());
				break;
			case 2:
				System.out.println("Enter the element to be pushed : ");
				inputArray.addFirst(in.next());
				break;
			case 3:
				System.out.println("Enter the element and the index : ");
				inputArray.addIndex(in.next(), in.nextInt());
				break;
			case 4:
				System.out
						.println("Enter the element to be placed in order : ");
				inputArray.addInOrder(in.next());
				break;
			case 5:
				inputArray.deleteLast();
				break;
			case 6:
				inputArray.deleteFirst();
				break;
			case 7:
				System.out.println("Enter the index to be deleted : ");
				inputArray.deleteIndex(in.nextInt());
				break;
			case 8:
				System.out.println("Enter the Item to be deleted : ");
				inputArray.deleteItem(in.next());
				break;
			default:
				System.out.println("Wrong Choice !! ");
			}
			if (inputArray.ptr > 0)
				inputArray.display();
			System.out.println();
			System.out.println("Want to continue(y/n) ? ");
			ch = in.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
		in.close();
	}

}
