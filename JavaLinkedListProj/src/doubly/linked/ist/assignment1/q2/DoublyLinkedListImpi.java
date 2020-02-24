package doubly.linked.ist.assignment1.q2;

public class DoublyLinkedListImpi<E> {
	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedListImpi() {
		size = 0;
	}

	private class Node {
		E element;
		Node next;
		Node prev;

		public Node(E element, Node next, Node prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}

	}
	
	public int size() { return size; }
	
	public boolean isEmpty() { return size == 0; }
	
	
	

	public static void main(String[] args) {

	}

}
