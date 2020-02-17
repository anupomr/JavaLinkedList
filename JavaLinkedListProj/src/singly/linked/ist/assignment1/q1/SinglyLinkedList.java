package singly.linked.ist.assignment1.q1;

public class SinglyLinkedList<E> {

	// nested Node class
	protected static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		// public methods
		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	// instance variables
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	// constructor
	public SinglyLinkedList() {
	}

	// access methods
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;
		return head.getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0) {
			tail = head;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}

	public E removeFirst() {
		if (isEmpty())
			return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0) {
			tail = null;
		}
		return answer;
	}

	// print all nodes
	public void printAll() {
		System.out.println("Below is all the elements of the SinglyLinkedList");
		Node<E> current = head;
		while (current != null) {
			System.out.println(current.getElement());
			current = current.getNext();
		}
	}

	public static void main(String[] args) {

	}

}
